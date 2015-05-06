package pp.block2.cc.ll;

import static pp.block2.cc.ll.Sentence.ADJECTIVE;
import static pp.block2.cc.ll.Sentence.ENDMARK;
import static pp.block2.cc.ll.Sentence.NOUN;
import static pp.block2.cc.ll.Sentence.VERB;

import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;

import pp.block2.cc.AST;
import pp.block2.cc.SymbolFactory;
import pp.block2.cc.NonTerm;
import pp.block2.cc.ParseException;
import pp.block2.cc.Parser;

public class SentenceParser implements Parser {
	public SentenceParser() {
		this.fact = new SymbolFactory(Sentence.class);
	}

	private final SymbolFactory fact;

	@Override
	public AST parse(Lexer lexer) throws ParseException {
		this.tokens = lexer.getAllTokens();
		this.index = 0;
		return parseSentence();
	}

	private List<? extends Token> tokens;

	private AST parseSentence() throws ParseException {
		AST result = new AST(SENT);
		// there is only one rule, no need to look at token
		result.addChild(parseSubject());
		result.addChild(parseToken(VERB));
		result.addChild(parseObject());
		result.addChild(parseToken(ENDMARK));
		return result;
	}

	private AST parseSubject() throws ParseException {
		AST result = new AST(SUBJ);
		Token next = peek();
		// choose between rules based on the lookahead
		switch (next.getType()) {
		case ADJECTIVE:
			result.addChild(parseModifier());
			result.addChild(parseSubject());
			break;
		case NOUN:
			result.addChild(parseToken(NOUN));
			break;
		default:
			throw unparsable(SUBJ);
		}
		return result;
	}

	private AST parseObject() throws ParseException {
		AST result = new AST(OBJ);
		Token next = peek();
		// choose between rules based on the lookahead
		switch (next.getType()) {
		case ADJECTIVE:
			result.addChild(parseModifier());
			result.addChild(parseObject());
			break;
		case NOUN:
			result.addChild(parseToken(NOUN));
			break;
		default:
			throw unparsable(OBJ);
		}
		return result;
	}

	private ParseException unparsable(NonTerm nt) {
		try {
			Token next = peek();
			return new ParseException(String.format(
					"Line %d:%d - could not parse '%s' at token '%s'",
					next.getLine(), next.getCharPositionInLine(), nt.getName(),
					fact.get(next.getType())));
		} catch (ParseException e) {
			return e;
		}
	}

	private AST parseModifier() throws ParseException {
		AST result = new AST(MOD);
		// there is only one rule, no need to look at the next token
		result.addChild(parseToken(ADJECTIVE));
		return result;
	}

	/** Creates an AST based on the expected token type. */
	private AST parseToken(int tokenType) throws ParseException {
		Token next = next();
		if (next.getType() != tokenType) {
			throw new ParseException(String.format(
					"Line %d:%d - expected token '%s' but found '%s'",
					next.getLine(), next.getCharPositionInLine(),
					fact.get(tokenType), fact.get(next.getType())));
		}
		return new AST(fact.getTerminal(tokenType), next);
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

	private static final NonTerm SENT = new NonTerm("Sentence");
	private static final NonTerm SUBJ = new NonTerm("Subject");
	private static final NonTerm OBJ = new NonTerm("Object");
	private static final NonTerm MOD = new NonTerm("Modifier");

	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Usage: [text]+");
		} else {
			for (String text : args) {
				CharStream stream = new ANTLRInputStream(text);
				Lexer lexer = new Sentence(stream);
				try {
					System.out.printf("Parse tree: %n%s%n",
							new SentenceParser().parse(lexer));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
