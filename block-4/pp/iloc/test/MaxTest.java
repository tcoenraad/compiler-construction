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
public class MaxTest {
    private final static String BASE_DIR = "block-4/pp/iloc/sample/";
    private final static boolean SHOW = true;

    @Test
    public void testAssembler() {
        Program p = parse("max");
        assertEquals(ints(0, 9, 11, 14), p.getRegMap().get("r_max"));
        assertEquals(ints(1, 3, 5, 12), p.getRegMap().get("r_i"));
        assertEquals(ints(2, 3), p.getRegMap().get("r_len"));
        assertEquals(ints(3, 4, 9, 10), p.getRegMap().get("r_cmp"));
        assertEquals(ints(5, 6, 7, 8), p.getRegMap().get("r_a"));
    }

    @Test(timeout = 1000)
    public void testSimulator() {
        Program p = MaxTest.parse("max");
        Machine c = new Machine();
        int[] a = {1, 4, 3, 2, 1};
        c.setNum("alength", a.length);
        c.init("a", a);
        c.setReg("r_arp", 0);

        new Simulator(p, c).run();

        if (SHOW) {
            System.out.println(c);
        }
    }

    private HashSet<Integer> ints(Integer... vals) {
        return new HashSet<>(Arrays.asList(vals));
    }

    public static Program parse(String filename) {
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
