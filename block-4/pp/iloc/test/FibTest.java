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
    public void testRegisterToRegister() {
        Program p = parse("fib_reg");
        testAssemblerRegister(p);
        testSimulatorRegister(p);
    }

    public void testAssemblerRegister(Program p) {
        assertEquals(ints(2, 7, 8), p.getRegMap().get("r_x"));
        assertEquals(ints(3, 7, 8, 9), p.getRegMap().get("r_y"));
        assertEquals(ints(0, 7, 9, 12), p.getRegMap().get("r_z"));
        assertEquals(ints(4, 5, 10), p.getRegMap().get("r_1"));
        assertEquals(ints(1, 5, 10), p.getRegMap().get("r_n"));
        assertEquals(ints(5, 6), p.getRegMap().get("r_cmp"));
    }

    public void testSimulatorRegister(Program p) {
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
    public void testMemoryToMemoery() {
        Program p = parse("fib_mem");
        testAssemblerMemory(p);
        testSimulatorMemory(p);
    }

    public void testAssemblerMemory(Program p) {
        assertEquals(ints(0, 3, 5, 8, 9, 10, 14, 16, 17), p.getRegMap().get("r_a"));
        assertEquals(ints(2, 3, 6, 8, 9, 11, 13, 15, 16), p.getRegMap().get("r_b"));
        assertEquals(ints(1, 7, 8, 11, 12, 19), p.getRegMap().get("r_c"));
    }

    public void testSimulatorMemory(Program p) {
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
        assertEquals(8, c.load(z));
        assertEquals(5, c.load(x));
        assertEquals(8, c.load(y));
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
