package pp.block3.cc.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pp.block3.cc.symbol.SymbolTable;

public class SymbolTableTest {
	private SymbolTable table;

	@Before
	public void initTable() {
		table = // construct an instance of your implementation
	}

	@Test
	public void testEmpty() {
		try {
			table.contains("aap");
		} catch (RuntimeException e) {
			Assert.fail("Using an empty table should not fail");
			// this is the expected behaviour
		}
		try {
			table.closeScope();
			Assert.fail("Closing the top-level scope should fail");
		} catch (RuntimeException e) {
			// this is the expected behaviour
		}
		table.openScope();
		table.closeScope();
		try {
			table.closeScope();
			Assert.fail("Closing the top-level scope should fail");
		} catch (RuntimeException e) {
			// this is the expected behaviour
		}
	}

	@Test
	public void testLookup() {
		assertFalse(table.contains("aap"));
		assertTrue(table.add("aap"));
		assertTrue(table.contains("aap"));
		assertFalse(table.add("aap"));
		assertFalse(table.contains("noot"));
		table.openScope();
		assertTrue(table.contains("aap"));
		assertFalse(table.contains("noot"));
		assertTrue(table.add("aap"));
		assertTrue(table.add("noot"));
		table.closeScope();
		assertTrue(table.contains("aap"));
		assertFalse(table.contains("noot"));
	}

	@Test
	public void testNesting() {
		table.openScope();
		assertTrue(table.add("aap"));
		table.openScope();
		assertTrue(table.add("aap"));
		table.openScope();
		assertTrue(table.contains("aap"));
		assertTrue(table.add("noot"));
		assertTrue(table.contains("noot"));
		table.closeScope();
		assertFalse(table.contains("noot"));
		table.openScope();
		assertFalse(table.contains("noot"));
		assertTrue(table.add("noot"));
		assertTrue(table.contains("noot"));
		table.closeScope();
		assertFalse(table.contains("noot"));
		table.closeScope();
		table.closeScope();
		assertFalse(table.contains("aap"));
		assertFalse(table.contains("noot"));
	}
}
