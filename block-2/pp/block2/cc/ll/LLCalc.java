package pp.block2.cc.ll;

import java.util.Map;
import java.util.Set;

import pp.block2.cc.NonTerm;
import pp.block2.cc.Symbol;
import pp.block2.cc.Term;

/** Interface for a calculator that determines for a given grammar
 * (to be passed in as an argument to the constructor) what the
 * FIRST, FOLLOWS and FIRST+-sets are.
 */
public interface LLCalc {
	/** Returns the FIRST-map for the grammar of this calculator instance. */
	public Map<Symbol, Set<Term>> getFirst();

	/** Returns the FOLLOW-map for the grammar of this calculator instance. */
	public Map<NonTerm, Set<Term>> getFollow();

	/** Returns the FIRST+-map for the grammar of this calculator instance. */
	public Map<Rule, Set<Term>> getFirstp();

	/** Indicates if the grammar of this calculator instance is LL(1). */
	public boolean isLL1();
}