// Generated from ILOC.g4 by ANTLR 4.4
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
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, MINUS=2, COMMA=3, SEMI=4, LSQ=5, RSQ=6, DARROW=7, ARROW=8, ASS=9, 
		ID=10, SYMB=11, LAB=12, NUM=13, STR=14, COMMENT=15, WS=16, EOL=17;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'"
	};
	public static final String[] ruleNames = {
		"T__0", "LETTER", "DIGIT", "MINUS", "COMMA", "SEMI", "LSQ", "RSQ", "DARROW", 
		"ARROW", "ASS", "ID", "SYMB", "LAB", "NUM", "STR", "COMMENT", "WS", "EOL"
	};


	public ILOCLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ILOC.g4"; }

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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\23y\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3"+
		"\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r"+
		"\7\rG\n\r\f\r\16\rJ\13\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\5\20S\n\20"+
		"\3\20\6\20V\n\20\r\20\16\20W\3\21\3\21\3\21\3\21\7\21^\n\21\f\21\16\21"+
		"a\13\21\3\21\3\21\3\22\3\22\3\22\3\22\7\22i\n\22\f\22\16\22l\13\22\3\23"+
		"\6\23o\n\23\r\23\16\23p\3\23\3\23\3\24\6\24v\n\24\r\24\16\24w\2\2\25\3"+
		"\3\5\2\7\2\t\4\13\5\r\6\17\7\21\b\23\t\25\n\27\13\31\f\33\r\35\16\37\17"+
		"!\20#\21%\22\'\23\3\2\b\4\2C\\c|\3\2\62;\4\2//aa\5\2\f\f\17\17$$\4\2\f"+
		"\f\17\17\4\2\13\13\"\"\u0080\2\3\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r"+
		"\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2"+
		"\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2"+
		"#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\3)\3\2\2\2\5+\3\2\2\2\7-\3\2\2\2\t/\3"+
		"\2\2\2\13\61\3\2\2\2\r\63\3\2\2\2\17\65\3\2\2\2\21\67\3\2\2\2\239\3\2"+
		"\2\2\25<\3\2\2\2\27?\3\2\2\2\31B\3\2\2\2\33K\3\2\2\2\35N\3\2\2\2\37R\3"+
		"\2\2\2!Y\3\2\2\2#d\3\2\2\2%n\3\2\2\2\'u\3\2\2\2)*\7<\2\2*\4\3\2\2\2+,"+
		"\t\2\2\2,\6\3\2\2\2-.\t\3\2\2.\b\3\2\2\2/\60\7/\2\2\60\n\3\2\2\2\61\62"+
		"\7.\2\2\62\f\3\2\2\2\63\64\7=\2\2\64\16\3\2\2\2\65\66\7]\2\2\66\20\3\2"+
		"\2\2\678\7_\2\28\22\3\2\2\29:\7?\2\2:;\7@\2\2;\24\3\2\2\2<=\7/\2\2=>\7"+
		"@\2\2>\26\3\2\2\2?@\7>\2\2@A\7/\2\2A\30\3\2\2\2BH\5\5\3\2CG\5\5\3\2DG"+
		"\5\7\4\2EG\t\4\2\2FC\3\2\2\2FD\3\2\2\2FE\3\2\2\2GJ\3\2\2\2HF\3\2\2\2H"+
		"I\3\2\2\2I\32\3\2\2\2JH\3\2\2\2KL\7B\2\2LM\5\31\r\2M\34\3\2\2\2NO\7%\2"+
		"\2OP\5\31\r\2P\36\3\2\2\2QS\5\t\5\2RQ\3\2\2\2RS\3\2\2\2SU\3\2\2\2TV\5"+
		"\7\4\2UT\3\2\2\2VW\3\2\2\2WU\3\2\2\2WX\3\2\2\2X \3\2\2\2Y_\7$\2\2Z^\n"+
		"\5\2\2[\\\7^\2\2\\^\7$\2\2]Z\3\2\2\2][\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3"+
		"\2\2\2`b\3\2\2\2a_\3\2\2\2bc\7$\2\2c\"\3\2\2\2de\7\61\2\2ef\7\61\2\2f"+
		"j\3\2\2\2gi\n\6\2\2hg\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2k$\3\2\2\2"+
		"lj\3\2\2\2mo\t\7\2\2nm\3\2\2\2op\3\2\2\2pn\3\2\2\2pq\3\2\2\2qr\3\2\2\2"+
		"rs\b\23\2\2s&\3\2\2\2tv\t\6\2\2ut\3\2\2\2vw\3\2\2\2wu\3\2\2\2wx\3\2\2"+
		"\2x(\3\2\2\2\f\2FHRW]_jpw\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}