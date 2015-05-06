package pp.block2.cc.test;

import org.junit.Before;
import org.junit.Test;
import pp.block2.cc.NonTerm;
import pp.block2.cc.Symbol;
import pp.block2.cc.Term;
import pp.block2.cc.ll.*;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Jip on 2-5-2015.
 */
public class CC4Test {
    private Grammar g;
    private LLCalc calc;
    private NonTerm l;
    private NonTerm r;
    private NonTerm q;
    private NonTerm r2;
    private NonTerm q2;

    private Term a;
    private Term b;
    private Term c;
    private Term epsilon;
    private Term eof;

    /** Tests the LL-calculator for the CC4 grammar. */
    @Before
    public void setup() {
        g = Grammars.makeCC4();
        calc = createCalc(g);
        // Define the non-terminals
        l = new NonTerm("L");
        r = new NonTerm("R");
        q = new NonTerm("Q");
        r2 = new NonTerm("R2");
        q2 = new NonTerm("Q2");
        // Define the terminals
        a = g.getTerminal(CC4.A);
        b = g.getTerminal(CC4.B);
        c = g.getTerminal(CC4.C);
        epsilon = Symbol.EMPTY;
        eof = Symbol.EOF;
    }

    @Test
    public void testFirst() {
        Map<Symbol, Set<Term>> first = calc.getFirst();
        assertEquals(set(a, b, c), first.get(l));
        assertEquals(set(a, c), first.get(r));
        assertEquals(set(b, epsilon), first.get(r2));
        assertEquals(set(b), first.get(q));
        assertEquals(set(b, c), first.get(q2));
        assertEquals(set(a), first.get(a));
        assertEquals(set(b), first.get(b));
        assertEquals(set(c), first.get(c));
        assertEquals(set(eof), first.get(eof));
        assertEquals(set(epsilon), first.get(epsilon));
    }

    @Test
    public void testFollow() {
        Map<NonTerm, Set<Term>> follow = calc.getFollow();
        assertEquals(set(eof), follow.get(l));
        assertEquals(set(a), follow.get(r));
        assertEquals(set(a), follow.get(r2));
        assertEquals(set(b), follow.get(q));
        assertEquals(set(b), follow.get(q));
    }

    @Test
    public void testFirstp() {
        Map<Rule, Set<Term>> firstp = calc.getFirstp();
        List<Rule> lRules = g.getRules(l);
        assertEquals(set(a, c), firstp.get(lRules.get(0)));
        assertEquals(set(b), firstp.get(lRules.get(1)));
        List<Rule> rRules = g.getRules(r);
        assertEquals(set(a), firstp.get(rRules.get(0)));
        assertEquals(set(c), firstp.get(rRules.get(1)));
        List<Rule> r2Rules = g.getRules(r2);
        assertEquals(set(b), firstp.get(r2Rules.get(0)));
        assertEquals(set(epsilon, a), firstp.get(r2Rules.get(1)));
        List<Rule> qRules = g.getRules(q);
        assertEquals(set(b), firstp.get(qRules.get(0)));
        List<Rule> q2Rules = g.getRules(q2);
        assertEquals(set(b), firstp.get(q2Rules.get(0)));
        assertEquals(set(c), firstp.get(q2Rules.get(1)));
    }

    @Test
    public void testLL1() {
        assertTrue(calc.isLL1());
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
