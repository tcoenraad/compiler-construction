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
    private Term epsilon = g.getTerminal(Sentence.ENDMARK);

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
            first.put((Symbol) iter.next(), new HashSet<Term>());
        }

        Map<Symbol, Set<Term>> firstOld = first;

        while(!firstOld.equals(first)){
            firstOld = first;
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
        Set<NonTerm> nonTerminals = g.getNonterminals();
        Map<NonTerm, Set<Term>> followOld = follow;
        while(!follow.equals(followOld)){
            followOld = follow;
            follow.put((Symbol) iter.next(), new HashSet<Term>());
            List<Rule> rules = g.getRules();
            for(int i=0; i < rules.size(); i++){
                Rule rule = rules.get(i);
                NonTerm A = rule.getLHS();
                List<Term> trailer = setToList(follow.get(A));
                List<Symbol> beta = rule.getRHS();
                for(int j=beta.size()-1; j >=0; j--){
                    if(beta.get(j) instanceof NonTerm){
                        follow.get(beta.get(j)) = mergeSets(follow.get(beta.get(j)), trailer);
                        if(first.get(beta.get(j)).contains(epsilon)){
                            trailer.addAll(minusEpsilon(first.get(beta.get(i))));
                        } else{
                            trailer = first.get(beta.get(j));
                        }
                    } else{
                        trailer = first.get(beta.get(j));
                    }
                }



            }

        }


    }

    private Set<Term> mergeSets(Set<Term> t1, Set<Term> t2){
        Iterator it = t2.iterator();
        while(it.hasNext()){
            Term t = it.next();
            if(!t1.contains(t)){
                t1.add(t);
            }
        }
    }

    private List<Term> minusEpsilon(Set<Term> t1){
        Iterator it = t1.iterator();
        List<Term> res = new ArrayList<Term>();
        while(it.hasNext()){
            Term t = it.next();
            if(!epsilon.equals(t)){
                res.add(t);
            }
        }
        return res;
    }

    private void setFirstPlus(){
        List<Rule> rules = g.getRules();
        for(int i=0; i < rules.size(); i++){
            Set<Term> terms = rules.get(i).getRHS();
            boolean noEpsilon = true;
            Iterator i1 = terms.iterator();
            while(i1.hasNext()){
                Set<Term> elementsFirst = first.get(i1.next());
                Iterator i2 = elementsFirst.iterator();
                while(i2.hasNext()){
                    noEpsilon = ((Term) i2.next()).equals(epsilon);
                }
                if(noEpsilon){
                    firstPlus(rules.get(i)) = first(rules.get(i).getRHS().get(i));
                } else{
                    Set<Term> t1 =  first(rules.get(i).getRHS().get(i));
                    Set<Term> t2 = follow(rules.get(i).getLHS());
                    Iterator i3 = t2.iterator();
                    while(i3.hasNext()){
                        t1.add(i3.next());
                    }
                    firstPlus(rules.get(i)) = t1;
                }
            }
        }
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