package pp.block2.cc.antlr;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.*;

import java.math.BigInteger;

public class Calculator extends ExpressionBaseListener {
    private ParseTreeProperty<BigInteger> values;
    private Boolean error;

    public Calculator() {
        this.values = new ParseTreeProperty<>();
        this.error = false;
    }

    public BigInteger evaluate(String text) {
        Lexer lexer = new ExpressionLexer(new ANTLRInputStream(text));
        ExpressionParser parser = new ExpressionParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.expression();
        new ParseTreeWalker().walk(this, tree);

        return error ? null : values.get(tree);
    }

    @Override
    public void exitParenthesis(ExpressionParser.ParenthesisContext tree) {
        BigInteger value = values.get(tree.getChild(1));
        values.put(tree, value);
    }
    @Override
    public void exitPower(ExpressionParser.PowerContext tree) {
        BigInteger value = values.get(tree.getChild(0)).pow(values.get(tree.getChild(2)).intValue());
        values.put(tree, value);
    }
    @Override
    public void exitMinus(ExpressionParser.MinusContext tree) {
        BigInteger value = BigInteger.ZERO.subtract(values.get(tree.getChild(1)));
        values.put(tree, value);
    }
    @Override
    public void exitMultiplication(ExpressionParser.MultiplicationContext tree) {
        BigInteger value = values.get(tree.getChild(0)).multiply(values.get(tree.getChild(2)));
        values.put(tree, value);
    }
    @Override
    public void exitAddition(ExpressionParser.AdditionContext tree) {
        BigInteger value = values.get(tree.getChild(0)).add(values.get(tree.getChild(2)));
        values.put(tree, value);
    }

    @Override
    public void exitSubtraction(ExpressionParser.SubtractionContext tree) {
        BigInteger value = values.get(tree.getChild(0)).subtract(values.get(tree.getChild(2)));
        values.put(tree, value);
    }
    @Override
    public void exitNumber(ExpressionParser.NumberContext tree) {
        BigInteger value = values.get(tree.getChild(0));
        values.put(tree, value);
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        try {
            values.put(node, new BigInteger(node.getText()));
        } catch (NumberFormatException e) {
            // operator
        }
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        error = true;
    }

    public ParseTreeProperty<BigInteger> getValues() {
        return values;
    }
}
