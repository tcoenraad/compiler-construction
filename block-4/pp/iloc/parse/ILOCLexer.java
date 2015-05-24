// Generated from /Users/twancoenraad/Code/compiler-construction/block-4/pp/iloc/parse/ILOC.g4 by ANTLR 4.5
package pp.iloc.parse;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ILOCLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, MINUS=2, COMMA=3, SEMI=4, LSQ=5, RSQ=6, DARROW=7, ARROW=8, ID=9, 
		SYMB=10, LAB=11, NUM=12, STR=13, COMMENT=14, WS=15;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "LETTER", "DIGIT", "MINUS", "COMMA", "SEMI", "LSQ", "RSQ", "DARROW", 
		"ARROW", "ID", "SYMB", "LAB", "NUM", "STR", "COMMENT", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "':'", "'-'", "','", "';'", "'['", "']'", "'=>'", "'->'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "MINUS", "COMMA", "SEMI", "LSQ", "RSQ", "DARROW", "ARROW", 
		"ID", "SYMB", "LAB", "NUM", "STR", "COMMENT", "WS"
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


	public ILOCLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ILOC.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\21m\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\7\f@\n\f\f\f\16\fC\13\f\3\r\3\r"+
		"\3\r\3\16\3\16\3\16\3\17\5\17L\n\17\3\17\6\17O\n\17\r\17\16\17P\3\20\3"+
		"\20\3\20\3\20\7\20W\n\20\f\20\16\20Z\13\20\3\20\3\20\3\21\3\21\3\21\3"+
		"\21\7\21b\n\21\f\21\16\21e\13\21\3\22\6\22h\n\22\r\22\16\22i\3\22\3\22"+
		"\2\2\23\3\3\5\2\7\2\t\4\13\5\r\6\17\7\21\b\23\t\25\n\27\13\31\f\33\r\35"+
		"\16\37\17!\20#\21\3\2\b\4\2C\\c|\3\2\62;\4\2//aa\5\2\f\f\17\17$$\4\2\f"+
		"\f\17\17\5\2\13\f\17\17\"\"s\2\3\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r"+
		"\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2"+
		"\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2"+
		"#\3\2\2\2\3%\3\2\2\2\5\'\3\2\2\2\7)\3\2\2\2\t+\3\2\2\2\13-\3\2\2\2\r/"+
		"\3\2\2\2\17\61\3\2\2\2\21\63\3\2\2\2\23\65\3\2\2\2\258\3\2\2\2\27;\3\2"+
		"\2\2\31D\3\2\2\2\33G\3\2\2\2\35K\3\2\2\2\37R\3\2\2\2!]\3\2\2\2#g\3\2\2"+
		"\2%&\7<\2\2&\4\3\2\2\2\'(\t\2\2\2(\6\3\2\2\2)*\t\3\2\2*\b\3\2\2\2+,\7"+
		"/\2\2,\n\3\2\2\2-.\7.\2\2.\f\3\2\2\2/\60\7=\2\2\60\16\3\2\2\2\61\62\7"+
		"]\2\2\62\20\3\2\2\2\63\64\7_\2\2\64\22\3\2\2\2\65\66\7?\2\2\66\67\7@\2"+
		"\2\67\24\3\2\2\289\7/\2\29:\7@\2\2:\26\3\2\2\2;A\5\5\3\2<@\5\5\3\2=@\5"+
		"\7\4\2>@\t\4\2\2?<\3\2\2\2?=\3\2\2\2?>\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3"+
		"\2\2\2B\30\3\2\2\2CA\3\2\2\2DE\7B\2\2EF\5\27\f\2F\32\3\2\2\2GH\7%\2\2"+
		"HI\5\27\f\2I\34\3\2\2\2JL\5\t\5\2KJ\3\2\2\2KL\3\2\2\2LN\3\2\2\2MO\5\7"+
		"\4\2NM\3\2\2\2OP\3\2\2\2PN\3\2\2\2PQ\3\2\2\2Q\36\3\2\2\2RX\7$\2\2SW\n"+
		"\5\2\2TU\7^\2\2UW\7$\2\2VS\3\2\2\2VT\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2"+
		"\2\2Y[\3\2\2\2ZX\3\2\2\2[\\\7$\2\2\\ \3\2\2\2]^\7\61\2\2^_\7\61\2\2_c"+
		"\3\2\2\2`b\n\6\2\2a`\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2d\"\3\2\2\2"+
		"ec\3\2\2\2fh\t\7\2\2gf\3\2\2\2hi\3\2\2\2ig\3\2\2\2ij\3\2\2\2jk\3\2\2\2"+
		"kl\b\22\2\2l$\3\2\2\2\13\2?AKPVXci\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}