package pp.block4.cc.cfg;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import pp.block4.cc.ErrorListener;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/** Template bottom-up CFG builder. */
public class BottomUpCFGBuilder extends FragmentBaseListener {
    private ParseTreeProperty<Node> entries;
    private ParseTreeProperty<Node> exits;

    /**
     * The CFG being built.
     */
    private Graph graph;

    public BottomUpCFGBuilder() {
        entries = new ParseTreeProperty<>();
        exits = new ParseTreeProperty<>();
    }

    /**
     * Builds the CFG for a program contained in a given file.
     */
    public Graph build(File file) {
        Graph result = null;
        ErrorListener listener = new ErrorListener();
        try {
            CharStream chars = new ANTLRInputStream(new FileReader(file));
            Lexer lexer = new FragmentLexer(chars);
            lexer.removeErrorListeners();
            lexer.addErrorListener(listener);
            TokenStream tokens = new CommonTokenStream(lexer);
            FragmentParser parser = new FragmentParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(listener);
            ParseTree tree = parser.program();
            if (listener.hasErrors()) {
                System.out.printf("Parse errors in %s:%n", file.getPath());
                for (String error : listener.getErrors()) {
                    System.err.println(error);
                }
            } else {
                result = build(tree);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Builds the CFG for a program given as an ANTLR parse tree.
     */
    public Graph build(ParseTree tree) {
        graph = new Graph();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(this, tree);
        return graph;
    }

    /**
     * Adds a node to he CGF, based on a given parse tree node.
     * Gives the CFG node a meaningful ID, consisting of line number and
     * a further indicator.
     */
    private Node addNode(ParserRuleContext node, String text) {
        return graph.addNode(node.getStart().getLine() + ": " + text);
    }

    /**
     * Main method to build and print the CFG of a simple Java program.
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: [filename]+");
            return;
        }
        BottomUpCFGBuilder builder = new BottomUpCFGBuilder();
        for (String filename : args) {
            File file = new File(filename);
            System.out.println(filename);
            System.out.println(builder.build(file));
        }
    }

    @Override
    public void exitAssignStat(@NotNull FragmentParser.AssignStatContext ctx) {
        Node node = addNode(ctx, ctx.getText());
        entries.put(ctx, node);
        exits.put(ctx, node);
    }

    @Override
    public void exitBlockStat(@NotNull FragmentParser.BlockStatContext ctx) {
        Node enter = addNode(ctx, ctx.getText());
        Node exit = addNode(ctx, ctx.getText() + "_end");

        entries.put(ctx, enter);
        exits.put(ctx, exit);

        Node node = enter;
        for (FragmentParser.StatContext stat : ctx.stat()) {
            node.addEdge(entries.get(stat));
            node = exits.get(stat);
        }
        node.addEdge(exit);
    }

    @Override
    public void exitContStat(@NotNull FragmentParser.ContStatContext ctx) {
        // not implemented
    }

    @Override
    public void exitDecl(@NotNull FragmentParser.DeclContext ctx) {
        Node node = addNode(ctx, ctx.getText());
        entries.put(ctx, node);
        exits.put(ctx, node);
    }

    @Override
    public void exitPrintStat(@NotNull FragmentParser.PrintStatContext ctx) {
        Node node = addNode(ctx, ctx.getText());
        entries.put(ctx, node);
        exits.put(ctx, node);
    }

    @Override
    public void exitProgram(@NotNull FragmentParser.ProgramContext ctx) {
        Node node = new Node(-1);
        for (FragmentParser.StatContext stat : ctx.stat()) {
            node.addEdge(exits.get(stat));
            node = exits.get(stat);
        }
    }

    @Override
    public void exitWhileStat(@NotNull FragmentParser.WhileStatContext ctx) {
        Node enter = addNode(ctx, ctx.getText());
        Node exit = addNode(ctx, ctx.getText() + "_end");
        entries.put(ctx, enter);
        exits.put(ctx, exit);

        enter.addEdge(entries.get(ctx.stat()));
        enter.addEdge(exit);
        exits.get(ctx.stat()).addEdge(enter);

    }

    @Override
    public void exitIfStat(@NotNull FragmentParser.IfStatContext ctx) {
        Node enter = addNode(ctx, ctx.getText());
        entries.put(ctx, enter);

        Node exit = addNode(ctx, ctx.getText() + "_end");
        if (ctx.stat(1) == null) {
            enter.addEdge(entries.get(ctx.stat(0)));
            exits.get(ctx.stat(0)).addEdge(exit);
        } else {
            enter.addEdge(entries.get(ctx.stat(0)));
            exits.get(ctx.stat(0)).addEdge(entries.get(ctx.stat(1)));
            exits.get(ctx.stat(1)).addEdge(exit);
        }

        exits.put(ctx, exit);
    }

    @Override
    public void exitBreakStat(@NotNull FragmentParser.BreakStatContext ctx) {
        // not implemented
    }
}
