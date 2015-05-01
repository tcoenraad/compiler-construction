package pp.block2.cc.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import pp.block2.cc.NonTerm;
import pp.block2.cc.Symbol;
import pp.block2.cc.Term;
import pp.block2.cc.ll.Grammar;
import pp.block2.cc.ll.Grammars;
import pp.block2.cc.ll.LLCalc;
import pp.block2.cc.ll.AwesomeLLCalc;
import pp.block2.cc.ll.Sentence;

public class LLCalcTest {
    private Grammar g;
    private LLCalc calc;
    private NonTerm subj;
    private NonTerm obj;
    private NonTerm sent;
    private NonTerm mod;
    private Term adj;
    private Term noun;
    private Term verb;
    private Term end;

    @Before
    public void setup() {
        g = Grammars.makeSentence();
        calc = createCalc(g);

        subj = g.getNonterminal("Subject");
        obj = g.getNonterminal("Object");
        sent = g.getNonterminal("Sentence");
        mod = g.getNonterminal("Modifier");

        adj = g.getTerminal(Sentence.ADJECTIVE);
        noun = g.getTerminal(Sentence.NOUN);
        verb = g.getTerminal(Sentence.VERB);
        end = g.getTerminal(Sentence.ENDMARK);
    }

    /** Tests the LL-calculator for the Sentence grammar. */
    @Test
    public void testFirst() {
        assertEquals(set(adj, noun), calc.getFirst().get(sent));
        assertEquals(set(adj, noun), calc.getFirst().get(subj));
        assertEquals(set(adj, noun), calc.getFirst().get(obj));
        assertEquals(set(adj), calc.getFirst().get(mod));
    }

    @Test
    public void testFollow() {
        assertEquals(set(Symbol.EOF), calc.getFollow().get(sent));
        assertEquals(set(verb), calc.getFollow().get(subj));
        assertEquals(set(end), calc.getFollow().get(obj));
        assertEquals(set(noun, adj), calc.getFollow().get(mod));
    }

    @Test
    public void testLL1() {
        assertTrue(calc.isLL1());
        g.addRule(mod, mod, mod);
        calc = createCalc(g);
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
