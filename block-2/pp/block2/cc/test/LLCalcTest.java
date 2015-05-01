package pp.block2.cc.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
    /** Tests the LL-calculator for the Sentence grammar. */
    @Test
    public void testSentence() {
        Grammar g = Grammars.makeSentence();
        LLCalc calc = createCalc(g);
        NonTerm subj = g.getNonterminal("Subject");
        NonTerm obj = g.getNonterminal("Object");
        NonTerm sent = g.getNonterminal("Sentence");
        NonTerm mod = g.getNonterminal("Modifier");
        // FIRST sets
        Term adj = g.getTerminal(Sentence.ADJECTIVE);
        Term noun = g.getTerminal(Sentence.NOUN);
        Term verb = g.getTerminal(Sentence.VERB);
        Term end = g.getTerminal(Sentence.ENDMARK);
        assertEquals(set(adj, noun), calc.getFirst().get(sent));
        assertEquals(set(adj, noun), calc.getFirst().get(subj));
        assertEquals(set(adj, noun), calc.getFirst().get(obj));
        assertEquals(set(adj), calc.getFirst().get(mod));
        // FOLLOW sets
        assertEquals(set(Symbol.EOF), calc.getFollow().get(sent));
        assertEquals(set(verb), calc.getFollow().get(subj));
        assertEquals(set(end), calc.getFollow().get(obj));
        assertEquals(set(noun, adj), calc.getFollow().get(mod));
        // is-LL1-test
        assertTrue(calc.isLL1());
        // Without this (recursive) rule, the grammar is LL-1
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
