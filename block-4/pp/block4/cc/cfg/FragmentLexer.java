// Generated from Fragment.g4 by ANTLR 4.4
package pp.block4.cc.cfg;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FragmentLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DOT=1, SEMI=2, COMMA=3, LSQ=4, RSQ=5, ASSIGN=6, NOT=7, OR=8, AND=9, BIT_OR=10, 
		BIT_AND=11, PLUS=12, MINUS=13, LT=14, GT=15, EQ=16, NE=17, LCURLY=18, 
		RCURLY=19, LPAR=20, RPAR=21, IN=22, PRINT=23, BOOL=24, INT=25, WHILE=26, 
		IF=27, ELSE=28, TRUE=29, FALSE=30, BREAK=31, CONTINUE=32, ID=33, NUM=34, 
		STRING=35, WS=36;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'", "'\"'", "'#'", "'$'"
	};
	public static final String[] ruleNames = {
		"DOT", "SEMI", "COMMA", "LSQ", "RSQ", "ASSIGN", "NOT", "OR", "AND", "BIT_OR", 
		"BIT_AND", "PLUS", "MINUS", "LT", "GT", "EQ", "NE", "LCURLY", "RCURLY", 
		"LPAR", "RPAR", "IN", "PRINT", "BOOL", "INT", "WHILE", "IF", "ELSE", "TRUE", 
		"FALSE", "BREAK", "CONTINUE", "LETTER", "DIGIT", "ID", "NUM", "STRING", 
		"WS"
	};


	public FragmentLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Fragment.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2&\u00de\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\3\2\3\2\3\3\3\3\3\4\3\4\3"+
		"\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f\3"+
		"\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22"+
		"\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32"+
		"\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35"+
		"\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3 \3"+
		" \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3#\3#\3$\3$\3$\7$\u00c3"+
		"\n$\f$\16$\u00c6\13$\3%\6%\u00c9\n%\r%\16%\u00ca\3&\3&\3&\3&\7&\u00d1"+
		"\n&\f&\16&\u00d4\13&\3&\3&\3\'\6\'\u00d9\n\'\r\'\16\'\u00da\3\'\3\'\2"+
		"\2(\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C\2E\2G#I$K%M&\3\2\6\4\2C\\c|\3\2\62;\4\2$$^^\5\2\13\f\17\17"+
		"\"\"\u00e1\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2"+
		"\2K\3\2\2\2\2M\3\2\2\2\3O\3\2\2\2\5Q\3\2\2\2\7S\3\2\2\2\tU\3\2\2\2\13"+
		"W\3\2\2\2\rY\3\2\2\2\17[\3\2\2\2\21]\3\2\2\2\23`\3\2\2\2\25c\3\2\2\2\27"+
		"e\3\2\2\2\31g\3\2\2\2\33i\3\2\2\2\35k\3\2\2\2\37m\3\2\2\2!o\3\2\2\2#r"+
		"\3\2\2\2%u\3\2\2\2\'w\3\2\2\2)y\3\2\2\2+{\3\2\2\2-}\3\2\2\2/\u0080\3\2"+
		"\2\2\61\u0087\3\2\2\2\63\u008f\3\2\2\2\65\u0093\3\2\2\2\67\u0099\3\2\2"+
		"\29\u009c\3\2\2\2;\u00a1\3\2\2\2=\u00a6\3\2\2\2?\u00ac\3\2\2\2A\u00b2"+
		"\3\2\2\2C\u00bb\3\2\2\2E\u00bd\3\2\2\2G\u00bf\3\2\2\2I\u00c8\3\2\2\2K"+
		"\u00cc\3\2\2\2M\u00d8\3\2\2\2OP\7\60\2\2P\4\3\2\2\2QR\7=\2\2R\6\3\2\2"+
		"\2ST\7.\2\2T\b\3\2\2\2UV\7]\2\2V\n\3\2\2\2WX\7_\2\2X\f\3\2\2\2YZ\7?\2"+
		"\2Z\16\3\2\2\2[\\\7#\2\2\\\20\3\2\2\2]^\7~\2\2^_\7~\2\2_\22\3\2\2\2`a"+
		"\7(\2\2ab\7(\2\2b\24\3\2\2\2cd\7~\2\2d\26\3\2\2\2ef\7(\2\2f\30\3\2\2\2"+
		"gh\7-\2\2h\32\3\2\2\2ij\7/\2\2j\34\3\2\2\2kl\7>\2\2l\36\3\2\2\2mn\7@\2"+
		"\2n \3\2\2\2op\7?\2\2pq\7?\2\2q\"\3\2\2\2rs\7#\2\2st\7?\2\2t$\3\2\2\2"+
		"uv\7}\2\2v&\3\2\2\2wx\7\177\2\2x(\3\2\2\2yz\7*\2\2z*\3\2\2\2{|\7+\2\2"+
		"|,\3\2\2\2}~\7k\2\2~\177\7p\2\2\177.\3\2\2\2\u0080\u0081\7r\2\2\u0081"+
		"\u0082\7t\2\2\u0082\u0083\7k\2\2\u0083\u0084\7p\2\2\u0084\u0085\7v\2\2"+
		"\u0085\u0086\7h\2\2\u0086\60\3\2\2\2\u0087\u0088\7d\2\2\u0088\u0089\7"+
		"q\2\2\u0089\u008a\7q\2\2\u008a\u008b\7n\2\2\u008b\u008c\7g\2\2\u008c\u008d"+
		"\7c\2\2\u008d\u008e\7p\2\2\u008e\62\3\2\2\2\u008f\u0090\7k\2\2\u0090\u0091"+
		"\7p\2\2\u0091\u0092\7v\2\2\u0092\64\3\2\2\2\u0093\u0094\7y\2\2\u0094\u0095"+
		"\7j\2\2\u0095\u0096\7k\2\2\u0096\u0097\7n\2\2\u0097\u0098\7g\2\2\u0098"+
		"\66\3\2\2\2\u0099\u009a\7k\2\2\u009a\u009b\7h\2\2\u009b8\3\2\2\2\u009c"+
		"\u009d\7g\2\2\u009d\u009e\7n\2\2\u009e\u009f\7u\2\2\u009f\u00a0\7g\2\2"+
		"\u00a0:\3\2\2\2\u00a1\u00a2\7v\2\2\u00a2\u00a3\7t\2\2\u00a3\u00a4\7w\2"+
		"\2\u00a4\u00a5\7g\2\2\u00a5<\3\2\2\2\u00a6\u00a7\7h\2\2\u00a7\u00a8\7"+
		"c\2\2\u00a8\u00a9\7n\2\2\u00a9\u00aa\7u\2\2\u00aa\u00ab\7g\2\2\u00ab>"+
		"\3\2\2\2\u00ac\u00ad\7d\2\2\u00ad\u00ae\7t\2\2\u00ae\u00af\7g\2\2\u00af"+
		"\u00b0\7c\2\2\u00b0\u00b1\7m\2\2\u00b1@\3\2\2\2\u00b2\u00b3\7e\2\2\u00b3"+
		"\u00b4\7q\2\2\u00b4\u00b5\7p\2\2\u00b5\u00b6\7v\2\2\u00b6\u00b7\7k\2\2"+
		"\u00b7\u00b8\7p\2\2\u00b8\u00b9\7w\2\2\u00b9\u00ba\7g\2\2\u00baB\3\2\2"+
		"\2\u00bb\u00bc\t\2\2\2\u00bcD\3\2\2\2\u00bd\u00be\t\3\2\2\u00beF\3\2\2"+
		"\2\u00bf\u00c4\5C\"\2\u00c0\u00c3\5C\"\2\u00c1\u00c3\5E#\2\u00c2\u00c0"+
		"\3\2\2\2\u00c2\u00c1\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4"+
		"\u00c5\3\2\2\2\u00c5H\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c7\u00c9\5E#\2\u00c8"+
		"\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2"+
		"\2\2\u00cbJ\3\2\2\2\u00cc\u00d2\7$\2\2\u00cd\u00d1\n\4\2\2\u00ce\u00cf"+
		"\7^\2\2\u00cf\u00d1\13\2\2\2\u00d0\u00cd\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1"+
		"\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d5\3\2"+
		"\2\2\u00d4\u00d2\3\2\2\2\u00d5\u00d6\7$\2\2\u00d6L\3\2\2\2\u00d7\u00d9"+
		"\t\5\2\2\u00d8\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00d8\3\2\2\2\u00da"+
		"\u00db\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd\b\'\2\2\u00ddN\3\2\2\2"+
		"\t\2\u00c2\u00c4\u00ca\u00d0\u00d2\u00da\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}