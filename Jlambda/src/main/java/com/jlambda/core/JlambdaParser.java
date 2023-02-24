// Generated from java-escape by ANTLR 4.11.1
package com.jlambda.core;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class JlambdaParser extends Parser {
	static { }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		STRING=18, FLOAT=19, INT=20, BOOL=21, VARIABLE=22, COMMENT=23, WS=24;
	public static final int
		RULE_stmt = 0, RULE_expr = 1, RULE_subexpr = 2, RULE_fun = 3, RULE_select = 4, 
		RULE_let = 5, RULE_load = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"stmt", "expr", "subexpr", "fun", "select", "let", "load"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'in'", "'('", "')'", "'\\u00CE\\u00BB'", "'fun'", "'.'", 
			"'->'", "'if'", "'then'", "'else'", "'let'", "'='", "'free'", "'load'", 
			"','", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "STRING", "FLOAT", "INT", "BOOL", 
			"VARIABLE", "COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JlambdaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StmtContext extends ParserRuleContext {
		public List<TerminalNode> EOF() { return getTokens(JlambdaParser.EOF); }
		public TerminalNode EOF(int i) {
			return getToken(JlambdaParser.EOF, i);
		}
		public List<LetContext> let() {
			return getRuleContexts(LetContext.class);
		}
		public LetContext let(int i) {
			return getRuleContext(LetContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 8163944L) != 0) {
				{
				{
				setState(16);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(14);
					let();
					}
					break;
				case 2:
					{
					setState(15);
					expr();
					}
					break;
				}
				setState(18);
				_la = _input.LA(1);
				if ( !(_la==EOF || _la==T__0) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(24);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public List<SubexprContext> subexpr() {
			return getRuleContexts(SubexprContext.class);
		}
		public SubexprContext subexpr(int i) {
			return getRuleContext(SubexprContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(26); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(25);
					subexpr();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(28); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	@SuppressWarnings("CheckReturnValue")
	public static class SubexprContext extends ParserRuleContext {
		public LetContext let() {
			return getRuleContext(LetContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FunContext fun() {
			return getRuleContext(FunContext.class,0);
		}
		public SelectContext select() {
			return getRuleContext(SelectContext.class,0);
		}
		public LoadContext load() {
			return getRuleContext(LoadContext.class,0);
		}
		public TerminalNode STRING() { return getToken(JlambdaParser.STRING, 0); }
		public TerminalNode FLOAT() { return getToken(JlambdaParser.FLOAT, 0); }
		public TerminalNode INT() { return getToken(JlambdaParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(JlambdaParser.BOOL, 0); }
		public TerminalNode VARIABLE() { return getToken(JlambdaParser.VARIABLE, 0); }
		public SubexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subexpr; }
	}

	public final SubexprContext subexpr() throws RecognitionException {
		SubexprContext _localctx = new SubexprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_subexpr);
		int _la;
		try {
			setState(47);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(30);
				let();
				setState(31);
				match(T__1);
				setState(32);
				expr();
				}
				break;
			case T__4:
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(34);
				fun();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 3);
				{
				setState(35);
				select();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 4);
				{
				setState(36);
				load();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 5);
				{
				setState(37);
				match(STRING);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 6);
				{
				setState(38);
				match(FLOAT);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 7);
				{
				setState(39);
				match(INT);
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 8);
				{
				setState(40);
				match(BOOL);
				}
				break;
			case VARIABLE:
				enterOuterAlt(_localctx, 9);
				{
				setState(41);
				match(VARIABLE);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 10);
				{
				setState(42);
				match(T__2);
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 8163944L) != 0) {
					{
					setState(43);
					expr();
					}
				}

				setState(46);
				match(T__3);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunContext extends ParserRuleContext {
		public TerminalNode VARIABLE() { return getToken(JlambdaParser.VARIABLE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fun; }
	}

	public final FunContext fun() throws RecognitionException {
		FunContext _localctx = new FunContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_fun);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			_la = _input.LA(1);
			if ( !(_la==T__4 || _la==T__5) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(50);
			match(VARIABLE);
			setState(51);
			_la = _input.LA(1);
			if ( !(_la==T__6 || _la==T__7) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(52);
			match(T__2);
			setState(53);
			expr();
			setState(54);
			match(T__3);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SelectContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public SelectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select; }
	}

	public final SelectContext select() throws RecognitionException {
		SelectContext _localctx = new SelectContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_select);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(T__8);
			setState(57);
			expr();
			setState(58);
			match(T__9);
			setState(59);
			expr();
			setState(60);
			match(T__10);
			setState(61);
			expr();
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

	@SuppressWarnings("CheckReturnValue")
	public static class LetContext extends ParserRuleContext {
		public TerminalNode VARIABLE() { return getToken(JlambdaParser.VARIABLE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let; }
	}

	public final LetContext let() throws RecognitionException {
		LetContext _localctx = new LetContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_let);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(T__11);
			setState(64);
			match(VARIABLE);
			setState(65);
			match(T__12);
			setState(68);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__4:
			case T__5:
			case T__8:
			case T__11:
			case T__14:
			case STRING:
			case FLOAT:
			case INT:
			case BOOL:
			case VARIABLE:
				{
				setState(66);
				expr();
				}
				break;
			case T__13:
				{
				setState(67);
				match(T__13);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LoadContext extends ParserRuleContext {
		public List<TerminalNode> VARIABLE() { return getTokens(JlambdaParser.VARIABLE); }
		public TerminalNode VARIABLE(int i) {
			return getToken(JlambdaParser.VARIABLE, i);
		}
		public LoadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_load; }
	}

	public final LoadContext load() throws RecognitionException {
		LoadContext _localctx = new LoadContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_load);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(T__14);
			setState(71);
			match(VARIABLE);
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(72);
				match(T__6);
				setState(73);
				match(VARIABLE);
				}
				}
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(79);
			match(T__2);
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VARIABLE) {
				{
				setState(80);
				match(VARIABLE);
				}
			}

			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__15) {
				{
				{
				setState(83);
				match(T__15);
				setState(84);
				match(VARIABLE);
				}
				}
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(90);
			match(T__3);
			setState(91);
			match(T__16);
			setState(92);
			match(VARIABLE);
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
		"\u0004\u0001\u0018_\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0001\u0000\u0001\u0000\u0003"+
		"\u0000\u0011\b\u0000\u0001\u0000\u0001\u0000\u0005\u0000\u0015\b\u0000"+
		"\n\u0000\f\u0000\u0018\t\u0000\u0001\u0001\u0004\u0001\u001b\b\u0001\u000b"+
		"\u0001\f\u0001\u001c\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002-\b\u0002\u0001"+
		"\u0002\u0003\u00020\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005E\b\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006K\b\u0006\n\u0006"+
		"\f\u0006N\t\u0006\u0001\u0006\u0001\u0006\u0003\u0006R\b\u0006\u0001\u0006"+
		"\u0001\u0006\u0005\u0006V\b\u0006\n\u0006\f\u0006Y\t\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0000\u0000\u0007\u0000"+
		"\u0002\u0004\u0006\b\n\f\u0000\u0003\u0001\u0001\u0001\u0001\u0001\u0000"+
		"\u0005\u0006\u0001\u0000\u0007\bh\u0000\u0016\u0001\u0000\u0000\u0000"+
		"\u0002\u001a\u0001\u0000\u0000\u0000\u0004/\u0001\u0000\u0000\u0000\u0006"+
		"1\u0001\u0000\u0000\u0000\b8\u0001\u0000\u0000\u0000\n?\u0001\u0000\u0000"+
		"\u0000\fF\u0001\u0000\u0000\u0000\u000e\u0011\u0003\n\u0005\u0000\u000f"+
		"\u0011\u0003\u0002\u0001\u0000\u0010\u000e\u0001\u0000\u0000\u0000\u0010"+
		"\u000f\u0001\u0000\u0000\u0000\u0011\u0012\u0001\u0000\u0000\u0000\u0012"+
		"\u0013\u0007\u0000\u0000\u0000\u0013\u0015\u0001\u0000\u0000\u0000\u0014"+
		"\u0010\u0001\u0000\u0000\u0000\u0015\u0018\u0001\u0000\u0000\u0000\u0016"+
		"\u0014\u0001\u0000\u0000\u0000\u0016\u0017\u0001\u0000\u0000\u0000\u0017"+
		"\u0001\u0001\u0000\u0000\u0000\u0018\u0016\u0001\u0000\u0000\u0000\u0019"+
		"\u001b\u0003\u0004\u0002\u0000\u001a\u0019\u0001\u0000\u0000\u0000\u001b"+
		"\u001c\u0001\u0000\u0000\u0000\u001c\u001a\u0001\u0000\u0000\u0000\u001c"+
		"\u001d\u0001\u0000\u0000\u0000\u001d\u0003\u0001\u0000\u0000\u0000\u001e"+
		"\u001f\u0003\n\u0005\u0000\u001f \u0005\u0002\u0000\u0000 !\u0003\u0002"+
		"\u0001\u0000!0\u0001\u0000\u0000\u0000\"0\u0003\u0006\u0003\u0000#0\u0003"+
		"\b\u0004\u0000$0\u0003\f\u0006\u0000%0\u0005\u0012\u0000\u0000&0\u0005"+
		"\u0013\u0000\u0000\'0\u0005\u0014\u0000\u0000(0\u0005\u0015\u0000\u0000"+
		")0\u0005\u0016\u0000\u0000*,\u0005\u0003\u0000\u0000+-\u0003\u0002\u0001"+
		"\u0000,+\u0001\u0000\u0000\u0000,-\u0001\u0000\u0000\u0000-.\u0001\u0000"+
		"\u0000\u0000.0\u0005\u0004\u0000\u0000/\u001e\u0001\u0000\u0000\u0000"+
		"/\"\u0001\u0000\u0000\u0000/#\u0001\u0000\u0000\u0000/$\u0001\u0000\u0000"+
		"\u0000/%\u0001\u0000\u0000\u0000/&\u0001\u0000\u0000\u0000/\'\u0001\u0000"+
		"\u0000\u0000/(\u0001\u0000\u0000\u0000/)\u0001\u0000\u0000\u0000/*\u0001"+
		"\u0000\u0000\u00000\u0005\u0001\u0000\u0000\u000012\u0007\u0001\u0000"+
		"\u000023\u0005\u0016\u0000\u000034\u0007\u0002\u0000\u000045\u0005\u0003"+
		"\u0000\u000056\u0003\u0002\u0001\u000067\u0005\u0004\u0000\u00007\u0007"+
		"\u0001\u0000\u0000\u000089\u0005\t\u0000\u00009:\u0003\u0002\u0001\u0000"+
		":;\u0005\n\u0000\u0000;<\u0003\u0002\u0001\u0000<=\u0005\u000b\u0000\u0000"+
		"=>\u0003\u0002\u0001\u0000>\t\u0001\u0000\u0000\u0000?@\u0005\f\u0000"+
		"\u0000@A\u0005\u0016\u0000\u0000AD\u0005\r\u0000\u0000BE\u0003\u0002\u0001"+
		"\u0000CE\u0005\u000e\u0000\u0000DB\u0001\u0000\u0000\u0000DC\u0001\u0000"+
		"\u0000\u0000E\u000b\u0001\u0000\u0000\u0000FG\u0005\u000f\u0000\u0000"+
		"GL\u0005\u0016\u0000\u0000HI\u0005\u0007\u0000\u0000IK\u0005\u0016\u0000"+
		"\u0000JH\u0001\u0000\u0000\u0000KN\u0001\u0000\u0000\u0000LJ\u0001\u0000"+
		"\u0000\u0000LM\u0001\u0000\u0000\u0000MO\u0001\u0000\u0000\u0000NL\u0001"+
		"\u0000\u0000\u0000OQ\u0005\u0003\u0000\u0000PR\u0005\u0016\u0000\u0000"+
		"QP\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000RW\u0001\u0000\u0000"+
		"\u0000ST\u0005\u0010\u0000\u0000TV\u0005\u0016\u0000\u0000US\u0001\u0000"+
		"\u0000\u0000VY\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000WX\u0001"+
		"\u0000\u0000\u0000XZ\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000"+
		"Z[\u0005\u0004\u0000\u0000[\\\u0005\u0011\u0000\u0000\\]\u0005\u0016\u0000"+
		"\u0000]\r\u0001\u0000\u0000\u0000\t\u0010\u0016\u001c,/DLQW";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}