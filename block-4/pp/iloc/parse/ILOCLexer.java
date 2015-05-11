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
		T__0=1, MINUS=2, COMMA=3, SEMI=4, LSQ=5, RSQ=6, DARROW=7, ARROW=8, ID=9, 
		SYMB=10, NUM=11, STR=12, COMMENT=13, WS=14;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'"
	};
	public static final String[] ruleNames = {
		"T__0", "LETTER", "DIGIT", "MINUS", "COMMA", "SEMI", "LSQ", "RSQ", "DARROW", 
		"ARROW", "ID", "SYMB", "NUM", "STR", "COMMENT", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\20l\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\7\f>\n\f\f\f\16\fA\13\f\3\r\3\r\3\r\3\16\5"+
		"\16G\n\16\3\16\6\16J\n\16\r\16\16\16K\3\17\3\17\3\17\3\17\7\17R\n\17\f"+
		"\17\16\17U\13\17\3\17\3\17\3\20\3\20\3\20\3\20\7\20]\n\20\f\20\16\20`"+
		"\13\20\3\20\3\20\5\20d\n\20\3\21\6\21g\n\21\r\21\16\21h\3\21\3\21\2\2"+
		"\22\3\3\5\2\7\2\t\4\13\5\r\6\17\7\21\b\23\t\25\n\27\13\31\f\33\r\35\16"+
		"\37\17!\20\3\2\b\4\2C\\c|\3\2\62;\4\2//aa\5\2\f\f\17\17$$\4\2\f\f\17\17"+
		"\5\2\13\f\17\17\"\"s\2\3\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\3#\3\2\2\2"+
		"\5%\3\2\2\2\7\'\3\2\2\2\t)\3\2\2\2\13+\3\2\2\2\r-\3\2\2\2\17/\3\2\2\2"+
		"\21\61\3\2\2\2\23\63\3\2\2\2\25\66\3\2\2\2\279\3\2\2\2\31B\3\2\2\2\33"+
		"F\3\2\2\2\35M\3\2\2\2\37X\3\2\2\2!f\3\2\2\2#$\7<\2\2$\4\3\2\2\2%&\t\2"+
		"\2\2&\6\3\2\2\2\'(\t\3\2\2(\b\3\2\2\2)*\7/\2\2*\n\3\2\2\2+,\7.\2\2,\f"+
		"\3\2\2\2-.\7=\2\2.\16\3\2\2\2/\60\7]\2\2\60\20\3\2\2\2\61\62\7_\2\2\62"+
		"\22\3\2\2\2\63\64\7?\2\2\64\65\7@\2\2\65\24\3\2\2\2\66\67\7/\2\2\678\7"+
		"@\2\28\26\3\2\2\29?\5\5\3\2:>\5\5\3\2;>\5\7\4\2<>\t\4\2\2=:\3\2\2\2=;"+
		"\3\2\2\2=<\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@\30\3\2\2\2A?\3\2\2\2"+
		"BC\7B\2\2CD\5\27\f\2D\32\3\2\2\2EG\5\t\5\2FE\3\2\2\2FG\3\2\2\2GI\3\2\2"+
		"\2HJ\5\7\4\2IH\3\2\2\2JK\3\2\2\2KI\3\2\2\2KL\3\2\2\2L\34\3\2\2\2MS\7$"+
		"\2\2NR\n\5\2\2OP\7^\2\2PR\7$\2\2QN\3\2\2\2QO\3\2\2\2RU\3\2\2\2SQ\3\2\2"+
		"\2ST\3\2\2\2TV\3\2\2\2US\3\2\2\2VW\7$\2\2W\36\3\2\2\2XY\7\61\2\2YZ\7\61"+
		"\2\2Z^\3\2\2\2[]\n\6\2\2\\[\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_a\3"+
		"\2\2\2`^\3\2\2\2ac\t\6\2\2bd\t\6\2\2cb\3\2\2\2cd\3\2\2\2d \3\2\2\2eg\t"+
		"\7\2\2fe\3\2\2\2gh\3\2\2\2hf\3\2\2\2hi\3\2\2\2ij\3\2\2\2jk\b\21\2\2k\""+
		"\3\2\2\2\f\2=?FKQS^ch\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}