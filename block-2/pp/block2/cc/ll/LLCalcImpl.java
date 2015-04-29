package pp.block2.cc.ll;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import pp.block2.cc.NonTerm;
import pp.block2.cc.Symbol;
import pp.block2.cc.Term;

public class LLCalc{
    public Map<Symbol, Set<Term>> first;
    public Map<NonTerm, Set<Term>> follow;
    public Map<Rule, Set<Term>> first+;
    public Grammar g;

    public LLCalc(Grammar g){
        this.g = g;
        first = new HashMap<Symbol, Set<Term>>();
        follow = new HashMap<NonTerm, Set<Term>>();
        first+ = new HashMap<Rule, Set<Term>>();
        setFirst();
        setFollow();
        setFirst+();
    }

    private void setFirst(){
        Set<Term> terminals = g.getTerminals.size();
        Set<Term> nonTerminals = g.getNonTerminals.size();
        for(int i=0; i < terminals; i++){
            Set<Term>  terms = new HashSet<term>
            first.put(terminals.get(i), terms.put(terminals.get(i)));
        }
        for(int i=0; i < nonTerminals; i++){
            Set<Term>  terms = new HashSet<term>
            first.put(nonTerminals.get(i), terms);
        }
        Map<Symbol, Set<Term>> firstOld = first;
        List<Rule> rules = g.getRules();
        while(!firstOld.equals(first)){
            for(int i=0; i < rules.size(); i++){
                Rule rule = rules.get(i);
                List<Symbol> symbols = rule.getRHS()-epsilon;
                if(symbols.length()>0){
                    Set<Symbol> rhs = First.get(symbols.get(1));
                    int i=1;
                    while(First.get(symbols.get(i)).contains(epsilon)){
                        rhs = rhs + First.get(symbols.get(i+1)) - epsilon;
                        i++
                    }
                }
                if(i==symbols.length() && First.get(symbols.get(symbols.length())).contains(epsilon)){
                    rhs = rhs + epsilon
                }
                First(rule.getLHS()) =First(rule.getLHS()) + rhs;
            }
        }


    }



    private void setFollow(){

    }

    private void setFirst+(){

    }

    /** Returns the FIRST-map for the grammar of this calculator instance. */
    public Map<Symbol, Set<Term>> getFirst(){
        return first;
    }

    /** Returns the FOLLOW-map for the grammar of this calculator instance. */
    public Map<NonTerm, Set<Term>> getFollow(){
        return follow;
    }

    /** Returns the FIRST+-map for the grammar of this calculator instance. */
    public Map<Rule, Set<Term>> getFirstp(){
        return first+;
    }

    /** Indicates if the grammar of this calculator instance is LL(1). */
    public boolean isLL1();


}