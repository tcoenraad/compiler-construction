package pp.block1.cc.antlr;

import org.junit.Test;

public class ExampleTest {
	private static LexerTester tester = new LexerTester(Example.class);

	@Test
	public void succeedingTest() {
		tester.correct("while do");
		tester.correct("while while do");
		tester.yields("while while do", Example.WHILE, Example.WHILE,
				Example.DO);
		tester.wrong("whiledo done");
	}

	@Test
	public void failingAcceptanceTest() {
		// spaces in keywords are not in the rules, so claiming it's correct
		// will fail
		tester.correct("whi le do");
	}

	@Test
	public void failingYieldCount() {
		// the sequence consists of three dos, not two
		tester.yields("do dodo", Example.DO, Example.DO);
	}

	@Test
	public void failingYieldToken() {
		// the second token is a DO not a WHILE
		tester.yields("do dodo", Example.DO, Example.WHILE, Example.DO);
	}

	@Test
	public void failingRejectionTest() {
		// the following is perfectly fine, so claiming it's wrong will fail
		tester.wrong("whilewhiledodo");
	}
}
