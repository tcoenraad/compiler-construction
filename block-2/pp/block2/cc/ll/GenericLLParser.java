package pp.block2.cc.ll;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;
import pp.block2.cc.*;

import java.util.*;

/** Generic table-driven LL(1)-parser. */
public class GenericLLParser implements Parser {

	private final Grammar g;
	private final LLCalc calc;

	public GenericLLParser(Grammar g) {
		this.g = g;
		this.calc = new AwesomeLLCalc(g);
		getLL1Table();
	}
    
	private Map<NonTerm, List<Rule>> getLL1Table() {
		if (ll1Table == null) {
			ll1Table = calcLL1Table();
		}
		return ll1Table;
	}

	/** Constructs the {@link #ll1Table}. */
	private Map<NonTerm, List<Rule>> calcLL1Table() {
		ll1Table = new HashMap<>();
		Map<Rule, Set<Term>> firstp = calc.getFirstp();

		for (NonTerm nt : g.getNonterminals()) {
			for (int i = 0; i < g.getTerminals().size(); i++) {
                ArrayList<Rule> list = new ArrayList<>();
				ll1Table.put(nt, list);
                for (int j = 0; j < g.getTerminals().size() + 1; j++) {
                    list.add(j, null);
                }
			}

            for (Rule p : g.getRules(nt)) {
                for (Symbol w : firstp.get(p)) {
                    if (w instanceof Term) {
                        List<Rule> l = ll1Table.get(p.getLHS());
                        l.set(((Term) w).getTokenType(), p);
                    }

                }
                if (p.getRHS().contains(Symbol.EOF)) {
                    List<Rule> l = ll1Table.get(p.getLHS());
                    l.set(l.size() - 1, p);
                }
            }
		}
		return ll1Table;
	}

	/** Map from non-terminals to lists of rules indexed by token type. */
	private Map<NonTerm, List<Rule>> ll1Table;

	@Override
	public AST parse(Lexer lexer) throws ParseException {
		AST tree = null;
		AST currentBranch = null;
		Token word = lexer.nextToken();
		Stack<Symbol> stack = new Stack<>();
		stack.push(Symbol.EOF);
		stack.push(g.getStart());
		Symbol focus = stack.lastElement();
		while (true){
			if (focus.equals(Symbol.EOF) && word.getText().equals("<EOF>")){
				return tree;
			} else if(focus instanceof Term || focus.equals(Symbol.EOF)) {
				if (((Term) focus).getTokenType() == word.getType() || word.equals("<EOF>")) {
					Symbol s = stack.pop();
					currentBranch.addChild(new AST((Term) s, word)); // adding branch
					word = lexer.nextToken();
					currentBranch = goUp(currentBranch, tree);
				} else if (focus.equals(Symbol.EMPTY)){
					stack.pop();
					currentBranch = goUp(currentBranch, tree);
				} else {
					throw new ParseException("Error while looking for symbol at top of stack");
				}
			} else {
				if (ll1Table.get(focus).get(word.getType()) != null){
					List<Symbol> l = ll1Table.get(focus).get(word.getType()).getRHS();
					Symbol s = stack.pop();
					if (tree == null){
						tree = new AST((NonTerm) s);
						currentBranch = tree;
					} else {
						int childrenLength = currentBranch.getChildren().size();
						currentBranch.addChild(new AST((NonTerm) s)); // adding branch
						currentBranch = currentBranch.getChildren().get(childrenLength); // switching branch
					}
					for (int i = l.size() - 1; i >= 0; i--) {
						stack.add(l.get(i));
					}
				} else{
					throw new ParseException("Error while expanding focus");
				}
			}
			focus = stack.lastElement();

		}
	}

	private AST goUp(AST currentBranch, AST tree) {
		if(currentBranch.equals(tree)){
			return currentBranch;
		} else if (currentBranch.isTerminal()){
			return goUp(goOneUp(currentBranch, tree), tree);
		} else if (finishedRule(currentBranch)){
			return goUp(goOneUp(currentBranch, tree), tree);
		} else{
			return currentBranch;
		}
	}

	private boolean finishedRule(AST currentBranch) {
		boolean finishedRule = false;
		if (currentBranch.isTerminal() || currentBranch.getSymbol().equals(Symbol.EMPTY)){
			finishedRule = true;
		} else {
			List<Rule> rules = g.getRules((NonTerm) currentBranch.getSymbol());
			for (int i = 0; !finishedRule && i < rules.size(); i++) {
                Rule rule = rules.get(i);
				if (currentBranch.getChildren().size() != rule.getRHS().size()) {
                    continue;
                }
                for (int j = 0; j < currentBranch.getChildren().size(); j++) {
                    finishedRule = currentBranch.getChildren().get(j).getSymbol().equals(rule.getRHS().get(j)) && // symbol on current branch and rule match
                            (currentBranch.getChildren().get(j).isTerminal() ||
                                    finishedRule(currentBranch.getChildren().get(j)));
                }
			}
		}
		return finishedRule;
	}

	private AST goOneUp(AST currentBranch, AST tree){
		if (tree.equals(currentBranch)){
			return tree;
		}
        for(int i = tree.getChildren().size() - 1; i >= 0; i--) {
            if (tree.getChildren().get(i).equals(currentBranch)){
                return tree;
            } else {
                return goOneUp(currentBranch, tree.getChildren().get(i));
            }
        }
		return null;
	}
}
