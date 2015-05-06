// Generated from /Users/twancoenraad/Code/compiler-construction/block-2/pp/block2/cc/antlr/Sentence.g4 by ANTLR 4.5
package pp.block2.cc.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SentenceLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NOUN=1, VERB=2, ADJECTIVE=3, ENDMARK=4, WS=5, TYPO=6;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"NOUN", "VERB", "ADJECTIVE", "ENDMARK", "WS", "TYPO"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, "'love'", null, "'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "NOUN", "VERB", "ADJECTIVE", "ENDMARK", "WS", "TYPO"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override
	@NotNull
	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public SentenceLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Sentence.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\bI\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2!\n\2\3\3\3\3\3\3\3\3\3\3\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\5\4=\n\4\3\5\3\5\3\6\3\6\3\6\3\6\3\7\6\7F\n\7\r\7\16\7G\2\2"+
		"\b\3\3\5\4\7\5\t\6\13\7\r\b\3\2\4\5\2\13\f\17\17\"\"\4\2C\\c|L\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\3 \3"+
		"\2\2\2\5\"\3\2\2\2\7<\3\2\2\2\t>\3\2\2\2\13@\3\2\2\2\rE\3\2\2\2\17\20"+
		"\7u\2\2\20\21\7v\2\2\21\22\7w\2\2\22\23\7f\2\2\23\24\7g\2\2\24\25\7p\2"+
		"\2\25\26\7v\2\2\26!\7u\2\2\27\30\7e\2\2\30\31\7q\2\2\31\32\7o\2\2\32\33"+
		"\7r\2\2\33\34\7k\2\2\34\35\7n\2\2\35\36\7g\2\2\36\37\7t\2\2\37!\7u\2\2"+
		" \17\3\2\2\2 \27\3\2\2\2!\4\3\2\2\2\"#\7n\2\2#$\7q\2\2$%\7x\2\2%&\7g\2"+
		"\2&\6\3\2\2\2\'(\7c\2\2()\7n\2\2)=\7n\2\2*+\7u\2\2+,\7o\2\2,-\7c\2\2-"+
		".\7t\2\2.=\7v\2\2/\60\7w\2\2\60\61\7p\2\2\61\62\7f\2\2\62\63\7g\2\2\63"+
		"\64\7t\2\2\64\65\7i\2\2\65\66\7t\2\2\66\67\7c\2\2\678\7f\2\289\7w\2\2"+
		"9:\7c\2\2:;\7v\2\2;=\7g\2\2<\'\3\2\2\2<*\3\2\2\2</\3\2\2\2=\b\3\2\2\2"+
		">?\7\60\2\2?\n\3\2\2\2@A\t\2\2\2AB\3\2\2\2BC\b\6\2\2C\f\3\2\2\2DF\t\3"+
		"\2\2ED\3\2\2\2FG\3\2\2\2GE\3\2\2\2GH\3\2\2\2H\16\3\2\2\2\6\2 <G\3\b\2"+
		"\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}