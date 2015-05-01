/**
 * 
 */
package pp.block2.cc.ll;

import pp.block2.cc.Symbol;
import pp.block2.cc.SymbolFactory;
import pp.block2.cc.NonTerm;
import pp.block2.cc.Term;

/**
 * Class containing some example grammars.
 * @author Arend Rensink
 *
 */
public class Grammars {
	/** Returns a grammar for simple English sentences. */
	public static Grammar makeSentence() {
		// Define the non-terminals
		NonTerm sent = new NonTerm("Sentence");
		NonTerm subj = new NonTerm("Subject");
		NonTerm obj = new NonTerm("Object");
		NonTerm mod = new NonTerm("Modifier");
		// Define the terminals, using the Sentence.g4 lexer grammar
		SymbolFactory fact = new SymbolFactory(Sentence.class);
		Term noun = fact.getTerminal(Sentence.NOUN);
		Term verb = fact.getTerminal(Sentence.VERB);
		Term adj = fact.getTerminal(Sentence.ADJECTIVE);
		Term end = fact.getTerminal(Sentence.ENDMARK);
		// Build the context free grammar
		Grammar g = new Grammar(sent);
		g.addRule(sent, subj, verb, obj, end);
		g.addRule(subj, noun);
		g.addRule(subj, mod, subj);
		g.addRule(obj, noun);
		g.addRule(obj, mod, obj);
		g.addRule(mod, adj);
		return g;
	}

    public static Grammar makeIf() {
        // Define the non-terminals
        NonTerm stat = new NonTerm("Stat");
        NonTerm elsePart = new NonTerm("ElsePart");
        // Define the terminals, using the If.g4 lexer grammar
        SymbolFactory fact = new SymbolFactory(If.class);
        Term assign = fact.getTerminal(If.ASSIGN);
        Term iffie = fact.getTerminal(If.IF);
        Term cond = fact.getTerminal(If.COND);
        Term then = fact.getTerminal(If.THEN);
        Term elsie = fact.getTerminal(If.ELSE);
        Term empty = Symbol.EMPTY;
        // Build the context free grammar
        Grammar g = new Grammar(stat);
        g.addRule(stat, assign);
        g.addRule(stat, iffie, cond, then, stat, elsePart);
        g.addRule(elsePart, elsie, stat);
        g.addRule(elsePart, empty);
        return g;
    }

}
