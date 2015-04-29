package pp.block2.cc.ll;

import pp.block2.cc.NonTerm;
import pp.block2.cc.Symbol;
import pp.block2.cc.Term;

import java.util.*;

public class LLCalcImpl implements LLCalc{
    public Map<Symbol, Set<Term>> first;
    public Map<NonTerm, Set<Term>> follow;
    public Map<Rule, Set<Term>> firstPlus;
    public Grammar g;

    public LLCalcImpl(Grammar g){
        this.g = g;
        first = new HashMap<Symbol, Set<Term>>();
        follow = new HashMap<NonTerm, Set<Term>>();
        firstPlus = new HashMap<Rule, Set<Term>>();
        setFirst();
        setFollow();
        setFirstPlus();
    }

    private void setFirst(){
        Term epsilon = g.getTerminal(Sentence.ENDMARK);
        Set<Term> terminals = g.getTerminals();
        Set<NonTerm> nonTerminals = g.getNonterminals();
        Iterator iter =  terminals.iterator();
        while(iter.hasNext()){
            Set<Term> terms = new HashSet<Term>();
            Term term = (Term) iter.next();
            terms.add(term);
            first.put((Symbol) term, terms);
        }
        iter = nonTerminals.iterator();
        while(iter.hasNext()){
            Set<Term> terms = new HashSet<Term>();
            first.put((Symbol) iter.next(), terms);
        }

        Map<Symbol, Set<Term>> firstOld = first;

        while(!firstOld.equals(first)){
            List<Rule> rules = g.getRules();

            for(int i=0; i < rules.size(); i++){
                Set<Term> rhs=new HashSet<Term>();
                List<Symbol> beta = rules.get(i).getRHS();
                //ik ga er hier vanuit dat alles in beta een terminal of nonterminal is
                iter = first.get(beta.get(0)).iterator();
                while(iter.hasNext()){
                    Term t = (Term) iter.next();
                    if(!t.equals(epsilon)){
                        rhs.add(t);
                    }
                }
                int k=0;
               while(k<beta.size()-1){
                    iter = first.get(beta.get(k)).iterator();
                    while(iter.hasNext()){
                        Term t = (Term) iter.next();
                        if(!t.equals(epsilon)){
                            rhs.add(t);
                        }
                    }
                   k++;
                }
                if(k==beta.size()-1 && first(beta.get(k)).contains(epsilon)){
                    rhs.add(epsilon);
                }
                Set<Term> terms = first(rules.get(i).getLHS());
                iter = rhs.iterator();
                while(iter.hasNext()){
                    terms.add(iter.next());
                }
                first.remove(rules.get(i).getLHS());
                first.put((Symbol) rules.get(i).getLHS(), terms);


            }
        }


    }



    private void setFollow(){

    }

    private void setFirsPlus(){

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
        return firstPlus;
    }

    /** Indicates if the grammar of this calculator instance is LL(1). */
    public boolean isLL1();


}