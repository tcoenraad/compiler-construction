package pp.iloc.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;

import pp.iloc.Assembler;
import pp.iloc.model.Program;
import pp.iloc.parse.FormatException;

@SuppressWarnings("javadoc")
public class AssemblerTest {
	@Test
	public void testFig13() {
		Program p = parse("fig1-3");
		assertEquals(ints(0, 5, 6, 7, 8, 9), p.getRegLines().get("r_a"));
		assertEquals(ints(1, 5), p.getRegLines().get("r_2"));
		assertEquals(ints(0, 9), p.getSymbLines().get("a"));
	}

	@Test
	public void testFig13Init() {
		Program p = parse("fig1-3-init");
		assertEquals(ints(0, 5, 6, 7, 8, 9), p.getRegLines().get("r_a"));
		assertEquals(ints(1, 5), p.getRegLines().get("r_2"));
		assertEquals(ints(0, 9), p.getSymbLines().get("a"));
	}

	@Test
	public void testFig13Stack() {
		Program p = parse("fig1-3-stack");
		assertEquals(ints(0, 2, 3, 4, 6, 7, 8, 10, 11, 13, 14, 15), p
				.getRegLines().get("r_1"));
		assertEquals(ints(1, 2, 5, 6, 9, 10, 12, 14), p.getRegLines().get("r_2"));
		assertEquals(ints(0, 15), p.getSymbLines().get("a"));
	}

	private HashSet<Integer> ints(Integer... vals) {
		return new HashSet<>(Arrays.asList(vals));
	}

	Program parse(String filename) {
		File file = new File(filename + ".iloc");
		if (!file.exists()) {
			file = new File(BASE_DIR + filename + ".iloc");
		}
		try {
			Program result = Assembler.instance().assemble(file);
			String print = result.prettyPrint();
			if (SHOW) {
				System.out.println("Program " + file + ":");
				System.out.print(print);
			}
			Program other = Assembler.instance().assemble(print);
			assertEquals(result, other);
			return result;
		} catch (FormatException | IOException e) {
			fail(e.getMessage());
			return null;
		}
	}

	private final static String BASE_DIR = "pp/iloc/sample/";
	private final static boolean SHOW = true;
}
