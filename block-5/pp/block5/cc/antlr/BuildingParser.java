// Generated from C:/Users/Jip/Documents/compiler-construction/block-5/pp/block5/cc/antlr\Building.g4 by ANTLR 4.5
package pp.block5.cc.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BuildingParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LSQ=1, RSQ=2, COLON=3, SEMI=4, ROOM=5, FLOOR=6, ID=7, WS=8;
	public static final int
		RULE_building = 0, RULE_floor = 1, RULE_room = 2;
	public static final String[] ruleNames = {
		"building", "floor", "room"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'['", "']'", "':'", "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LSQ", "RSQ", "COLON", "SEMI", "ROOM", "FLOOR", "ID", "WS"
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
	public String getGrammarFileName() { return "Building.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BuildingParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class BuildingContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(BuildingParser.ID, 0); }
		public TerminalNode COLON() { return getToken(BuildingParser.COLON, 0); }
		public List<FloorContext> floor() {
			return getRuleContexts(FloorContext.class);
		}
		public FloorContext floor(int i) {
			return getRuleContext(FloorContext.class,i);
		}
		public BuildingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_building; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitBuilding(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BuildingContext building() throws RecognitionException {
		BuildingContext _localctx = new BuildingContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_building);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(6); 
			match(ID);
			setState(7); 
			match(COLON);
			setState(9); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(8); 
				floor();
				}
				}
				setState(11); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==FLOOR );
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

	public static class FloorContext extends ParserRuleContext {
		public TerminalNode FLOOR() { return getToken(BuildingParser.FLOOR, 0); }
		public TerminalNode LSQ() { return getToken(BuildingParser.LSQ, 0); }
		public TerminalNode RSQ() { return getToken(BuildingParser.RSQ, 0); }
		public List<RoomContext> room() {
			return getRuleContexts(RoomContext.class);
		}
		public RoomContext room(int i) {
			return getRuleContext(RoomContext.class,i);
		}
		public FloorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitFloor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FloorContext floor() throws RecognitionException {
		FloorContext _localctx = new FloorContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_floor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13); 
			match(FLOOR);
			setState(22);
			_la = _input.LA(1);
			if (_la==LSQ) {
				{
				setState(14); 
				match(LSQ);
				setState(16); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(15); 
					room();
					}
					}
					setState(18); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ROOM );
				setState(20); 
				match(RSQ);
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

	public static class RoomContext extends ParserRuleContext {
		public TerminalNode ROOM() { return getToken(BuildingParser.ROOM, 0); }
		public RoomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_room; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildingVisitor ) return ((BuildingVisitor<? extends T>)visitor).visitRoom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RoomContext room() throws RecognitionException {
		RoomContext _localctx = new RoomContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_room);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24); 
			match(ROOM);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\n\35\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\3\2\3\2\3\2\6\2\f\n\2\r\2\16\2\r\3\3\3\3\3\3\6\3\23\n\3\r"+
		"\3\16\3\24\3\3\3\3\5\3\31\n\3\3\4\3\4\3\4\2\2\5\2\4\6\2\2\34\2\b\3\2\2"+
		"\2\4\17\3\2\2\2\6\32\3\2\2\2\b\t\7\t\2\2\t\13\7\5\2\2\n\f\5\4\3\2\13\n"+
		"\3\2\2\2\f\r\3\2\2\2\r\13\3\2\2\2\r\16\3\2\2\2\16\3\3\2\2\2\17\30\7\b"+
		"\2\2\20\22\7\3\2\2\21\23\5\6\4\2\22\21\3\2\2\2\23\24\3\2\2\2\24\22\3\2"+
		"\2\2\24\25\3\2\2\2\25\26\3\2\2\2\26\27\7\4\2\2\27\31\3\2\2\2\30\20\3\2"+
		"\2\2\30\31\3\2\2\2\31\5\3\2\2\2\32\33\7\7\2\2\33\7\3\2\2\2\5\r\24\30";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}