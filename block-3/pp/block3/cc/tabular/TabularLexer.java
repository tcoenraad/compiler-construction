// Generated from /Users/twancoenraad/Code/compiler-construction/block-3/pp/block3/cc/tabular/Tabular.g4 by ANTLR 4.5
package pp.block3.cc.tabular;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TabularLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, TABLE_OPTIONS=6, COMMENT=7, TEXT=8, 
		WS=9;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "TABLE_OPTIONS", "COMMENT", "TEXT", 
		"WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'\\begin{tabular}{'", "'}'", "'\\end{tabular}'", "'&'", "'\\\\'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, "TABLE_OPTIONS", "COMMENT", "TEXT", 
		"WS"
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


	public TabularLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Tabular.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\13h\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6"+
		"\3\6\3\7\6\7=\n\7\r\7\16\7>\3\b\3\b\7\bC\n\b\f\b\16\bF\13\b\3\b\3\b\3"+
		"\b\3\b\3\t\6\tM\n\t\r\t\16\tN\3\t\6\tR\n\t\r\t\16\tS\3\t\6\tW\n\t\r\t"+
		"\16\tX\3\t\6\t\\\n\t\r\t\16\t]\5\t`\n\t\3\n\6\nc\n\n\r\n\16\nd\3\n\3\n"+
		"\2\2\13\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\3\2\7\6\2))eenntt\3\2"+
		"\f\f\f\2\13\f\17\17\"\"%)^^aa}}\177\177\u02c8\u02c8\u0305\u0305\t\2%)"+
		"^^aa}}\177\177\u02c8\u02c8\u0305\u0305\5\2\13\f\17\17\"\"o\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\3\25\3\2\2\2\5&\3\2\2\2\7(\3\2\2\2\t\66"+
		"\3\2\2\2\138\3\2\2\2\r<\3\2\2\2\17@\3\2\2\2\21_\3\2\2\2\23b\3\2\2\2\25"+
		"\26\7^\2\2\26\27\7d\2\2\27\30\7g\2\2\30\31\7i\2\2\31\32\7k\2\2\32\33\7"+
		"p\2\2\33\34\7}\2\2\34\35\7v\2\2\35\36\7c\2\2\36\37\7d\2\2\37 \7w\2\2 "+
		"!\7n\2\2!\"\7c\2\2\"#\7t\2\2#$\7\177\2\2$%\7}\2\2%\4\3\2\2\2&\'\7\177"+
		"\2\2\'\6\3\2\2\2()\7^\2\2)*\7g\2\2*+\7p\2\2+,\7f\2\2,-\7}\2\2-.\7v\2\2"+
		"./\7c\2\2/\60\7d\2\2\60\61\7w\2\2\61\62\7n\2\2\62\63\7c\2\2\63\64\7t\2"+
		"\2\64\65\7\177\2\2\65\b\3\2\2\2\66\67\7(\2\2\67\n\3\2\2\289\7^\2\29:\7"+
		"^\2\2:\f\3\2\2\2;=\t\2\2\2<;\3\2\2\2=>\3\2\2\2><\3\2\2\2>?\3\2\2\2?\16"+
		"\3\2\2\2@D\7\'\2\2AC\n\3\2\2BA\3\2\2\2CF\3\2\2\2DB\3\2\2\2DE\3\2\2\2E"+
		"G\3\2\2\2FD\3\2\2\2GH\7\f\2\2HI\3\2\2\2IJ\b\b\2\2J\20\3\2\2\2KM\n\4\2"+
		"\2LK\3\2\2\2MN\3\2\2\2NL\3\2\2\2NO\3\2\2\2OQ\3\2\2\2PR\n\5\2\2QP\3\2\2"+
		"\2RS\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TV\3\2\2\2UW\n\4\2\2VU\3\2\2\2WX\3\2\2"+
		"\2XV\3\2\2\2XY\3\2\2\2Y`\3\2\2\2Z\\\n\4\2\2[Z\3\2\2\2\\]\3\2\2\2][\3\2"+
		"\2\2]^\3\2\2\2^`\3\2\2\2_L\3\2\2\2_[\3\2\2\2`\22\3\2\2\2ac\t\6\2\2ba\3"+
		"\2\2\2cd\3\2\2\2db\3\2\2\2de\3\2\2\2ef\3\2\2\2fg\b\n\2\2g\24\3\2\2\2\13"+
		"\2>DNSX]_d\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}