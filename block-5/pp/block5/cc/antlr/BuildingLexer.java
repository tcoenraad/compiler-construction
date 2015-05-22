// Generated from C:/Users/Jip/Documents/compiler-construction/block-5/pp/block5/cc/antlr\Building.g4 by ANTLR 4.5
package pp.block5.cc.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BuildingLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LSQ=1, RSQ=2, COLON=3, SEMI=4, ROOM=5, FLOOR=6, ID=7, WS=8;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LSQ", "RSQ", "COLON", "SEMI", "DIGIT", "LETTER", "NUMBER", "ROOM", "FLOOR", 
		"ID", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'['", "']'", "':'", "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LSQ", "RSQ", "COLON", "SEMI", "ROOM", "FLOOR", "ID", "WS"
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


	public BuildingLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Building.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\n<\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\6\b\'"+
		"\n\b\r\b\16\b(\3\t\3\t\3\t\3\n\3\n\3\n\3\13\6\13\62\n\13\r\13\16\13\63"+
		"\3\f\6\f\67\n\f\r\f\16\f8\3\f\3\f\2\2\r\3\3\5\4\7\5\t\6\13\2\r\2\17\2"+
		"\21\7\23\b\25\t\27\n\3\2\5\3\2\62;\4\2C\\c|\5\2\13\f\17\17\"\";\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\3\31\3\2\2\2\5\33\3\2\2\2\7\35\3\2\2\2\t\37\3"+
		"\2\2\2\13!\3\2\2\2\r#\3\2\2\2\17&\3\2\2\2\21*\3\2\2\2\23-\3\2\2\2\25\61"+
		"\3\2\2\2\27\66\3\2\2\2\31\32\7]\2\2\32\4\3\2\2\2\33\34\7_\2\2\34\6\3\2"+
		"\2\2\35\36\7<\2\2\36\b\3\2\2\2\37 \7=\2\2 \n\3\2\2\2!\"\t\2\2\2\"\f\3"+
		"\2\2\2#$\t\3\2\2$\16\3\2\2\2%\'\5\13\6\2&%\3\2\2\2\'(\3\2\2\2(&\3\2\2"+
		"\2()\3\2\2\2)\20\3\2\2\2*+\7t\2\2+,\5\17\b\2,\22\3\2\2\2-.\7h\2\2./\5"+
		"\17\b\2/\24\3\2\2\2\60\62\5\r\7\2\61\60\3\2\2\2\62\63\3\2\2\2\63\61\3"+
		"\2\2\2\63\64\3\2\2\2\64\26\3\2\2\2\65\67\t\4\2\2\66\65\3\2\2\2\678\3\2"+
		"\2\28\66\3\2\2\289\3\2\2\29:\3\2\2\2:;\b\f\2\2;\30\3\2\2\2\6\2(\638\3"+
		"\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}