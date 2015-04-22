// Generated from /Users/twancoenraad/Code/compiler-construction/block-1/pp/block1/cc/antlr/CC14.g4 by ANTLR 4.5
package pp.block1.cc.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CC14 extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LA=1, LALA=2, LALALALI=3;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LA", "LALA", "LALALALI"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LA", "LALA", "LALALALI"
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


	public CC14(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CC14.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\5#\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\3\2\3\2\6\2\f\n\2\r\2\16\2\r\3\2\7\2\21\n\2\f\2\16\2\24"+
		"\13\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\7\4\37\n\4\f\4\16\4\"\13\4\2"+
		"\2\5\3\3\5\4\7\5\3\2\2%\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\3\t\3\2\2"+
		"\2\5\25\3\2\2\2\7\30\3\2\2\2\t\13\7N\2\2\n\f\7c\2\2\13\n\3\2\2\2\f\r\3"+
		"\2\2\2\r\13\3\2\2\2\r\16\3\2\2\2\16\22\3\2\2\2\17\21\7\"\2\2\20\17\3\2"+
		"\2\2\21\24\3\2\2\2\22\20\3\2\2\2\22\23\3\2\2\2\23\4\3\2\2\2\24\22\3\2"+
		"\2\2\25\26\5\3\2\2\26\27\5\3\2\2\27\6\3\2\2\2\30\31\5\3\2\2\31\32\5\3"+
		"\2\2\32\33\5\3\2\2\33\34\7N\2\2\34 \7k\2\2\35\37\7\"\2\2\36\35\3\2\2\2"+
		"\37\"\3\2\2\2 \36\3\2\2\2 !\3\2\2\2!\b\3\2\2\2\" \3\2\2\2\6\2\r\22 \2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}