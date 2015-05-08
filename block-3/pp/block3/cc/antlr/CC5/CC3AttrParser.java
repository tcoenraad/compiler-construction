// Generated from /Users/twancoenraad/Code/compiler-construction/block-3/pp/block3/cc/antlr/CC5/CC3Attr.g4 by ANTLR 4.5
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
public class CC3AttrParser extends Parser {
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
	public String getGrammarFileName() { return "CC3Attr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CC3AttrParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class TermContext extends ParserRuleContext {
		public Type type;
		public TermContext t0;
		public TermContext t1;
		public TerminalNode LPAR() { return getToken(CC3AttrParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(CC3AttrParser.RPAR, 0); }
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode NUM() { return getToken(CC3AttrParser.NUM, 0); }
		public TerminalNode BOOL() { return getToken(CC3AttrParser.BOOL, 0); }
		public TerminalNode STR() { return getToken(CC3AttrParser.STR, 0); }
		public TerminalNode POWER() { return getToken(CC3AttrParser.POWER, 0); }
		public TerminalNode PLUS() { return getToken(CC3AttrParser.PLUS, 0); }
		public TerminalNode EQUAL() { return getToken(CC3AttrParser.EQUAL, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CC3AttrListener ) ((CC3AttrListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CC3AttrListener ) ((CC3AttrListener)listener).exitTerm(this);
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
			setState(14);
			switch (_input.LA(1)) {
			case LPAR:
				{
				setState(3); 
				match(LPAR);
				setState(4); 
				((TermContext)_localctx).t0 = term(0);
				setState(5); 
				match(RPAR);
				 ((TermContext)_localctx).type =  ((TermContext)_localctx).t0.type; 
				}
				break;
			case NUM:
				{
				setState(8); 
				match(NUM);
				 ((TermContext)_localctx).type =  Type.NUM; 
				}
				break;
			case BOOL:
				{
				setState(10); 
				match(BOOL);
				 ((TermContext)_localctx).type =  Type.BOOL; 
				}
				break;
			case STR:
				{
				setState(12); 
				match(STR);
				 ((TermContext)_localctx).type =  Type.STR; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(33);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(31);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new TermContext(_parentctx, _parentState);
						_localctx.t0 = _prevctx;
						_localctx.t0 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(16);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(17); 
						match(POWER);
						setState(18); 
						((TermContext)_localctx).t1 = term(8);
						 if (((TermContext)_localctx).t1.type != Type.NUM) {
						                     ((TermContext)_localctx).type =  Type.ERR;
						                   } else if (((TermContext)_localctx).t0.type == Type.NUM || (((TermContext)_localctx).t0.type == Type.STR)) {
						                     ((TermContext)_localctx).type =  ((TermContext)_localctx).t0.type;
						                   } else {
						                     ((TermContext)_localctx).type =  Type.ERR;
						                   }
						                 
						}
						break;
					case 2:
						{
						_localctx = new TermContext(_parentctx, _parentState);
						_localctx.t0 = _prevctx;
						_localctx.t0 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(21);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(22); 
						match(PLUS);
						setState(23); 
						((TermContext)_localctx).t1 = term(7);
						 if (((TermContext)_localctx).t0.type == ((TermContext)_localctx).t1.type) {
						                     ((TermContext)_localctx).type =  ((TermContext)_localctx).t0.type;
						                   } else {
						                     ((TermContext)_localctx).type =  Type.ERR;
						                   }
						                 
						}
						break;
					case 3:
						{
						_localctx = new TermContext(_parentctx, _parentState);
						_localctx.t0 = _prevctx;
						_localctx.t0 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(26);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(27); 
						match(EQUAL);
						setState(28); 
						((TermContext)_localctx).t1 = term(6);
						 if (((TermContext)_localctx).t0.type == ((TermContext)_localctx).t1.type) {
						                     ((TermContext)_localctx).type =  Type.BOOL;
						                   } else {
						                     ((TermContext)_localctx).type =  Type.ERR;
						                   }
						                 
						}
						break;
					}
					} 
				}
				setState(35);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\13\'\4\2\t\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\21\n\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2\"\n\2\f\2\16\2%\13"+
		"\2\3\2\2\3\2\3\2\2\2+\2\20\3\2\2\2\4\5\b\2\1\2\5\6\7\6\2\2\6\7\5\2\2\2"+
		"\7\b\7\7\2\2\b\t\b\2\1\2\t\21\3\2\2\2\n\13\7\b\2\2\13\21\b\2\1\2\f\r\7"+
		"\t\2\2\r\21\b\2\1\2\16\17\7\n\2\2\17\21\b\2\1\2\20\4\3\2\2\2\20\n\3\2"+
		"\2\2\20\f\3\2\2\2\20\16\3\2\2\2\21#\3\2\2\2\22\23\f\t\2\2\23\24\7\3\2"+
		"\2\24\25\5\2\2\n\25\26\b\2\1\2\26\"\3\2\2\2\27\30\f\b\2\2\30\31\7\4\2"+
		"\2\31\32\5\2\2\t\32\33\b\2\1\2\33\"\3\2\2\2\34\35\f\7\2\2\35\36\7\5\2"+
		"\2\36\37\5\2\2\b\37 \b\2\1\2 \"\3\2\2\2!\22\3\2\2\2!\27\3\2\2\2!\34\3"+
		"\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$\3\3\2\2\2%#\3\2\2\2\5\20!#";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}