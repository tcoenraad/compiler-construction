// Generated from ILOC.g4 by ANTLR 4.4
package pp.iloc.parse;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ILOCParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, MINUS=2, COMMA=3, SEMI=4, LSQ=5, RSQ=6, DARROW=7, ARROW=8, ID=9, 
		SYMB=10, NUM=11, STR=12, COMMENT=13, WS=14;
	public static final String[] tokenNames = {
		"<INVALID>", "':'", "'-'", "','", "';'", "'['", "']'", "'=>'", "'->'", 
		"ID", "SYMB", "NUM", "STR", "COMMENT", "WS"
	};
	public static final int
		RULE_program = 0, RULE_instr = 1, RULE_op = 2, RULE_sources = 3, RULE_targets = 4, 
		RULE_label = 5, RULE_opCode = 6, RULE_operand = 7;
	public static final String[] ruleNames = {
		"program", "instr", "op", "sources", "targets", "label", "opCode", "operand"
	};

	@Override
	public String getGrammarFileName() { return "ILOC.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ILOCParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public InstrContext instr(int i) {
			return getRuleContext(InstrContext.class,i);
		}
		public List<InstrContext> instr() {
			return getRuleContexts(InstrContext.class);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILOCListener ) ((ILOCListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILOCListener ) ((ILOCListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(16); instr();
				}
				}
				setState(19); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LSQ) | (1L << ID) | (1L << COMMENT))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstrContext extends ParserRuleContext {
		public InstrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instr; }
	 
		public InstrContext() { }
		public void copyFrom(InstrContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class InstrListContext extends InstrContext {
		public OpContext op(int i) {
			return getRuleContext(OpContext.class,i);
		}
		public List<OpContext> op() {
			return getRuleContexts(OpContext.class);
		}
		public TerminalNode RSQ() { return getToken(ILOCParser.RSQ, 0); }
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public TerminalNode LSQ() { return getToken(ILOCParser.LSQ, 0); }
		public InstrListContext(InstrContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILOCListener ) ((ILOCListener)listener).enterInstrList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILOCListener ) ((ILOCListener)listener).exitInstrList(this);
		}
	}
	public static class SingleInstrContext extends InstrContext {
		public OpContext op() {
			return getRuleContext(OpContext.class,0);
		}
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public SingleInstrContext(InstrContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILOCListener ) ((ILOCListener)listener).enterSingleInstr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILOCListener ) ((ILOCListener)listener).exitSingleInstr(this);
		}
	}

	public final InstrContext instr() throws RecognitionException {
		InstrContext _localctx = new InstrContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_instr);
		int _la;
		try {
			setState(40);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new SingleInstrContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(24);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(21); label();
					setState(22); match(T__0);
					}
					break;
				}
				setState(26); op();
				}
				break;
			case 2:
				_localctx = new InstrListContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(30);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(27); label();
					setState(28); match(T__0);
					}
				}

				setState(32); match(LSQ);
				setState(34); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(33); op();
					}
					}
					setState(36); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID || _la==COMMENT );
				setState(38); match(RSQ);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpContext extends ParserRuleContext {
		public OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op; }
	 
		public OpContext() { }
		public void copyFrom(OpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CommentContext extends OpContext {
		public TerminalNode COMMENT() { return getToken(ILOCParser.COMMENT, 0); }
		public CommentContext(OpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILOCListener ) ((ILOCListener)listener).enterComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILOCListener ) ((ILOCListener)listener).exitComment(this);
		}
	}
	public static class RealOpContext extends OpContext {
		public TerminalNode COMMENT() { return getToken(ILOCParser.COMMENT, 0); }
		public TargetsContext targets() {
			return getRuleContext(TargetsContext.class,0);
		}
		public SourcesContext sources() {
			return getRuleContext(SourcesContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ILOCParser.SEMI, 0); }
		public TerminalNode DARROW() { return getToken(ILOCParser.DARROW, 0); }
		public OpCodeContext opCode() {
			return getRuleContext(OpCodeContext.class,0);
		}
		public TerminalNode ARROW() { return getToken(ILOCParser.ARROW, 0); }
		public RealOpContext(OpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILOCListener ) ((ILOCListener)listener).enterRealOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILOCListener ) ((ILOCListener)listener).exitRealOp(this);
		}
	}

	public final OpContext op() throws RecognitionException {
		OpContext _localctx = new OpContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_op);
		int _la;
		try {
			setState(55);
			switch (_input.LA(1)) {
			case COMMENT:
				_localctx = new CommentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(42); match(COMMENT);
				}
				break;
			case ID:
				_localctx = new RealOpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(43); opCode();
				setState(44); sources();
				setState(47);
				_la = _input.LA(1);
				if (_la==DARROW || _la==ARROW) {
					{
					setState(45);
					_la = _input.LA(1);
					if ( !(_la==DARROW || _la==ARROW) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(46); targets();
					}
				}

				setState(50);
				_la = _input.LA(1);
				if (_la==SEMI) {
					{
					setState(49); match(SEMI);
					}
				}

				setState(53);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(52); match(COMMENT);
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SourcesContext extends ParserRuleContext {
		public List<TerminalNode> COMMA() { return getTokens(ILOCParser.COMMA); }
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(ILOCParser.COMMA, i);
		}
		public SourcesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sources; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILOCListener ) ((ILOCListener)listener).enterSources(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILOCListener ) ((ILOCListener)listener).exitSources(this);
		}
	}

	public final SourcesContext sources() throws RecognitionException {
		SourcesContext _localctx = new SourcesContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_sources);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(57); operand();
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(58); match(COMMA);
					setState(59); operand();
					}
					}
					setState(64);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TargetsContext extends ParserRuleContext {
		public List<TerminalNode> COMMA() { return getTokens(ILOCParser.COMMA); }
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(ILOCParser.COMMA, i);
		}
		public TargetsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_targets; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILOCListener ) ((ILOCListener)listener).enterTargets(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILOCListener ) ((ILOCListener)listener).exitTargets(this);
		}
	}

	public final TargetsContext targets() throws RecognitionException {
		TargetsContext _localctx = new TargetsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_targets);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67); operand();
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(68); match(COMMA);
				setState(69); operand();
				}
				}
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabelContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ILOCParser.ID, 0); }
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILOCListener ) ((ILOCListener)listener).enterLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILOCListener ) ((ILOCListener)listener).exitLabel(this);
		}
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_label);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpCodeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ILOCParser.ID, 0); }
		public OpCodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opCode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILOCListener ) ((ILOCListener)listener).enterOpCode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILOCListener ) ((ILOCListener)listener).exitOpCode(this);
		}
	}

	public final OpCodeContext opCode() throws RecognitionException {
		OpCodeContext _localctx = new OpCodeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_opCode);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperandContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ILOCParser.ID, 0); }
		public TerminalNode STR() { return getToken(ILOCParser.STR, 0); }
		public TerminalNode NUM() { return getToken(ILOCParser.NUM, 0); }
		public TerminalNode SYMB() { return getToken(ILOCParser.SYMB, 0); }
		public OperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILOCListener ) ((ILOCListener)listener).enterOperand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILOCListener ) ((ILOCListener)listener).exitOperand(this);
		}
	}

	public final OperandContext operand() throws RecognitionException {
		OperandContext _localctx = new OperandContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_operand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << SYMB) | (1L << NUM) | (1L << STR))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\20T\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\6\2\24\n\2\r\2"+
		"\16\2\25\3\3\3\3\3\3\5\3\33\n\3\3\3\3\3\3\3\3\3\5\3!\n\3\3\3\3\3\6\3%"+
		"\n\3\r\3\16\3&\3\3\3\3\5\3+\n\3\3\4\3\4\3\4\3\4\3\4\5\4\62\n\4\3\4\5\4"+
		"\65\n\4\3\4\5\48\n\4\5\4:\n\4\3\5\3\5\3\5\7\5?\n\5\f\5\16\5B\13\5\5\5"+
		"D\n\5\3\6\3\6\3\6\7\6I\n\6\f\6\16\6L\13\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t"+
		"\2\2\n\2\4\6\b\n\f\16\20\2\4\3\2\t\n\3\2\13\16W\2\23\3\2\2\2\4*\3\2\2"+
		"\2\69\3\2\2\2\bC\3\2\2\2\nE\3\2\2\2\fM\3\2\2\2\16O\3\2\2\2\20Q\3\2\2\2"+
		"\22\24\5\4\3\2\23\22\3\2\2\2\24\25\3\2\2\2\25\23\3\2\2\2\25\26\3\2\2\2"+
		"\26\3\3\2\2\2\27\30\5\f\7\2\30\31\7\3\2\2\31\33\3\2\2\2\32\27\3\2\2\2"+
		"\32\33\3\2\2\2\33\34\3\2\2\2\34+\5\6\4\2\35\36\5\f\7\2\36\37\7\3\2\2\37"+
		"!\3\2\2\2 \35\3\2\2\2 !\3\2\2\2!\"\3\2\2\2\"$\7\7\2\2#%\5\6\4\2$#\3\2"+
		"\2\2%&\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'(\3\2\2\2()\7\b\2\2)+\3\2\2\2*\32"+
		"\3\2\2\2* \3\2\2\2+\5\3\2\2\2,:\7\17\2\2-.\5\16\b\2.\61\5\b\5\2/\60\t"+
		"\2\2\2\60\62\5\n\6\2\61/\3\2\2\2\61\62\3\2\2\2\62\64\3\2\2\2\63\65\7\6"+
		"\2\2\64\63\3\2\2\2\64\65\3\2\2\2\65\67\3\2\2\2\668\7\17\2\2\67\66\3\2"+
		"\2\2\678\3\2\2\28:\3\2\2\29,\3\2\2\29-\3\2\2\2:\7\3\2\2\2;@\5\20\t\2<"+
		"=\7\5\2\2=?\5\20\t\2><\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2AD\3\2\2\2"+
		"B@\3\2\2\2C;\3\2\2\2CD\3\2\2\2D\t\3\2\2\2EJ\5\20\t\2FG\7\5\2\2GI\5\20"+
		"\t\2HF\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2K\13\3\2\2\2LJ\3\2\2\2MN\7"+
		"\13\2\2N\r\3\2\2\2OP\7\13\2\2P\17\3\2\2\2QR\t\3\2\2R\21\3\2\2\2\16\25"+
		"\32 &*\61\64\679@CJ";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}