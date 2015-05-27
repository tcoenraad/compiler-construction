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
		T__0=1, MINUS=2, COMMA=3, SEMI=4, LSQ=5, RSQ=6, DARROW=7, ARROW=8, ASS=9, 
		ID=10, SYMB=11, LAB=12, NUM=13, STR=14, COMMENT=15, WS=16, EOL=17;
	public static final String[] tokenNames = {
		"<INVALID>", "':'", "'-'", "','", "';'", "'['", "']'", "'=>'", "'->'", 
		"'<-'", "ID", "SYMB", "LAB", "NUM", "STR", "COMMENT", "WS", "EOL"
	};
	public static final int
		RULE_program = 0, RULE_decl = 1, RULE_instr = 2, RULE_op = 3, RULE_sources = 4, 
		RULE_targets = 5, RULE_label = 6, RULE_opCode = 7, RULE_operand = 8;
	public static final String[] ruleNames = {
		"program", "decl", "instr", "op", "sources", "targets", "label", "opCode", 
		"operand"
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
		public List<TerminalNode> EOL() { return getTokens(ILOCParser.EOL); }
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public TerminalNode EOF() { return getToken(ILOCParser.EOF, 0); }
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public InstrContext instr(int i) {
			return getRuleContext(InstrContext.class,i);
		}
		public TerminalNode EOL(int i) {
			return getToken(ILOCParser.EOL, i);
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(18); decl();
					}
					} 
				}
				setState(23);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(24); instr();
			setState(33);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(26); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(25); match(EOL);
						}
						}
						setState(28); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==EOL );
					setState(30); instr();
					}
					} 
				}
				setState(35);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EOL) {
				{
				{
				setState(36); match(EOL);
				}
				}
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(42); match(EOF);
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

	public static class DeclContext extends ParserRuleContext {
		public TerminalNode COMMENT() { return getToken(ILOCParser.COMMENT, 0); }
		public TerminalNode ID() { return getToken(ILOCParser.ID, 0); }
		public List<TerminalNode> EOL() { return getTokens(ILOCParser.EOL); }
		public TerminalNode NUM() { return getToken(ILOCParser.NUM, 0); }
		public TerminalNode EOL(int i) {
			return getToken(ILOCParser.EOL, i);
		}
		public TerminalNode ASS() { return getToken(ILOCParser.ASS, 0); }
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILOCListener ) ((ILOCListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILOCListener ) ((ILOCListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44); match(ID);
			setState(45); match(ASS);
			setState(46); match(NUM);
			setState(48);
			_la = _input.LA(1);
			if (_la==COMMENT) {
				{
				setState(47); match(COMMENT);
				}
			}

			setState(51); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(50); match(EOL);
				}
				}
				setState(53); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==EOL );
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
		public List<TerminalNode> EOL() { return getTokens(ILOCParser.EOL); }
		public TerminalNode RSQ() { return getToken(ILOCParser.RSQ, 0); }
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public TerminalNode EOL(int i) {
			return getToken(ILOCParser.EOL, i);
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
		enterRule(_localctx, 4, RULE_instr);
		int _la;
		try {
			int _alt;
			setState(93);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new SingleInstrContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(55); label();
					setState(56); match(T__0);
					}
					break;
				}
				setState(60); op();
				}
				break;
			case 2:
				_localctx = new InstrListContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(61); label();
					setState(62); match(T__0);
					}
				}

				setState(66); match(LSQ);
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==EOL) {
					{
					{
					setState(67); match(EOL);
					}
					}
					setState(72);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(73); op();
				setState(82);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(75); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(74); match(EOL);
							}
							}
							setState(77); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==EOL );
						setState(79); op();
						}
						} 
					}
					setState(84);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==EOL) {
					{
					{
					setState(85); match(EOL);
					}
					}
					setState(90);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(91); match(RSQ);
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
		enterRule(_localctx, 6, RULE_op);
		int _la;
		try {
			setState(108);
			switch (_input.LA(1)) {
			case COMMENT:
				_localctx = new CommentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(95); match(COMMENT);
				}
				break;
			case ID:
				_localctx = new RealOpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(96); opCode();
				setState(97); sources();
				setState(100);
				_la = _input.LA(1);
				if (_la==DARROW || _la==ARROW) {
					{
					setState(98);
					_la = _input.LA(1);
					if ( !(_la==DARROW || _la==ARROW) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(99); targets();
					}
				}

				setState(103);
				_la = _input.LA(1);
				if (_la==SEMI) {
					{
					setState(102); match(SEMI);
					}
				}

				setState(106);
				_la = _input.LA(1);
				if (_la==COMMENT) {
					{
					setState(105); match(COMMENT);
					}
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
		enterRule(_localctx, 8, RULE_sources);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << SYMB) | (1L << LAB) | (1L << NUM) | (1L << STR))) != 0)) {
				{
				setState(110); operand();
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(111); match(COMMA);
					setState(112); operand();
					}
					}
					setState(117);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
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
		enterRule(_localctx, 10, RULE_targets);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120); operand();
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(121); match(COMMA);
				setState(122); operand();
				}
				}
				setState(127);
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
		enterRule(_localctx, 12, RULE_label);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128); match(ID);
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
		enterRule(_localctx, 14, RULE_opCode);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130); match(ID);
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
		public TerminalNode LAB() { return getToken(ILOCParser.LAB, 0); }
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
		enterRule(_localctx, 16, RULE_operand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << SYMB) | (1L << LAB) | (1L << NUM) | (1L << STR))) != 0)) ) {
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\23\u0089\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\7"+
		"\2\26\n\2\f\2\16\2\31\13\2\3\2\3\2\6\2\35\n\2\r\2\16\2\36\3\2\7\2\"\n"+
		"\2\f\2\16\2%\13\2\3\2\7\2(\n\2\f\2\16\2+\13\2\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\5\3\63\n\3\3\3\6\3\66\n\3\r\3\16\3\67\3\4\3\4\3\4\5\4=\n\4\3\4\3\4\3"+
		"\4\3\4\5\4C\n\4\3\4\3\4\7\4G\n\4\f\4\16\4J\13\4\3\4\3\4\6\4N\n\4\r\4\16"+
		"\4O\3\4\7\4S\n\4\f\4\16\4V\13\4\3\4\7\4Y\n\4\f\4\16\4\\\13\4\3\4\3\4\5"+
		"\4`\n\4\3\5\3\5\3\5\3\5\3\5\5\5g\n\5\3\5\5\5j\n\5\3\5\5\5m\n\5\5\5o\n"+
		"\5\3\6\3\6\3\6\7\6t\n\6\f\6\16\6w\13\6\5\6y\n\6\3\7\3\7\3\7\7\7~\n\7\f"+
		"\7\16\7\u0081\13\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\2\2\13\2\4\6\b\n\f\16\20"+
		"\22\2\4\3\2\t\n\3\2\f\20\u0093\2\27\3\2\2\2\4.\3\2\2\2\6_\3\2\2\2\bn\3"+
		"\2\2\2\nx\3\2\2\2\fz\3\2\2\2\16\u0082\3\2\2\2\20\u0084\3\2\2\2\22\u0086"+
		"\3\2\2\2\24\26\5\4\3\2\25\24\3\2\2\2\26\31\3\2\2\2\27\25\3\2\2\2\27\30"+
		"\3\2\2\2\30\32\3\2\2\2\31\27\3\2\2\2\32#\5\6\4\2\33\35\7\23\2\2\34\33"+
		"\3\2\2\2\35\36\3\2\2\2\36\34\3\2\2\2\36\37\3\2\2\2\37 \3\2\2\2 \"\5\6"+
		"\4\2!\34\3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$)\3\2\2\2%#\3\2\2\2&("+
		"\7\23\2\2\'&\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*,\3\2\2\2+)\3\2\2"+
		"\2,-\7\2\2\3-\3\3\2\2\2./\7\f\2\2/\60\7\13\2\2\60\62\7\17\2\2\61\63\7"+
		"\21\2\2\62\61\3\2\2\2\62\63\3\2\2\2\63\65\3\2\2\2\64\66\7\23\2\2\65\64"+
		"\3\2\2\2\66\67\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28\5\3\2\2\29:\5\16\b\2"+
		":;\7\3\2\2;=\3\2\2\2<9\3\2\2\2<=\3\2\2\2=>\3\2\2\2>`\5\b\5\2?@\5\16\b"+
		"\2@A\7\3\2\2AC\3\2\2\2B?\3\2\2\2BC\3\2\2\2CD\3\2\2\2DH\7\7\2\2EG\7\23"+
		"\2\2FE\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2IK\3\2\2\2JH\3\2\2\2KT\5\b"+
		"\5\2LN\7\23\2\2ML\3\2\2\2NO\3\2\2\2OM\3\2\2\2OP\3\2\2\2PQ\3\2\2\2QS\5"+
		"\b\5\2RM\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2UZ\3\2\2\2VT\3\2\2\2WY\7"+
		"\23\2\2XW\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[]\3\2\2\2\\Z\3\2\2\2"+
		"]^\7\b\2\2^`\3\2\2\2_<\3\2\2\2_B\3\2\2\2`\7\3\2\2\2ao\7\21\2\2bc\5\20"+
		"\t\2cf\5\n\6\2de\t\2\2\2eg\5\f\7\2fd\3\2\2\2fg\3\2\2\2gi\3\2\2\2hj\7\6"+
		"\2\2ih\3\2\2\2ij\3\2\2\2jl\3\2\2\2km\7\21\2\2lk\3\2\2\2lm\3\2\2\2mo\3"+
		"\2\2\2na\3\2\2\2nb\3\2\2\2o\t\3\2\2\2pu\5\22\n\2qr\7\5\2\2rt\5\22\n\2"+
		"sq\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2vy\3\2\2\2wu\3\2\2\2xp\3\2\2\2"+
		"xy\3\2\2\2y\13\3\2\2\2z\177\5\22\n\2{|\7\5\2\2|~\5\22\n\2}{\3\2\2\2~\u0081"+
		"\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\r\3\2\2\2\u0081\177\3\2"+
		"\2\2\u0082\u0083\7\f\2\2\u0083\17\3\2\2\2\u0084\u0085\7\f\2\2\u0085\21"+
		"\3\2\2\2\u0086\u0087\t\3\2\2\u0087\23\3\2\2\2\26\27\36#)\62\67<BHOTZ_"+
		"filnux\177";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}