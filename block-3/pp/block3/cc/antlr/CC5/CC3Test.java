package pp.block3.cc.antlr.CC5;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;
import pp.block3.cc.antlr.CC5.CC3AttrParser.TermContext;

import static org.junit.Assert.assertEquals;

public class CC3Test {
    private final ParseTreeWalker walker = new ParseTreeWalker();
    private final CC3ulator cc3 = new CC3ulator();

    @Test
	public void testHat() {
		test(Type.NUM, "1^1");
        test(Type.ERR, "true^1");
		test(Type.STR, "'a'^1");

		test(Type.ERR, "1^true");
		test(Type.ERR, "true^true");
		test(Type.ERR, "'a'^true");

		test(Type.ERR, "1^'a'");
		test(Type.ERR, "true^'a'");
		test(Type.ERR, "'a'^'a'");
	}

	@Test
	public void testPlus() {
        test(Type.NUM, "1+1");
        test(Type.ERR, "true+1");
        test(Type.ERR, "'a'+1");

        test(Type.ERR, "1+true");
        test(Type.BOOL, "true+true");
        test(Type.ERR, "'a'+true");

        test(Type.ERR, "1+'a'");
        test(Type.ERR, "true+'a'");
        test(Type.STR, "'a'+'a'");
    }

	@Test
	public void testEqual() {
        test(Type.BOOL, "1=1");
        test(Type.ERR, "true=1");
        test(Type.ERR, "'a'=1");

        test(Type.ERR, "1=true");
        test(Type.BOOL, "true=true");
        test(Type.ERR, "'a'=true");

        test(Type.ERR, "1='a'");
        test(Type.ERR, "true='a'");
        test(Type.BOOL, "'a'='a'");
	}

	private void test(Type expected, String expr) {
		testCalc(expected, expr);
        testCC3Attr(expected, expr);
	}

    private void testCalc(Type expected, String expr) {
        ParseTree tree = parseCC3(expr);
        cc3.init();
        walker.walk(cc3, tree);
        assertEquals(expected, cc3.val(tree));
    }

    private void testCC3Attr(Type expected, String expr) {
        assertEquals(expected, parseCC3Attr(expr).type);
    }

	private ParseTree parseCC3(String text) {
		CharStream chars = new ANTLRInputStream(text);
        Lexer lexer = new CC3Lexer(chars);
		TokenStream tokens = new CommonTokenStream(lexer);
        CC3Parser parser = new CC3Parser(tokens);
		return parser.term();
	}

	private TermContext parseCC3Attr(String text) {
		CharStream chars = new ANTLRInputStream(text);
		Lexer lexer = new CC3AttrLexer(chars);
		TokenStream tokens = new CommonTokenStream(lexer);
		CC3AttrParser parser = new CC3AttrParser(tokens);
		return parser.term();
	}
}
