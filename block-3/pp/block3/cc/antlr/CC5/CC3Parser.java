// Generated from /Users/twancoenraad/Code/compiler-construction/block-3/pp/block3/cc/antlr/CC5/CC3.g4 by ANTLR 4.5
package pp.block3.cc.antlr.CC5;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CC3Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		POWER=1, PLUS=2, EQUAL=3, LPAR=4, RPAR=5, NUM=6, BOOL=7, STR=8, WS=9;
	public static final int
		RULE_term = 0;
	public static final String[] ruleNames = {
		"term"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'^'", "'+'", "'='", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "POWER", "PLUS", "EQUAL", "LPAR", "RPAR", "NUM", "BOOL", "STR", 
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

	@Override
	public String getGrammarFileName() { return "CC3.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CC3Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class TermContext extends ParserRuleContext {
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	 
		public TermContext() { }
		public void copyFrom(TermContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParContext extends TermContext {
		public TerminalNode LPAR() { return getToken(CC3Parser.LPAR, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(CC3Parser.RPAR, 0); }
		public ParContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CC3Listener ) ((CC3Listener)listener).enterPar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CC3Listener ) ((CC3Listener)listener).exitPar(this);
		}
	}
	public static class EqualContext extends TermContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode EQUAL() { return getToken(CC3Parser.EQUAL, 0); }
		public EqualContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CC3Listener ) ((CC3Listener)listener).enterEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CC3Listener ) ((CC3Listener)listener).exitEqual(this);
		}
	}
	public static class NumberContext extends TermContext {
		public TerminalNode NUM() { return getToken(CC3Parser.NUM, 0); }
		public NumberContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CC3Listener ) ((CC3Listener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CC3Listener ) ((CC3Listener)listener).exitNumber(this);
		}
	}
	public static class BooleanContext extends TermContext {
		public TerminalNode BOOL() { return getToken(CC3Parser.BOOL, 0); }
		public BooleanContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CC3Listener ) ((CC3Listener)listener).enterBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CC3Listener ) ((CC3Listener)listener).exitBoolean(this);
		}
	}
	public static class StringContext extends TermContext {
		public TerminalNode STR() { return getToken(CC3Parser.STR, 0); }
		public StringContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CC3Listener ) ((CC3Listener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CC3Listener ) ((CC3Listener)listener).exitString(this);
		}
	}
	public static class HatContext extends TermContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode POWER() { return getToken(CC3Parser.POWER, 0); }
		public HatContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CC3Listener ) ((CC3Listener)listener).enterHat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CC3Listener ) ((CC3Listener)listener).exitHat(this);
		}
	}
	public static class PlusContext extends TermContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(CC3Parser.PLUS, 0); }
		public PlusContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CC3Listener ) ((CC3Listener)listener).enterPlus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CC3Listener ) ((CC3Listener)listener).exitPlus(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		return term(0);
	}

	private TermContext term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermContext _localctx = new TermContext(_ctx, _parentState);
		TermContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(10);
			switch (_input.LA(1)) {
			case LPAR:
				{
				_localctx = new ParContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(3); 
				match(LPAR);
				setState(4); 
				term(0);
				setState(5); 
				match(RPAR);
				}
				break;
			case NUM:
				{
				_localctx = new NumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(7); 
				match(NUM);
				}
				break;
			case BOOL:
				{
				_localctx = new BooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(8); 
				match(BOOL);
				}
				break;
			case STR:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(9); 
				match(STR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(23);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(21);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new HatContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(12);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(13); 
						match(POWER);
						setState(14); 
						term(8);
						}
						break;
					case 2:
						{
						_localctx = new PlusContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(15);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(16); 
						match(PLUS);
						setState(17); 
						term(7);
						}
						break;
					case 3:
						{
						_localctx = new EqualContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(18);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(19); 
						match(EQUAL);
						setState(20); 
						term(6);
						}
						break;
					}
					} 
				}
				setState(25);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0: 
			return term_sempred((TermContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: 
			return precpred(_ctx, 7);
		case 1: 
			return precpred(_ctx, 6);
		case 2: 
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\13\35\4\2\t\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\r\n\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\7\2\30\n\2\f\2\16\2\33\13\2\3\2\2\3\2\3\2\2\2!\2\f\3\2\2\2\4\5\b"+
		"\2\1\2\5\6\7\6\2\2\6\7\5\2\2\2\7\b\7\7\2\2\b\r\3\2\2\2\t\r\7\b\2\2\n\r"+
		"\7\t\2\2\13\r\7\n\2\2\f\4\3\2\2\2\f\t\3\2\2\2\f\n\3\2\2\2\f\13\3\2\2\2"+
		"\r\31\3\2\2\2\16\17\f\t\2\2\17\20\7\3\2\2\20\30\5\2\2\n\21\22\f\b\2\2"+
		"\22\23\7\4\2\2\23\30\5\2\2\t\24\25\f\7\2\2\25\26\7\5\2\2\26\30\5\2\2\b"+
		"\27\16\3\2\2\2\27\21\3\2\2\2\27\24\3\2\2\2\30\33\3\2\2\2\31\27\3\2\2\2"+
		"\31\32\3\2\2\2\32\3\3\2\2\2\33\31\3\2\2\2\5\f\27\31";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}