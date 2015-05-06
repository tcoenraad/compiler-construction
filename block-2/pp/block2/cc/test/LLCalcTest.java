package pp.block2.cc.test;

import org.junit.Before;
import org.junit.Test;
import pp.block2.cc.NonTerm;
import pp.block2.cc.Symbol;
import pp.block2.cc.Term;
import pp.block2.cc.ll.*;

import java.util.*;

import static org.junit.Assert.*;

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
        Map<Symbol, Set<Term>> first = calc.getFirst();
        assertEquals(set(adj, noun), first.get(sent));
        assertEquals(set(adj, noun), first.get(subj));
        assertEquals(set(adj, noun), first.get(obj));
        assertEquals(set(adj), first.get(mod));
    }

    @Test
    public void testFollow() {
        Map<NonTerm, Set<Term>> follow = calc.getFollow();
        assertEquals(set(Symbol.EOF), follow.get(sent));
        assertEquals(set(verb), follow.get(subj));
        assertEquals(set(end), follow.get(obj));
        assertEquals(set(noun, adj), follow.get(mod));
    }

    @Test
    public void testFirstp() {
        Map<Rule, Set<Term>> firstp = calc.getFirstp();
        List<Rule> subjRules = g.getRules(subj);
        assertEquals(set(noun), firstp.get(subjRules.get(0)));
        assertEquals(set(adj), firstp.get(subjRules.get(1)));
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
        return new AwesomeLLCalc(g); // your implementation of LLCalc (Ex. 2-CC.5)
    }

    @SuppressWarnings("unchecked")
    private <T> Set<T> set(T... elements) {
        return new HashSet<>(Arrays.asList(elements));
    }
}
