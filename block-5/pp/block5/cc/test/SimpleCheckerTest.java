package pp.block5.cc.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import pp.block5.cc.ParseException;
import pp.block5.cc.SimplePascalCompiler;
import pp.block5.cc.simple.Result;
import pp.block5.cc.simple.Type;

@SuppressWarnings("javadoc")
public class SimpleCheckerTest {
	private final static String BASE_DIR = "pp/block5/cc/sample";
	private final static String EXT = ".pascal";
	private final SimplePascalCompiler compiler = SimplePascalCompiler
			.instance();

	@Test
	public void testBasicTypes() throws IOException, ParseException {
		ParseTree tree = parse("basic");
		Result result = check(tree);
		ParseTree body = tree.getChild(3).getChild(1);
		ParseTree assX = body.getChild(1);
		assertEquals(Type.INT, result.getType(assX.getChild(0)));
		assertEquals(Type.INT, result.getType(assX.getChild(2)));
	}

	@Test
	public void testBasicEntries() throws IOException, ParseException {
		ParseTree tree = parse("basic");
		Result result = check(tree);
		ParseTree body = tree.getChild(3).getChild(1);
		ParseTree assX = body.getChild(1);
		assertEquals(assX.getChild(2), result.getEntry(assX));
		assertEquals(assX.getChild(2), result.getEntry(body));
	}

	@Test
	public void testBasicOffsets() throws IOException, ParseException {
		ParseTree tree = parse("basic");
		Result result = check(tree);
		ParseTree body = tree.getChild(3).getChild(1);
		ParseTree assX = body.getChild(1);
		assertEquals(0, result.getOffset(assX.getChild(0)));
	}

	@Test
	public void testGCD() throws IOException, ParseException {
		check(parse("gcd"));
	}

	@Test
	public void testPrime() throws IOException, ParseException {
		check(parse("prime"));
	}

	@Test
	public void testTypeErr() throws IOException {
		checkFail("typeErr1");
		checkFail("typeErr2");
	}

	private void checkFail(String filename) throws IOException {
		try {
			check(parse(filename));
			fail(filename + " shouldn't check but did");
		} catch (ParseException exc) {
			// this is the expected behaviour
		}
	}

	private ParseTree parse(String filename) throws IOException, ParseException {
		return this.compiler.parse(new File(BASE_DIR, filename + EXT));
	}

	private Result check(ParseTree tree) throws ParseException {
		return this.compiler.check(tree);
	}
}
