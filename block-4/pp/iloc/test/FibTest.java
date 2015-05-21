package pp.iloc.test;

import org.junit.Test;
import pp.iloc.Assembler;
import pp.iloc.Simulator;
import pp.iloc.eval.Machine;
import pp.iloc.model.Program;
import pp.iloc.parse.FormatException;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@SuppressWarnings("javadoc")
public class FibTest {
    private final static String BASE_DIR = "block-4/pp/iloc/sample/";
    private final static boolean SHOW = false;

    @Test
    public void testAssemblerRegister() {
        Program p = parse("fib_reg");
        assertEquals(ints(0, 5, 10), p.getRegMap().get("r_n"));
        assertEquals(ints(1, 7, 8), p.getRegMap().get("r_x"));
        assertEquals(ints(2, 7, 8, 9), p.getRegMap().get("r_y"));
        assertEquals(ints(3, 7, 9, 12), p.getRegMap().get("r_z"));
        assertEquals(ints(4, 5, 10), p.getRegMap().get("r_1"));
        assertEquals(ints(5, 6), p.getRegMap().get("r_cmp"));
    }

    @Test
    public void testSimulatorRegister() {
        Program p = FibTest.parse("fib_reg");
        Machine c = new Machine();
        int z = c.init("z",1);
        int n = c.init("n", 5);
        c.setReg("r_arp", 0);
        new Simulator(p, c).run();
        if (SHOW) {
            System.out.println(c);
        }
        assertEquals(8, c.load(z));
    }

    @Test
    public void testAssemblerMemory() {
        Program p = parse("fib_mem");
        assertEquals(ints(0, 3, 5, 8, 9, 10, 14, 16, 17), p.getRegMap().get("r_a"));
        assertEquals(ints(2, 3, 6, 8, 9, 11, 13, 15, 16), p.getRegMap().get("r_b"));
        assertEquals(ints(1, 7, 8, 11, 12, 19), p.getRegMap().get("r_c"));
    }

    @Test
    public void testSimulatorMemory() {
        Program p = FibTest.parse("fib_mem");
        Machine c = new Machine();
        int n = c.init("n", 5);
        int x = c.init("x", 1);
        int y = c.init("y", 1);
        int z = c.init("z",1);
        c.setReg("r_arp", 0);

        new Simulator(p, c).run();

        if (SHOW) {
            System.out.println(c);
        }
        assertEquals(5, c.load(x));
        assertEquals(8, c.load(y));
        assertEquals(8, c.load(z));
    }

    private HashSet<Integer> ints(Integer... vals) {
        return new HashSet<>(Arrays.asList(vals));
    }

    private static Program parse(String filename) {
        File file = new File(filename + ".iloc");
        if (!file.exists()) {
            file = new File(BASE_DIR + filename + ".iloc");
        }
        try {
            Program result = Assembler.instance().assemble(file);
            String print = result.prettyPrint();
            if (SHOW) {
                System.out.println("Program " + file + ":");
                System.out.println(print);
            }
            Program other = Assembler.instance().assemble(print);
            assertEquals(result, other);
            return result;
        } catch (FormatException | IOException e) {
            fail(e.getMessage());
            return null;
        }
    }
}
