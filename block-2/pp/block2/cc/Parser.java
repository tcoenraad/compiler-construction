package pp.block2.cc;

import org.antlr.v4.runtime.Lexer;

/** Interface for all parsers used in the lab session. */
public interface Parser {
	/** Converts a lexer instance into an AST. */
	public AST parse(Lexer lexer) throws ParseException;
}
