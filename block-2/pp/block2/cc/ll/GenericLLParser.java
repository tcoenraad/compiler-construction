package pp.block2.cc.ll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;

import pp.block2.cc.AST;
import pp.block2.cc.NonTerm;
import pp.block2.cc.ParseException;
import pp.block2.cc.Parser;
import pp.block2.cc.Symbol;
import pp.block2.cc.Term;

/** Generic table-driven LL(1)-parser. */
public class GenericLLParser implements Parser {
	public GenericLLParser(Grammar g) {
		this.g = g;
		this.calc = new MyLLCalc(g); // here use your own class
	}

	private final Grammar g;
	private final LLCalc calc;

	@Override
	public AST parse(Lexer lexer) throws ParseException {
		this.tokens = lexer.getAllTokens();
		this.index = 0;
		return parse(g.getStart());
	}

	/** Parses the start of the token stream according to a given
	 * symbol. If it is a terminal, that should be the first token;
	 * otherwise, it is a non-terminal that should be expanded 
	 * according to the next token in the token stream, using the
	 * FIRST+-lookup table and recursively calling {@link #parse(Rule)}
	 * @param symb the symbol according to which the token stream 
	 * should be parsed
	 * @return the sub-AST resulting from the parsing of symb;
	 * or null if the symbol expands to the empty string
	 * @throws ParseException if the symbol cannot be parsed
	 * because the token stream does not contain the expected symbols
	 */
	private AST parse(Symbol symb) throws ParseException {
		// fill in
	}

	/** Parses the start of the token stream according to a given
	 * rule, recursively calling {@link #parse(Symbol)} to process
	 * the RHS.
	 * @return the sub-AST resulting from the parsing of the rule.
	 * The top node is the node for the LHS of the rule, its direct
	 * children correspond to the symbols of the rule's RHS.
	 * @throws ParseException if the symbol cannot be parsed
	 * because the token stream does not contain the expected symbols
	 */
	private AST parse(Rule rule) throws ParseException {
		// fill in
	}

	/** Returns the next token, without moving the token index. */
	private Token peek() throws ParseException {
		if (index >= tokens.size()) {
			throw new ParseException("Reading beyond end of input");
		}
		return tokens.get(index);
	}

	/** Returns the next token and moves up the token index. */
	private Token next() throws ParseException {
		Token result = peek();
		index++;
		return result;
	}

	private int index;
	private List<? extends Token> tokens;

	/** Uses the lookup table to look up the rule to which
	 * a given nonterminal should be expanded.
	 * The next rule is determined by the next token, using the
	 * FIRST+-set of the nonterminal.
	 * @throws ParseException if the lookup table does not 
	 * contain a rule for the nonterminal in combination with
	 * the first token in the token stream.
	 */
	private Rule lookup(NonTerm nt) throws ParseException {
		Token next = peek();
		Rule result = getLL1Table().get(nt).get(next.getType());
		if (result == null) {
			throw new ParseException(String.format(
					"Line %d:%d - no rule for '%s' on token '%s'",
					next.getLine(), next.getCharPositionInLine(),
					nt.getName(), next));
		}
		return result;
	}

	/** Lazily builds and then returns the lookup table. */
	private Map<NonTerm, List<Rule>> getLL1Table() {
		if (ll1Table == null) {
			ll1Table = calcLL1Table();
		}
		return ll1Table;
	}

	/** Constructs the {@link #ll1Table}. */
	private Map<NonTerm, List<Rule>> calcLL1Table() {
		// fill in
	}

	/** Map from non-terminals to lists of rules indexed by token type. */
	private Map<NonTerm, List<Rule>> ll1Table;
}
