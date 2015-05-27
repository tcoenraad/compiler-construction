package pp.block5.cc.antlr;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;

import pp.block5.cc.ErrorListener;
import pp.block5.cc.ParseException;

/** Prettyprints a (number, word)-sentence and sums up the numbers. */
public class NumWordProcessor extends NumWordBaseVisitor<Integer> {
    @Override
    public Integer visitSentence(@NotNull NumWordParser.SentenceContext ctx) {
        int sum = 0;
        int i = 0;
        while (i < ctx.getChildCount() - 1) { // skip EOF
            sum += visit(ctx.getChild(i));
            visit(ctx.getChild(i + 1));

            if (ctx.getChildCount() - i > 5) { // two more entries to go
                System.out.print(", ");
            } else if (ctx.getChildCount() - i > 3) { // one more entry to go
                System.out.print(" and ");
            } else { // last entry
                System.out.println();
            }

            i = i + 2;
        }
        return sum;
    }

    @Override
    public Integer visitNumber(@NotNull NumWordParser.NumberContext ctx) {
        System.out.print(ctx.getText() + " ");
        return Integer.parseInt(ctx.getText());
    }

    @Override
    public Integer visitWord(@NotNull NumWordParser.WordContext ctx) {
        System.out.print(ctx.getText());
        return 0;
    }

    private static void process(NumWordProcessor grouper, String text) {
        try {
            System.out.printf("Processing '%s':%n", text);
            int result = grouper.group(text);
            System.out.println("Total: " + result);
        } catch (ParseException exc) {
            exc.print();
        }
    }

    /** Groups a given sentence and prints it to stdout.
     * Returns the sum of the numbers in the sentence.
     */
    public int group(String text) throws ParseException {
        CharStream chars = new ANTLRInputStream(text);
        ErrorListener listener = new ErrorListener();
        Lexer lexer = new NumWordLexer(chars);
        lexer.removeErrorListeners();
        lexer.addErrorListener(listener);
        TokenStream tokens = new CommonTokenStream(lexer);
        NumWordParser parser = new NumWordParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(listener);
        ParseTree tree = parser.sentence();
        listener.throwException();
        return visit(tree);
    }

    public static void main(String[] args) {
        NumWordProcessor grouper = new NumWordProcessor();
        if (args.length == 0) {
            process(grouper, "1sock2shoes 3 holes");
            process(grouper, "3 strands 10 blocks 11 weeks 15 credits");
            process(grouper, "1 2 3");
        } else {
            for (String text : args) {
                process(grouper, text);
            }
        }
    }
}
