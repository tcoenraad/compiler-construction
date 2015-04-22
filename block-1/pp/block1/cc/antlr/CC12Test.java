package pp.block1.cc.antlr;

import org.junit.Test;

public class CC12Test {
	private static LexerTester tester = new LexerTester(CC12.class);

	@Test
	public void test() {
		tester.correct("aaaaaa");
		tester.correct("aa11aa");
		tester.wrong("1aaaaa");
		tester.wrong("aaaaa");
		tester.wrong("aaaaaaa");
	}
}
