// Generated from Fragment.g4 by ANTLR 4.4
package pp.block4.cc.cfg;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FragmentParser extends Parser {
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
	public static final String[] tokenNames = {
		"<INVALID>", "'.'", "';'", "','", "'['", "']'", "'='", "'!'", "'||'", 
		"'&&'", "'|'", "'&'", "'+'", "'-'", "'<'", "'>'", "'=='", "'!='", "'{'", 
		"'}'", "'('", "')'", "'in'", "'printf'", "'boolean'", "'int'", "'while'", 
		"'if'", "'else'", "'true'", "'false'", "'break'", "'continue'", "ID", 
		"NUM", "STRING", "WS"
	};
	public static final int
		RULE_program = 0, RULE_stat = 1, RULE_target = 2, RULE_expr = 3, RULE_type = 4;
	public static final String[] ruleNames = {
		"program", "stat", "target", "expr", "type"
	};

	@Override
	public String getGrammarFileName() { return "Fragment.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FragmentParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(11); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(10); stat();
				}
				}
				setState(13); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LCURLY) | (1L << PRINT) | (1L << BOOL) | (1L << INT) | (1L << WHILE) | (1L << IF) | (1L << BREAK) | (1L << CONTINUE) | (1L << ID))) != 0) );
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

	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IfStatContext extends StatContext {
		public TerminalNode ELSE() { return getToken(FragmentParser.ELSE, 0); }
		public TerminalNode IF() { return getToken(FragmentParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public TerminalNode LPAR() { return getToken(FragmentParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FragmentParser.RPAR, 0); }
		public IfStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterIfStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitIfStat(this);
		}
	}
	public static class BlockStatContext extends StatContext {
		public TerminalNode RCURLY() { return getToken(FragmentParser.RCURLY, 0); }
		public TerminalNode LCURLY() { return getToken(FragmentParser.LCURLY, 0); }
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public BlockStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterBlockStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitBlockStat(this);
		}
	}
	public static class ContStatContext extends StatContext {
		public TerminalNode CONTINUE() { return getToken(FragmentParser.CONTINUE, 0); }
		public TerminalNode SEMI() { return getToken(FragmentParser.SEMI, 0); }
		public ContStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterContStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitContStat(this);
		}
	}
	public static class DeclContext extends StatContext {
		public TerminalNode ID() { return getToken(FragmentParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(FragmentParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(FragmentParser.SEMI, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public DeclContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitDecl(this);
		}
	}
	public static class PrintStatContext extends StatContext {
		public List<TerminalNode> ID() { return getTokens(FragmentParser.ID); }
		public TerminalNode PRINT() { return getToken(FragmentParser.PRINT, 0); }
		public TerminalNode SEMI() { return getToken(FragmentParser.SEMI, 0); }
		public List<TerminalNode> COMMA() { return getTokens(FragmentParser.COMMA); }
		public TerminalNode STRING() { return getToken(FragmentParser.STRING, 0); }
		public TerminalNode ID(int i) {
			return getToken(FragmentParser.ID, i);
		}
		public TerminalNode LPAR() { return getToken(FragmentParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FragmentParser.RPAR, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(FragmentParser.COMMA, i);
		}
		public PrintStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterPrintStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitPrintStat(this);
		}
	}
	public static class AssignStatContext extends StatContext {
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(FragmentParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(FragmentParser.SEMI, 0); }
		public AssignStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterAssignStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitAssignStat(this);
		}
	}
	public static class BreakStatContext extends StatContext {
		public TerminalNode BREAK() { return getToken(FragmentParser.BREAK, 0); }
		public TerminalNode SEMI() { return getToken(FragmentParser.SEMI, 0); }
		public BreakStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterBreakStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitBreakStat(this);
		}
	}
	public static class WhileStatContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(FragmentParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FragmentParser.RPAR, 0); }
		public TerminalNode WHILE() { return getToken(FragmentParser.WHILE, 0); }
		public WhileStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterWhileStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitWhileStat(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		int _la;
		try {
			setState(65);
			switch (_input.LA(1)) {
			case BOOL:
			case INT:
				_localctx = new DeclContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(15); type();
				setState(16); match(ID);
				setState(17); match(ASSIGN);
				setState(18); expr(0);
				setState(19); match(SEMI);
				}
				break;
			case ID:
				_localctx = new AssignStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(21); target();
				setState(22); match(ASSIGN);
				setState(23); expr(0);
				setState(24); match(SEMI);
				}
				break;
			case IF:
				_localctx = new IfStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(26); match(IF);
				setState(27); match(LPAR);
				setState(28); expr(0);
				setState(29); match(RPAR);
				setState(30); stat();
				setState(33);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(31); match(ELSE);
					setState(32); stat();
					}
					break;
				}
				}
				break;
			case WHILE:
				_localctx = new WhileStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(35); match(WHILE);
				setState(36); match(LPAR);
				setState(37); expr(0);
				setState(38); match(RPAR);
				setState(39); stat();
				}
				break;
			case LCURLY:
				_localctx = new BlockStatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(41); match(LCURLY);
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LCURLY) | (1L << PRINT) | (1L << BOOL) | (1L << INT) | (1L << WHILE) | (1L << IF) | (1L << BREAK) | (1L << CONTINUE) | (1L << ID))) != 0)) {
					{
					{
					setState(42); stat();
					}
					}
					setState(47);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(48); match(RCURLY);
				}
				break;
			case PRINT:
				_localctx = new PrintStatContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(49); match(PRINT);
				setState(50); match(LPAR);
				setState(51); match(STRING);
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(52); match(COMMA);
					setState(53); match(ID);
					}
					}
					setState(58);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(59); match(RPAR);
				setState(60); match(SEMI);
				}
				break;
			case BREAK:
				_localctx = new BreakStatContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(61); match(BREAK);
				setState(62); match(SEMI);
				}
				break;
			case CONTINUE:
				_localctx = new ContStatContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(63); match(CONTINUE);
				setState(64); match(SEMI);
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

	public static class TargetContext extends ParserRuleContext {
		public TargetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_target; }
	 
		public TargetContext() { }
		public void copyFrom(TargetContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IdTargetContext extends TargetContext {
		public TerminalNode ID() { return getToken(FragmentParser.ID, 0); }
		public IdTargetContext(TargetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterIdTarget(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitIdTarget(this);
		}
	}
	public static class ArrayTargetContext extends TargetContext {
		public TerminalNode ID() { return getToken(FragmentParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RSQ() { return getToken(FragmentParser.RSQ, 0); }
		public TerminalNode LSQ() { return getToken(FragmentParser.LSQ, 0); }
		public ArrayTargetContext(TargetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterArrayTarget(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitArrayTarget(this);
		}
	}

	public final TargetContext target() throws RecognitionException {
		TargetContext _localctx = new TargetContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_target);
		try {
			setState(73);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new IdTargetContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(67); match(ID);
				}
				break;
			case 2:
				_localctx = new ArrayTargetContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(68); match(ID);
				setState(69); match(LSQ);
				setState(70); expr(0);
				setState(71); match(RSQ);
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(FragmentParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RSQ() { return getToken(FragmentParser.RSQ, 0); }
		public TerminalNode LSQ() { return getToken(FragmentParser.LSQ, 0); }
		public ArrayExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterArrayExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitArrayExpr(this);
		}
	}
	public static class InExprContext extends ExprContext {
		public TerminalNode LPAR() { return getToken(FragmentParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FragmentParser.RPAR, 0); }
		public TerminalNode IN() { return getToken(FragmentParser.IN, 0); }
		public InExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterInExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitInExpr(this);
		}
	}
	public static class OrExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OR() { return getToken(FragmentParser.OR, 0); }
		public OrExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitOrExpr(this);
		}
	}
	public static class FieldExprContext extends ExprContext {
		public TerminalNode DOT() { return getToken(FragmentParser.DOT, 0); }
		public TerminalNode ID() { return getToken(FragmentParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FieldExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterFieldExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitFieldExpr(this);
		}
	}
	public static class ParExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(FragmentParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FragmentParser.RPAR, 0); }
		public ParExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterParExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitParExpr(this);
		}
	}
	public static class BitOrExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode BIT_OR() { return getToken(FragmentParser.BIT_OR, 0); }
		public BitOrExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterBitOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitBitOrExpr(this);
		}
	}
	public static class NotExprContext extends ExprContext {
		public TerminalNode NOT() { return getToken(FragmentParser.NOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterNotExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitNotExpr(this);
		}
	}
	public static class AddExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(FragmentParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(FragmentParser.MINUS, 0); }
		public AddExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterAddExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitAddExpr(this);
		}
	}
	public static class CompExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LT() { return getToken(FragmentParser.LT, 0); }
		public TerminalNode GT() { return getToken(FragmentParser.GT, 0); }
		public TerminalNode EQ() { return getToken(FragmentParser.EQ, 0); }
		public TerminalNode NE() { return getToken(FragmentParser.NE, 0); }
		public CompExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterCompExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitCompExpr(this);
		}
	}
	public static class BitAndExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode BIT_AND() { return getToken(FragmentParser.BIT_AND, 0); }
		public BitAndExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterBitAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitBitAndExpr(this);
		}
	}
	public static class ConstExprContext extends ExprContext {
		public TerminalNode FALSE() { return getToken(FragmentParser.FALSE, 0); }
		public TerminalNode NUM() { return getToken(FragmentParser.NUM, 0); }
		public TerminalNode TRUE() { return getToken(FragmentParser.TRUE, 0); }
		public ConstExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterConstExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitConstExpr(this);
		}
	}
	public static class IdExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(FragmentParser.ID, 0); }
		public IdExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterIdExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitIdExpr(this);
		}
	}
	public static class AndExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(FragmentParser.AND, 0); }
		public AndExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitAndExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(76); match(NOT);
				setState(77); expr(13);
				}
				break;
			case 2:
				{
				_localctx = new ParExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(78); match(LPAR);
				setState(79); expr(0);
				setState(80); match(RPAR);
				}
				break;
			case 3:
				{
				_localctx = new ConstExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(82);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << NUM))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case 4:
				{
				_localctx = new InExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(83); match(IN);
				setState(84); match(LPAR);
				setState(85); match(RPAR);
				}
				break;
			case 5:
				{
				_localctx = new ArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(86); match(ID);
				setState(87); match(LSQ);
				setState(88); expr(0);
				setState(89); match(RSQ);
				}
				break;
			case 6:
				{
				_localctx = new IdExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(91); match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(117);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(115);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new AddExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(94);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(95);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(96); expr(13);
						}
						break;
					case 2:
						{
						_localctx = new BitAndExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(97);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(98); match(BIT_AND);
						setState(99); expr(12);
						}
						break;
					case 3:
						{
						_localctx = new BitOrExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(100);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(101); match(BIT_OR);
						setState(102); expr(11);
						}
						break;
					case 4:
						{
						_localctx = new AndExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(103);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(104); match(AND);
						setState(105); expr(10);
						}
						break;
					case 5:
						{
						_localctx = new OrExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(106);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(107); match(OR);
						setState(108); expr(9);
						}
						break;
					case 6:
						{
						_localctx = new CompExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(109);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(110);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT) | (1L << GT) | (1L << EQ) | (1L << NE))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(111); expr(8);
						}
						break;
					case 7:
						{
						_localctx = new FieldExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(112);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(113); match(DOT);
						setState(114); match(ID);
						}
						break;
					}
					} 
				}
				setState(119);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(FragmentParser.BOOL, 0); }
		public TerminalNode INT() { return getToken(FragmentParser.INT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FragmentListener ) ((FragmentListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			_la = _input.LA(1);
			if ( !(_la==BOOL || _la==INT) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 12);
		case 1: return precpred(_ctx, 11);
		case 2: return precpred(_ctx, 10);
		case 3: return precpred(_ctx, 9);
		case 4: return precpred(_ctx, 8);
		case 5: return precpred(_ctx, 7);
		case 6: return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3&}\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\3\2\6\2\16\n\2\r\2\16\2\17\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3$\n\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3.\n\3\f\3\16\3\61\13\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\7\39\n\3\f\3\16\3<\13\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3D\n\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\5\4L\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5_\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5v\n\5\f\5\16\5y"+
		"\13\5\3\6\3\6\3\6\2\3\b\7\2\4\6\b\n\2\6\4\2\37 $$\3\2\16\17\3\2\20\23"+
		"\3\2\32\33\u008f\2\r\3\2\2\2\4C\3\2\2\2\6K\3\2\2\2\b^\3\2\2\2\nz\3\2\2"+
		"\2\f\16\5\4\3\2\r\f\3\2\2\2\16\17\3\2\2\2\17\r\3\2\2\2\17\20\3\2\2\2\20"+
		"\3\3\2\2\2\21\22\5\n\6\2\22\23\7#\2\2\23\24\7\b\2\2\24\25\5\b\5\2\25\26"+
		"\7\4\2\2\26D\3\2\2\2\27\30\5\6\4\2\30\31\7\b\2\2\31\32\5\b\5\2\32\33\7"+
		"\4\2\2\33D\3\2\2\2\34\35\7\35\2\2\35\36\7\26\2\2\36\37\5\b\5\2\37 \7\27"+
		"\2\2 #\5\4\3\2!\"\7\36\2\2\"$\5\4\3\2#!\3\2\2\2#$\3\2\2\2$D\3\2\2\2%&"+
		"\7\34\2\2&\'\7\26\2\2\'(\5\b\5\2()\7\27\2\2)*\5\4\3\2*D\3\2\2\2+/\7\24"+
		"\2\2,.\5\4\3\2-,\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\62\3\2\2"+
		"\2\61/\3\2\2\2\62D\7\25\2\2\63\64\7\31\2\2\64\65\7\26\2\2\65:\7%\2\2\66"+
		"\67\7\5\2\2\679\7#\2\28\66\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;=\3\2"+
		"\2\2<:\3\2\2\2=>\7\27\2\2>D\7\4\2\2?@\7!\2\2@D\7\4\2\2AB\7\"\2\2BD\7\4"+
		"\2\2C\21\3\2\2\2C\27\3\2\2\2C\34\3\2\2\2C%\3\2\2\2C+\3\2\2\2C\63\3\2\2"+
		"\2C?\3\2\2\2CA\3\2\2\2D\5\3\2\2\2EL\7#\2\2FG\7#\2\2GH\7\6\2\2HI\5\b\5"+
		"\2IJ\7\7\2\2JL\3\2\2\2KE\3\2\2\2KF\3\2\2\2L\7\3\2\2\2MN\b\5\1\2NO\7\t"+
		"\2\2O_\5\b\5\17PQ\7\26\2\2QR\5\b\5\2RS\7\27\2\2S_\3\2\2\2T_\t\2\2\2UV"+
		"\7\30\2\2VW\7\26\2\2W_\7\27\2\2XY\7#\2\2YZ\7\6\2\2Z[\5\b\5\2[\\\7\7\2"+
		"\2\\_\3\2\2\2]_\7#\2\2^M\3\2\2\2^P\3\2\2\2^T\3\2\2\2^U\3\2\2\2^X\3\2\2"+
		"\2^]\3\2\2\2_w\3\2\2\2`a\f\16\2\2ab\t\3\2\2bv\5\b\5\17cd\f\r\2\2de\7\r"+
		"\2\2ev\5\b\5\16fg\f\f\2\2gh\7\f\2\2hv\5\b\5\rij\f\13\2\2jk\7\13\2\2kv"+
		"\5\b\5\flm\f\n\2\2mn\7\n\2\2nv\5\b\5\13op\f\t\2\2pq\t\4\2\2qv\5\b\5\n"+
		"rs\f\b\2\2st\7\3\2\2tv\7#\2\2u`\3\2\2\2uc\3\2\2\2uf\3\2\2\2ui\3\2\2\2"+
		"ul\3\2\2\2uo\3\2\2\2ur\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2x\t\3\2\2"+
		"\2yw\3\2\2\2z{\t\5\2\2{\13\3\2\2\2\13\17#/:CK^uw";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}