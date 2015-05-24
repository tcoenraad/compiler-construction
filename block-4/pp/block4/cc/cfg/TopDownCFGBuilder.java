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

/** Template top-down CFG builder. */
public class TopDownCFGBuilder extends FragmentBaseListener {
    private ParseTreeProperty<Node> entrances;
    private ParseTreeProperty<Node> exits;

    /**
     * The CFG being built.
     */
    private Graph graph;

    public TopDownCFGBuilder() {
        entrances = new ParseTreeProperty<>();
        exits = new ParseTreeProperty<>();
    }

    @Override
    public void enterAssignStat(@NotNull FragmentParser.AssignStatContext ctx) {
        entrances.get(ctx).addEdge(exits.get(ctx));
    }

    @Override
    public void enterBlockStat(@NotNull FragmentParser.BlockStatContext ctx) {
        Node entrance = entrances.get(ctx);
        Node exit = exits.get(ctx);

        Node node = entrance;
        for (FragmentParser.StatContext stat : ctx.stat()) {
            Node childEntry = addNode(stat, stat.getText());
            Node childExit = addNode(stat, stat.getText() + "_end");
            entrances.put(stat, childEntry);
            exits.put(stat, childExit);

            node.addEdge(childEntry);
            node = childExit;
        }
        node.addEdge(exit);
    }

    @Override
    public void enterContStat(@NotNull FragmentParser.ContStatContext ctx) {
        // not implemented
    }

    @Override
    public void enterDecl(@NotNull FragmentParser.DeclContext ctx) {
        entrances.get(ctx).addEdge(exits.get(ctx));
    }

    @Override
    public void enterPrintStat(@NotNull FragmentParser.PrintStatContext ctx) {
        entrances.get(ctx).addEdge(exits.get(ctx));
    }

    @Override
    public void enterProgram(@NotNull FragmentParser.ProgramContext ctx) {
        Node node = new Node(-1);
        for (FragmentParser.StatContext stat : ctx.stat()) {
            Node childEntry = addNode(stat, stat.getText());
            Node childExit = addNode(stat, stat.getText() + "_end");
            entrances.put(stat, childEntry);
            exits.put(stat, childExit);

            node.addEdge(childEntry);
            node = childExit;
        }
    }

    @Override
    public void enterWhileStat(@NotNull FragmentParser.WhileStatContext ctx) {
        Node entrance = entrances.get(ctx);
        Node exit = exits.get(ctx);

        Node childEntry = addNode(ctx.stat(), ctx.stat().getText());
        Node childExit = addNode(ctx.stat(), ctx.stat().getText() + "_end");
        entrances.put(ctx.stat(), childEntry);
        exits.put(ctx.stat(), childExit);

        entrance.addEdge(childEntry);
        entrance.addEdge(exit);
        childExit.addEdge(entrance);
    }

    @Override
    public void enterIfStat(@NotNull FragmentParser.IfStatContext ctx) {
        Node entrance = entrances.get(ctx);
        Node exit = exits.get(ctx);

        Node childIfEntry = addNode(ctx.stat(0), ctx.stat(0).getText());
        Node childIfExit = addNode(ctx.stat(0), ctx.stat(0).getText() + "_end");
        entrances.put(ctx.stat(0), childIfEntry);
        exits.put(ctx.stat(0), childIfExit);

        if (ctx.stat(1) == null) {
            entrance.addEdge(childIfEntry);
            childIfExit.addEdge(exit);
        } else {
            Node childElseEntry = addNode(ctx.stat(1), ctx.stat(1).getText());
            Node childElseExit = addNode(ctx.stat(1), ctx.stat(1).getText() + "_end");
            entrances.put(ctx.stat(1), childElseEntry);
            exits.put(ctx.stat(1), childElseExit);

            entrance.addEdge(childIfEntry);
            childIfExit.addEdge(exit);
            childElseExit.addEdge(exit);
        }
    }

    @Override
    public void enterBreakStat(@NotNull FragmentParser.BreakStatContext ctx) {
        // not implemented
    }

	/** Builds the CFG for a program contained in a given file. */
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

	/** Builds the CFG for a program given as an ANTLR parse tree. */
	public Graph build(ParseTree tree) {
        graph = new Graph();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(this, tree);
        return graph;
	}

	/** Adds a node to he CGF, based on a given parse tree node.
	 * Gives the CFG node a meaningful ID, consisting of line number and 
	 * a further indicator.
	 */
	private Node addNode(ParserRuleContext node, String text) {
		return this.graph.addNode(node.getStart().getLine() + ": " + text);
	}

	/** Main method to build and print the CFG of a simple Java program. */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Usage: [filename]+");
			return;
		}
		TopDownCFGBuilder builder = new TopDownCFGBuilder();
		for (String filename : args) {
			File file = new File(filename);
			System.out.println(filename);
			System.out.println(builder.build(file));
		}
	}
}
