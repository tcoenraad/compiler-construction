// Generated from /Users/twancoenraad/Code/compiler-construction/block-4/pp/iloc/parse/ILOC.g4 by ANTLR 4.5
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
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, MINUS=2, COMMA=3, SEMI=4, LSQ=5, RSQ=6, DARROW=7, ARROW=8, ASS=9, 
		ID=10, SYMB=11, LAB=12, NUM=13, STR=14, COMMENT=15, WS=16;
	public static final int
		RULE_program = 0, RULE_decl = 1, RULE_instr = 2, RULE_op = 3, RULE_sources = 4, 
		RULE_targets = 5, RULE_label = 6, RULE_opCode = 7, RULE_operand = 8;
	public static final String[] ruleNames = {
		"program", "decl", "instr", "op", "sources", "targets", "label", "opCode", 
		"operand"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "':'", "'-'", "','", "';'", "'['", "']'", "'=>'", "'->'", "'<-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "MINUS", "COMMA", "SEMI", "LSQ", "RSQ", "DARROW", "ARROW", 
		"ASS", "ID", "SYMB", "LAB", "NUM", "STR", "COMMENT", "WS"
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
	public String getGrammarFileName() { return "ILOC.g4"; }

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
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<InstrContext> instr() {
			return getRuleContexts(InstrContext.class);
		}
		public InstrContext instr(int i) {
			return getRuleContext(InstrContext.class,i);
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
					setState(18); 
					decl();
					}
					} 
				}
				setState(23);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(25); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(24); 
				instr();
				}
				}
				setState(27); 
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

	public static class DeclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ILOCParser.ID, 0); }
		public TerminalNode ASS() { return getToken(ILOCParser.ASS, 0); }
		public TerminalNode NUM() { return getToken(ILOCParser.NUM, 0); }
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29); 
			match(ID);
			setState(30); 
			match(ASS);
			setState(31); 
			match(NUM);
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
		public TerminalNode LSQ() { return getToken(ILOCParser.LSQ, 0); }
		public TerminalNode RSQ() { return getToken(ILOCParser.RSQ, 0); }
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public List<OpContext> op() {
			return getRuleContexts(OpContext.class);
		}
		public OpContext op(int i) {
			return getRuleContext(OpContext.class,i);
		}
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
			setState(52);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new SingleInstrContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(33); 
					label();
					setState(34); 
					match(T__0);
					}
					break;
				}
				setState(38); 
				op();
				}
				break;
			case 2:
				_localctx = new InstrListContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(39); 
					label();
					setState(40); 
					match(T__0);
					}
				}

				setState(44); 
				match(LSQ);
				setState(46); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(45); 
					op();
					}
					}
					setState(48); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID || _la==COMMENT );
				setState(50); 
				match(RSQ);
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
		public OpCodeContext opCode() {
			return getRuleContext(OpCodeContext.class,0);
		}
		public SourcesContext sources() {
			return getRuleContext(SourcesContext.class,0);
		}
		public TargetsContext targets() {
			return getRuleContext(TargetsContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ILOCParser.SEMI, 0); }
		public TerminalNode COMMENT() { return getToken(ILOCParser.COMMENT, 0); }
		public TerminalNode ARROW() { return getToken(ILOCParser.ARROW, 0); }
		public TerminalNode DARROW() { return getToken(ILOCParser.DARROW, 0); }
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
			setState(67);
			switch (_input.LA(1)) {
			case COMMENT:
				_localctx = new CommentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(54); 
				match(COMMENT);
				}
				break;
			case ID:
				_localctx = new RealOpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(55); 
				opCode();
				setState(56); 
				sources();
				setState(59);
				_la = _input.LA(1);
				if (_la==DARROW || _la==ARROW) {
					{
					setState(57);
					_la = _input.LA(1);
					if ( !(_la==DARROW || _la==ARROW) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(58); 
					targets();
					}
				}

				setState(62);
				_la = _input.LA(1);
				if (_la==SEMI) {
					{
					setState(61); 
					match(SEMI);
					}
				}

				setState(65);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(64); 
					match(COMMENT);
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
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ILOCParser.COMMA); }
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
			setState(77);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(69); 
				operand();
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(70); 
					match(COMMA);
					setState(71); 
					operand();
					}
					}
					setState(76);
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
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ILOCParser.COMMA); }
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
			setState(79); 
			operand();
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(80); 
				match(COMMA);
				setState(81); 
				operand();
				}
				}
				setState(86);
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
			setState(87); 
			match(ID);
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
			setState(89); 
			match(ID);
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
		public TerminalNode NUM() { return getToken(ILOCParser.NUM, 0); }
		public TerminalNode SYMB() { return getToken(ILOCParser.SYMB, 0); }
		public TerminalNode LAB() { return getToken(ILOCParser.LAB, 0); }
		public TerminalNode STR() { return getToken(ILOCParser.STR, 0); }
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
			setState(91);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\22`\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\7\2\26"+
		"\n\2\f\2\16\2\31\13\2\3\2\6\2\34\n\2\r\2\16\2\35\3\3\3\3\3\3\3\3\3\4\3"+
		"\4\3\4\5\4\'\n\4\3\4\3\4\3\4\3\4\5\4-\n\4\3\4\3\4\6\4\61\n\4\r\4\16\4"+
		"\62\3\4\3\4\5\4\67\n\4\3\5\3\5\3\5\3\5\3\5\5\5>\n\5\3\5\5\5A\n\5\3\5\5"+
		"\5D\n\5\5\5F\n\5\3\6\3\6\3\6\7\6K\n\6\f\6\16\6N\13\6\5\6P\n\6\3\7\3\7"+
		"\3\7\7\7U\n\7\f\7\16\7X\13\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\2\2\13\2\4\6"+
		"\b\n\f\16\20\22\2\4\3\2\t\n\3\2\f\20c\2\27\3\2\2\2\4\37\3\2\2\2\6\66\3"+
		"\2\2\2\bE\3\2\2\2\nO\3\2\2\2\fQ\3\2\2\2\16Y\3\2\2\2\20[\3\2\2\2\22]\3"+
		"\2\2\2\24\26\5\4\3\2\25\24\3\2\2\2\26\31\3\2\2\2\27\25\3\2\2\2\27\30\3"+
		"\2\2\2\30\33\3\2\2\2\31\27\3\2\2\2\32\34\5\6\4\2\33\32\3\2\2\2\34\35\3"+
		"\2\2\2\35\33\3\2\2\2\35\36\3\2\2\2\36\3\3\2\2\2\37 \7\f\2\2 !\7\13\2\2"+
		"!\"\7\17\2\2\"\5\3\2\2\2#$\5\16\b\2$%\7\3\2\2%\'\3\2\2\2&#\3\2\2\2&\'"+
		"\3\2\2\2\'(\3\2\2\2(\67\5\b\5\2)*\5\16\b\2*+\7\3\2\2+-\3\2\2\2,)\3\2\2"+
		"\2,-\3\2\2\2-.\3\2\2\2.\60\7\7\2\2/\61\5\b\5\2\60/\3\2\2\2\61\62\3\2\2"+
		"\2\62\60\3\2\2\2\62\63\3\2\2\2\63\64\3\2\2\2\64\65\7\b\2\2\65\67\3\2\2"+
		"\2\66&\3\2\2\2\66,\3\2\2\2\67\7\3\2\2\28F\7\21\2\29:\5\20\t\2:=\5\n\6"+
		"\2;<\t\2\2\2<>\5\f\7\2=;\3\2\2\2=>\3\2\2\2>@\3\2\2\2?A\7\6\2\2@?\3\2\2"+
		"\2@A\3\2\2\2AC\3\2\2\2BD\7\21\2\2CB\3\2\2\2CD\3\2\2\2DF\3\2\2\2E8\3\2"+
		"\2\2E9\3\2\2\2F\t\3\2\2\2GL\5\22\n\2HI\7\5\2\2IK\5\22\n\2JH\3\2\2\2KN"+
		"\3\2\2\2LJ\3\2\2\2LM\3\2\2\2MP\3\2\2\2NL\3\2\2\2OG\3\2\2\2OP\3\2\2\2P"+
		"\13\3\2\2\2QV\5\22\n\2RS\7\5\2\2SU\5\22\n\2TR\3\2\2\2UX\3\2\2\2VT\3\2"+
		"\2\2VW\3\2\2\2W\r\3\2\2\2XV\3\2\2\2YZ\7\f\2\2Z\17\3\2\2\2[\\\7\f\2\2\\"+
		"\21\3\2\2\2]^\t\3\2\2^\23\3\2\2\2\17\27\35&,\62\66=@CELOV";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}