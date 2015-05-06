package pp.block2.cc.antlr;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
import pp.block2.cc.*;

import java.util.Stack;

public class SentenceConverter extends SentenceBaseListener implements Parser {
    private AST result;
    private String errorMessage;

    /** Factory needed to create terminals of the {@link Sentence}
     * grammar. See {@link pp.block2.cc.ll.SentenceParser} for
     * example usage. */
    private SymbolFactory factory;
    private Stack<AST> stack;

    @Override
    public AST parse(Lexer lexer) throws ParseException {
        this.stack = new Stack<>();
        factory = new SymbolFactory(lexer.getClass());

        SentenceParser parser = new SentenceParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.sentence();
        new ParseTreeWalker().walk(this, tree);
        if (errorMessage != null) {
            throw new ParseException(errorMessage);
        }
        return result;

    }

    // From here on overwrite the listener methods
    // Use an appropriate ParseTreeProperty to
    // store the correspondence from nodes to ASTs
    @Override
    public void enterSentence(SentenceParser.SentenceContext ctx) {
        result = new AST(new NonTerm("Sentence"));
        stack.push(result);
    }

    @Override
    public void enterSubject(SentenceParser.SubjectContext ctx) {
        AST subject = new AST(new NonTerm("Subject"));
        stack.peek().addChild(subject);
        stack.push(subject);
    }

    @Override
    public void enterModifier(SentenceParser.ModifierContext ctx) {
        AST modifier = new AST(new NonTerm("Modifier"));
        stack.peek().addChild(modifier);
        stack.push(modifier);
    }

    @Override
    public void enterObject(SentenceParser.ObjectContext ctx) {
        AST object = new AST(new NonTerm("Object"));
        stack.peek().addChild(object);
        stack.push(object);
    }
    @Override
    public void exitSentence(SentenceParser.SentenceContext ctx) {
        stack.pop();
    }

    @Override
    public void exitSubject(SentenceParser.SubjectContext ctx) {
        stack.pop();
    }

    @Override
    public void exitModifier(SentenceParser.ModifierContext ctx) {
        stack.pop();
    }

    @Override
    public void exitObject(SentenceParser.ObjectContext ctx) {
        stack.pop();
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        Term t = factory.getTerminal(node.getSymbol().getType());
        stack.peek().addChild(new AST(t, node.getSymbol()));
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        errorMessage = "Last error node: " + node.getText();
    }
}
