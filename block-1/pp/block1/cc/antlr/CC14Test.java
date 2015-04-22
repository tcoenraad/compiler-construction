package pp.block1.cc.antlr;

import org.junit.Test;

public class CC14Test {
	private static LexerTester tester = new LexerTester(CC14.class);

	@Test
	public void test() {
        tester.correct("La");
        tester.correct("Laaa");
        tester.correct("LaLa");
        tester.correct("LaLaLa");
        tester.correct("LaLaLaLi");
        tester.correct("LaLaLa Li");
        tester.correct("LaLa La Li");
        tester.correct("La La La Li");
        tester.correct("La  La  La  Li  ");
        tester.wrong("Li");
        tester.wrong("LaLi");
        tester.wrong("LaLaLi");
        tester.wrong("LaLaLaLii");
	}
}
