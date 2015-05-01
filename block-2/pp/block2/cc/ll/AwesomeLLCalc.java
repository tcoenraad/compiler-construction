package pp.block2.cc.ll;

import pp.block2.cc.NonTerm;
import pp.block2.cc.Symbol;
import pp.block2.cc.Term;

import java.util.*;

public class AwesomeLLCalc implements LLCalc {
    private Grammar grammar;
    private Map<Symbol, Set<Term>> first;
    private Map<NonTerm,Set<Term>> follow;
    private Map<Rule, Set<Term>> firstp;

    public AwesomeLLCalc(Grammar grammar) {
        this.grammar = grammar;
        calcFirst();
        calcFollow();
        calcFirstp();
    }

    public void calcFirst() {
        first = new HashMap<>();
        Set<Term> eofSet = new HashSet<>();
        eofSet.add(Symbol.EOF);
        first.put(Symbol.EOF, eofSet);

        Set<Term> epsilonSet = new HashSet<>();
        epsilonSet.add(Symbol.EMPTY);
        first.put(Symbol.EMPTY, epsilonSet);

        for (Term t : grammar.getTerminals()) {
            Set<Term> set = new HashSet<>();
            set.add(t);
            first.put(t, set);
        }
        for (NonTerm t : grammar.getNonterminals()) {
            first.put(t, new HashSet<>());
        }

        boolean diff = true;
        while (diff) {
            diff = false;

            for (Rule r : grammar.getRules()) {
                List<Symbol> beta = r.getRHS();

                Set<Term> rhs = new HashSet<>(first.get(beta.get(0)));
                rhs.remove(Symbol.EMPTY);

                int i = 0;
                while (i < beta.size() - 1 && first.get(beta.get(i)).contains(Symbol.EMPTY)) {
                    rhs.addAll(first.get(beta.get(i + 1)));
                    rhs.remove(Symbol.EMPTY);
                    i++;
                }

                if (i == beta.size() - 1 && first.get(beta.get(i)).contains(Symbol.EMPTY)) {
                    rhs.add(Symbol.EMPTY);
                }

                int oldLength = first.get(r.getLHS()).size();
                first.get(r.getLHS()).addAll(rhs);
                diff = diff || oldLength < first.get(r.getLHS()).size();
            }
        }
    }

    public void calcFollow() {
        follow = new HashMap<>();

        for (NonTerm t : grammar.getNonterminals()) {
            follow.put(t, new HashSet<>());
        }

        Set<Term> eofSet = new HashSet<>();
        eofSet.add(Symbol.EOF);
        follow.put(grammar.getStart(), eofSet);

        boolean diff = true;
        while (diff) {
            diff = false;

            for (Rule r : grammar.getRules()) {
                Set<Term> trailer = follow.get(r.getLHS());

                List<Symbol> beta = r.getRHS();
                for (int i = beta.size() - 1; i >= 0; i--) {
                    if (beta.get(i) instanceof NonTerm) {
                        int oldLength = follow.get(beta.get(i)).size();
                        follow.get(beta.get(i)).addAll(trailer);
                        diff = diff || oldLength < follow.get(beta.get(i)).size();
                        if (first.get(beta.get(i)).contains(Symbol.EMPTY)) {
                            trailer.addAll(first.get(beta.get(i)));
                            trailer.remove(Symbol.EMPTY);
                        } else {
                            trailer = new HashSet<>(first.get(beta.get(i)));
                        }
                    } else {
                        trailer = new HashSet<>(first.get(beta.get(i)));
                    }
                }
            }
        }
    }

    public void calcFirstp() {
        firstp = new HashMap<>();
        for (Rule r : grammar.getRules()) {
            Set<Term> firstSymbols = new HashSet<>(first.get(r.getRHS().get(0)));
            firstp.put(r, firstSymbols);
            if (firstSymbols.contains(Symbol.EMPTY)) {
                firstp.get(r).addAll(follow.get(r.getLHS()));
            }
        }
    }

    @Override
    public Map<Symbol, Set<Term>> getFirst() {
        return first;
    }

    @Override
    public Map<NonTerm, Set<Term>> getFollow() {
        return follow;
    }

    @Override
    public Map<Rule, Set<Term>> getFirstp() {
        return firstp;
    }

    @Override
    public boolean isLL1() {
        for (NonTerm nt : grammar.getNonterminals()) {
            for (Rule r : grammar.getRules(nt)) {
                for (Rule r2 : grammar.getRules(nt)) {
                    if (r != r2) {
                        Set<Term> intersection = new HashSet<>(firstp.get(r));
                        intersection.retainAll(firstp.get(r2));
                        if (!intersection.isEmpty()) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
