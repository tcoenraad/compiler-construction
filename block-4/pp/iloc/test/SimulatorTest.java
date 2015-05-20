package pp.iloc.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import pp.iloc.Assembler;
import pp.iloc.Simulator;
import pp.iloc.eval.Machine;
import pp.iloc.model.Program;
import pp.iloc.parse.FormatException;

@SuppressWarnings("javadoc")
public class SimulatorTest {
	@Test(timeout = 1000)
	public void testFig13() {
		Program p = parse("fig1-3");
		Machine c = new Machine();
		int a = c.init("a", 2);
		c.init("b", 3);
		c.init("c", 4);
		c.init("d", 5);
		c.setReg("r_arp", 0);
		new Simulator(p, c).run();
		if (SHOW) {
			System.out.println(c);
		}
		assertEquals(240, c.load(a));
	}

	Program parse(String filename) {
		File file = new File(filename + ".iloc");
		if (!file.exists()) {
			file = new File(BASE_DIR + filename + ".iloc");
		}
		try {
			return Assembler.instance().assemble(file);
		} catch (FormatException | IOException e) {
			fail(e.getMessage());
			return null;
		}
	}

	private final static String BASE_DIR = "pp/iloc/sample/";
	private final static boolean SHOW = true;
}
