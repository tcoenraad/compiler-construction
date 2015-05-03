package pp.block2.cc.ll;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;
import pp.block2.cc.*;

import java.util.*;

/** Generic table-driven LL(1)-parser. */
public class GenericLLParser implements Parser {
	public GenericLLParser(Grammar g) {
		this.g = g;
		this.calc = new AwesomeLLCalc(g);
		getLL1Table();
	}

	private final Grammar g;
	private final LLCalc calc;

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
		int numberOfTerms = g.getTerminals().size();
		for(NonTerm nt : g.getNonterminals()){
			for(Term t :g.getTerminals()){
				ll1Table.put(nt, new ArrayList<Rule>());
			}
		}
		for(Rule p: g.getRules()){
			for(Symbol w:firstp.get(p)){
				if(w instanceof Term){
					List<Rule> l = ll1Table.get(p.getLHS());
					for(int i=l.size(); i <= ((Term) w).getTokenType(); i++){
						l.add(i, null);
					}
					l.set(((Term)w).getTokenType(), p);
				}

			}
			if(p.getRHS().contains(Symbol.EOF)){
				List<Rule> l = ll1Table.get(p.getLHS());
				l.set(numberOfTerms, p);
			}
		}
		return ll1Table;
	}

	/** Map from non-terminals to lists of rules indexed by token type. */
	private Map<NonTerm, List<Rule>> ll1Table;

	@Override
	public AST parse(Lexer lexer) throws ParseException {
		AST result =null;
		AST current = null;
		Token word = lexer.nextToken();
		Stack<Symbol> stack = new Stack<>();
		stack.push(Symbol.EOF);
		stack.push(g.getStart());
		Symbol focus = stack.lastElement();
		while(true){
			if(focus.equals(Symbol.EOF) && word.getText().equals("<EOF>")){
				return result;
			} else if(focus instanceof Term || focus.equals(Symbol.EOF)) {
				if (((Term) focus).getTokenType() == word.getType() || word.equals("<EOF>")) {
					Symbol s = stack.pop();
					current.addChild(new AST((Term) s, word));
					word = lexer.nextToken();
					current = goUp(current, result);
				} else if (focus.equals(Symbol.EMPTY)){
					Symbol s = stack.pop();
					current = goOneUp(current, result);
					current = goUp(current, result);
				}else{
					throw new ParseException("Error while looking for symbol at top of stack");
				}
			}else{
				if(ll1Table.get((NonTerm) focus).get(word.getType())!=null){
					List<Symbol> l = ll1Table.get((NonTerm) focus).get(word.getType()).getRHS();
					Symbol s = stack.pop();
					if(result ==null){
						result = new AST((NonTerm) s);
						current = result;
					} else{
						int i=current.getChildren().size();
						current.addChild(new AST((NonTerm) s));
						current = current.getChildren().get(i);
					}
					for(int i = l.size()-1; i >=0; i-- ){
						stack.add(l.get(i));
					}
				} else{
					throw new ParseException("Error while expanding focus");
				}
			}
			focus = stack.lastElement();

		}
	}

	private AST goUp(AST current, AST result) {
		if(current.equals(result)){
			return current;
		}else if(current.isTerminal()){
			return goUp(goOneUp(current, result), result);
		} else if(finishedRule(current)){
			return goUp(goOneUp(current, result), result);
		} else{
			return current;
		}
	}

	private boolean finishedRule(AST current){
		boolean result = false;
		boolean empty=false;
		boolean workInProgress =false;
		if(current.isTerminal() || current.getSymbol().equals(Symbol.EMPTY)){
			result = true;
		} else if(current.getSymbol() instanceof NonTerm){
			List<Rule> rules = g.getRules((NonTerm) current.getSymbol());
			for(int i=0; !result && i < rules.size(); i++){
				result = !(rules.get(i).getRHS().contains(Symbol.EMPTY)) && current.getChildren().size()!=0 && current.getChildren().size() == rules.get(i).getRHS().size();
				if(result){
					int lengte = current.getChildren().size();
					for(int j=0; result && j < current.getChildren().size(); j++){

						result = rules.get(i).getRHS().get(0).equals(Symbol.EMPTY) || current.getChildren().get(j).getSymbol().equals(rules.get(i).getRHS().get(j)) &&
								(current.getChildren().get(j).isTerminal()?true: finishedRule(current.getChildren().get(j)));
						workInProgress = true;
					}

				}
				if(current.getChildren().size()==0){
					empty = rules.get(i).getRHS().get(0).equals(Symbol.EMPTY);
				}
			}
		} else{
			result = true;
		}
		return result || (!workInProgress&&empty);



	}

	private AST goOneUp(AST cur, AST res){
		if(res.equals(cur)){
			return res;
		}
		if(res.getChildren()!=null){
			for(int i=res.getChildren().size()-1; i>=0; i--){
				if(res.getChildren() != null && res.getChildren().get(i)!=null && res.getChildren().get(i).equals(cur)){
					return res;
				} else if(goOneUp(cur, res.getChildren().get(i))!= null) {
					return goOneUp(cur, res.getChildren().get(i));
				}

			}
		}
		return null;
	}
}
