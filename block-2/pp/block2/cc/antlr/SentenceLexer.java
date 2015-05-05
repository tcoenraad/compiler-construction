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
		T__0=1, NOUN=2, VERB=3, ADJECTIVE=4, ENDMARK=5, WS=6, TYPO=7;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "NOUN", "VERB", "ADJECTIVE", "ENDMARK", "WS", "TYPO"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", null, "'love'", null, "'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "NOUN", "VERB", "ADJECTIVE", "ENDMARK", "WS", "TYPO"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\tM\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3%\n\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5A\n\5\3\6\3\6\3\7\3\7\3\7\3\7\3\b\6\bJ\n"+
		"\b\r\b\16\bK\2\2\t\3\3\5\4\7\5\t\6\13\7\r\b\17\t\3\2\4\5\2\13\f\17\17"+
		"\"\"\4\2C\\c|P\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\3\21\3\2\2\2\5$\3\2\2\2\7&\3\2\2\2\t@"+
		"\3\2\2\2\13B\3\2\2\2\rD\3\2\2\2\17I\3\2\2\2\21\22\7.\2\2\22\4\3\2\2\2"+
		"\23\24\7u\2\2\24\25\7v\2\2\25\26\7w\2\2\26\27\7f\2\2\27\30\7g\2\2\30\31"+
		"\7p\2\2\31\32\7v\2\2\32%\7u\2\2\33\34\7e\2\2\34\35\7q\2\2\35\36\7o\2\2"+
		"\36\37\7r\2\2\37 \7k\2\2 !\7n\2\2!\"\7g\2\2\"#\7t\2\2#%\7u\2\2$\23\3\2"+
		"\2\2$\33\3\2\2\2%\6\3\2\2\2&\'\7n\2\2\'(\7q\2\2()\7x\2\2)*\7g\2\2*\b\3"+
		"\2\2\2+,\7c\2\2,-\7n\2\2-A\7n\2\2./\7u\2\2/\60\7o\2\2\60\61\7c\2\2\61"+
		"\62\7t\2\2\62A\7v\2\2\63\64\7w\2\2\64\65\7p\2\2\65\66\7f\2\2\66\67\7g"+
		"\2\2\678\7t\2\289\7i\2\29:\7t\2\2:;\7c\2\2;<\7f\2\2<=\7w\2\2=>\7c\2\2"+
		">?\7v\2\2?A\7g\2\2@+\3\2\2\2@.\3\2\2\2@\63\3\2\2\2A\n\3\2\2\2BC\7\60\2"+
		"\2C\f\3\2\2\2DE\t\2\2\2EF\3\2\2\2FG\b\7\2\2G\16\3\2\2\2HJ\t\3\2\2IH\3"+
		"\2\2\2JK\3\2\2\2KI\3\2\2\2KL\3\2\2\2L\20\3\2\2\2\6\2$@K\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}