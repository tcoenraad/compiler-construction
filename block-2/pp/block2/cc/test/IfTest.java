package pp.block2.cc.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import pp.block2.cc.NonTerm;
import pp.block2.cc.Symbol;
import pp.block2.cc.Term;
import pp.block2.cc.ll.*;

public class IfTest {
    private Grammar g;
    private LLCalc calc;
    private NonTerm stat;
    private NonTerm elsePart;
    private Term assign;
    private Term iffie;
    private Term cond;
    private Term then;
    private Term elsie;
    private Term epsilon;
    private Term eof;

    /** Tests the LL-calculator for the Sentence grammar. */
    @Before
    public void setup() {
        g = Grammars.makeIf();
        calc = createCalc(g);
        // Define the non-terminals
        stat = new NonTerm("Stat");
        elsePart = new NonTerm("ElsePart");
        // Define the terminals, using the If.g4 lexer grammar
        assign = g.getTerminal(If.ASSIGN);
        iffie = g.getTerminal(If.IF);
        cond = g.getTerminal(If.COND);
        then = g.getTerminal(If.THEN);
        elsie = g.getTerminal(If.ELSE);
        epsilon = Symbol.EMPTY;
        eof = Symbol.EOF;
    }

    @Test
    public void testFirst() {
        assertEquals(set(assign, iffie), calc.getFirst().get(stat));
        assertEquals(set(elsie, epsilon), calc.getFirst().get(elsePart));
        assertEquals(set(assign), calc.getFirst().get(assign));
        assertEquals(set(iffie), calc.getFirst().get(iffie));
        assertEquals(set(cond), calc.getFirst().get(cond));
        assertEquals(set(then), calc.getFirst().get(then));
        assertEquals(set(elsie), calc.getFirst().get(elsie));
        assertEquals(set(eof), calc.getFirst().get(eof));
        assertEquals(set(epsilon), calc.getFirst().get(epsilon));
    }

    @Test
    public void testFollow() {
        assertEquals(set(elsie, eof), calc.getFollow().get(stat));
        assertEquals(set(elsie, eof), calc.getFollow().get(elsePart));
    }

    @Test
    public void testFirstp() {
        Map<Rule, Set<Term>> firstp = calc.getFirstp();
        List<Rule> statRules = g.getRules(stat);
        assertEquals(set(assign), firstp.get(statRules.get(0)));
        assertEquals(set(iffie), firstp.get(statRules.get(1)));
        List<Rule> elsePartRules = g.getRules(elsePart);
        assertEquals(set(elsie), firstp.get(elsePartRules.get(0)));
        assertEquals(set(epsilon, eof, elsie), firstp.get(elsePartRules.get(1)));
    }

    @Test
    public void testLL1() {
        assertFalse(calc.isLL1());
    }

    /** Creates an LL1-calculator for a given grammar. */
    private LLCalc createCalc(Grammar g) {
        return new AwesomeLLCalc(g); // your implementation of LLCalc
    }

    @SuppressWarnings("unchecked")
    private <T> Set<T> set(T... elements) {
        return new HashSet<>(Arrays.asList(elements));
    }
}
