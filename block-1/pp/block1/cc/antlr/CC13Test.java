package pp.block1.cc.antlr;

import org.junit.Test;

public class CC13Test {
	private static LexerTester tester = new LexerTester(CC13.class);

	@Test
	public void test() {
		tester.correct("\"balalala\"");
		tester.correct("\"bala\"\"lala\"");
		tester.wrong("balalala");
		tester.wrong("\"bala\"lala\"");
		tester.wrong("\"bala\"lala\"\"");
	}
}
