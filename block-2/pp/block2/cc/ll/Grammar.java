/**
 * 
 */
package pp.block2.cc.ll;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import pp.block2.cc.NonTerm;
import pp.block2.cc.Symbol;
import pp.block2.cc.Term;

/**
 * Collection of rules with a start symbol.
 * @author Arend Rensink
 */
public class Grammar {
	public Grammar(NonTerm start) {
		this.start = start;
		this.rules = new ArrayList<>();
		this.ruleMap = new LinkedHashMap<>();
		this.nonTermMap = new LinkedHashMap<>();
		this.terminals = new HashSet<>();
		this.termList = new ArrayList<>();
	}

	/** Returns the start symbol of this grammar. */
	public NonTerm getStart() {
		return start;
	}

	private final NonTerm start;

	/** Adds a rule to this grammar, consisting of a given LHS and
	 * a sequence of RHS symbols. */
	public void addRule(NonTerm lhs, Symbol... rhs) {
		addRule(new Rule(lhs, rhs));
	}

	/** Adds a pre-constructed rule to this grammar. */
	public void addRule(Rule rule) {
		rules.add(rule);
		NonTerm lhs = rule.getLHS();
		List<Rule> lhsRules = ruleMap.get(lhs);
		if (lhsRules == null) {
			ruleMap.put(lhs, lhsRules = new ArrayList<>());
			nonTermMap.put(lhs.getName(), lhs);
		}
		lhsRules.add(rule);
		for (Symbol symbol : rule.getRHS()) {
			if (symbol instanceof Term) {
				Term term = (Term) symbol;
				terminals.add(term);
				int tokenType = term.getTokenType();
				if (tokenType != 0) {
					while (termList.size() <= tokenType) {
						termList.add(null);
					}
					Term oldTerm = termList.set(tokenType, term);
					assert oldTerm == null;
				}
			}
		}
	}

	public void addRule(NonTerm lhs, List<Symbol> rhs) {
		rules.add(new Rule(lhs, rhs));
	}

	/** Returns all rules of this grammar. */
	public List<Rule> getRules() {
		return rules;
	}

	private final List<Rule> rules;

	/** Returns the set of all nonterminals for which this grammar contains a rule. */
	public Set<NonTerm> getNonterminals() {
		return ruleMap.keySet();
	}

	/** Returns the nonterminal of a given name, if any. */
	public NonTerm getNonterminal(String name) {
		return nonTermMap.get(name);
	}

	/** Mapping from known non-terminal names to the corresponding non-terminals. */
	private final Map<String, NonTerm> nonTermMap;

	/** Returns all rules corresponding to a given LHS symbol. */
	public List<Rule> getRules(NonTerm lhs) {
		return ruleMap.get(lhs);
	}

	private final Map<NonTerm, List<Rule>> ruleMap;

	/** Returns the set of all terminals in the RHSs of this grammar. */
	public Set<Term> getTerminals() {
		return terminals;
	}

	private final Set<Term> terminals;

	/** Returns the terminal for a given token type. */
	public Term getTerminal(int tokenType) {
		return termList.get(tokenType);
	}

	private final List<Term> termList;

	@Override
	public String toString() {
		return "Rules: " + getRules() + "; Start symbol: "
				+ getStart().getName();
	}
}
