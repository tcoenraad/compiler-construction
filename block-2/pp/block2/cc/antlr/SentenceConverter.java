package pp.block2.cc.antlr;

import org.antlr.v4.runtime.Lexer;

import pp.block2.cc.AST;
import pp.block2.cc.Parser;
import pp.block2.cc.SymbolFactory;
import pp.block2.cc.ll.Sentence;

public class SentenceConverter //
		extends SentenceBaseListener implements Parser {
	public SentenceConverter() {
		this.fact = new SymbolFactory(Sentence.class);
	}

	/** Factory needed to create terminals of the {@link Sentence}
	 * grammar. See {@link pp.block2.cc.ll.SentenceParser} for
	 * example usage. */
	private final SymbolFactory fact;

	@Override
	public AST parse(Lexer lexer) {
		// Fill in
	}
	
	// From here on overwrite the listener methods
	// Use an appropriate ParseTreeProperty to
	// store the correspondence from nodes to ASTs
}
