// Generated from java-escape by ANTLR 4.11.1
package com.jlambda.core;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class JlambdaParser extends Parser {
	static {}

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
		int _la;
		try {
			int _alt;
			setState(47);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(25);
				let();
				setState(26);
				match(T__1);
				setState(27);
				expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(29);
				fun();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(30);
				select();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(31);
				load();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(32);
				match(STRING);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(33);
				match(FLOAT);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(34);
				match(INT);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(35);
				match(BOOL);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(36);
				match(VARIABLE);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(37);
				match(T__2);
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 8163944L) != 0) {
					{
					setState(38);
					expr();
					}
				}

				setState(41);
				match(T__3);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(43); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(42);
						subexpr();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(45); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
			setState(66);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				let();
				setState(50);
				match(T__1);
				setState(51);
				expr();
				}
				break;
			case T__4:
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(53);
				fun();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 3);
				{
				setState(54);
				select();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 4);
				{
				setState(55);
				load();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 5);
				{
				setState(56);
				match(STRING);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 6);
				{
				setState(57);
				match(FLOAT);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 7);
				{
				setState(58);
				match(INT);
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 8);
				{
				setState(59);
				match(BOOL);
				}
				break;
			case VARIABLE:
				enterOuterAlt(_localctx, 9);
				{
				setState(60);
				match(VARIABLE);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 10);
				{
				setState(61);
				match(T__2);
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 8163944L) != 0) {
					{
					setState(62);
					expr();
					}
				}

				setState(65);
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
			setState(68);
			_la = _input.LA(1);
			if ( !(_la==T__4 || _la==T__5) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(69);
			match(VARIABLE);
			setState(70);
			_la = _input.LA(1);
			if ( !(_la==T__6 || _la==T__7) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(71);
			match(T__2);
			setState(72);
			expr();
			setState(73);
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
			setState(75);
			match(T__8);
			setState(76);
			expr();
			setState(77);
			match(T__9);
			setState(78);
			expr();
			setState(79);
			match(T__10);
			setState(80);
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
			setState(82);
			match(T__11);
			setState(83);
			match(VARIABLE);
			setState(84);
			match(T__12);
			setState(87);
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
				setState(85);
				expr();
				}
				break;
			case T__13:
				{
				setState(86);
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
			setState(89);
			match(T__14);
			setState(90);
			match(VARIABLE);
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(91);
				match(T__6);
				setState(92);
				match(VARIABLE);
				}
				}
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(98);
			match(T__2);
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VARIABLE) {
				{
				setState(99);
				match(VARIABLE);
				}
			}

			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__15) {
				{
				{
				setState(102);
				match(T__15);
				setState(103);
				match(VARIABLE);
				}
				}
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(109);
			match(T__3);
			setState(110);
			match(T__16);
			setState(111);
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
		"\u0004\u0001\u0018r\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0001\u0000\u0001\u0000\u0003"+
		"\u0000\u0011\b\u0000\u0001\u0000\u0001\u0000\u0005\u0000\u0015\b\u0000"+
		"\n\u0000\f\u0000\u0018\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001(\b"+
		"\u0001\u0001\u0001\u0001\u0001\u0004\u0001,\b\u0001\u000b\u0001\f\u0001"+
		"-\u0003\u00010\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002@\b\u0002"+
		"\u0001\u0002\u0003\u0002C\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005X\b\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006^\b\u0006"+
		"\n\u0006\f\u0006a\t\u0006\u0001\u0006\u0001\u0006\u0003\u0006e\b\u0006"+
		"\u0001\u0006\u0001\u0006\u0005\u0006i\b\u0006\n\u0006\f\u0006l\t\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0000\u0000"+
		"\u0007\u0000\u0002\u0004\u0006\b\n\f\u0000\u0003\u0001\u0001\u0001\u0001"+
		"\u0001\u0000\u0005\u0006\u0001\u0000\u0007\b\u0086\u0000\u0016\u0001\u0000"+
		"\u0000\u0000\u0002/\u0001\u0000\u0000\u0000\u0004B\u0001\u0000\u0000\u0000"+
		"\u0006D\u0001\u0000\u0000\u0000\bK\u0001\u0000\u0000\u0000\nR\u0001\u0000"+
		"\u0000\u0000\fY\u0001\u0000\u0000\u0000\u000e\u0011\u0003\n\u0005\u0000"+
		"\u000f\u0011\u0003\u0002\u0001\u0000\u0010\u000e\u0001\u0000\u0000\u0000"+
		"\u0010\u000f\u0001\u0000\u0000\u0000\u0011\u0012\u0001\u0000\u0000\u0000"+
		"\u0012\u0013\u0007\u0000\u0000\u0000\u0013\u0015\u0001\u0000\u0000\u0000"+
		"\u0014\u0010\u0001\u0000\u0000\u0000\u0015\u0018\u0001\u0000\u0000\u0000"+
		"\u0016\u0014\u0001\u0000\u0000\u0000\u0016\u0017\u0001\u0000\u0000\u0000"+
		"\u0017\u0001\u0001\u0000\u0000\u0000\u0018\u0016\u0001\u0000\u0000\u0000"+
		"\u0019\u001a\u0003\n\u0005\u0000\u001a\u001b\u0005\u0002\u0000\u0000\u001b"+
		"\u001c\u0003\u0002\u0001\u0000\u001c0\u0001\u0000\u0000\u0000\u001d0\u0003"+
		"\u0006\u0003\u0000\u001e0\u0003\b\u0004\u0000\u001f0\u0003\f\u0006\u0000"+
		" 0\u0005\u0012\u0000\u0000!0\u0005\u0013\u0000\u0000\"0\u0005\u0014\u0000"+
		"\u0000#0\u0005\u0015\u0000\u0000$0\u0005\u0016\u0000\u0000%\'\u0005\u0003"+
		"\u0000\u0000&(\u0003\u0002\u0001\u0000\'&\u0001\u0000\u0000\u0000\'(\u0001"+
		"\u0000\u0000\u0000()\u0001\u0000\u0000\u0000)0\u0005\u0004\u0000\u0000"+
		"*,\u0003\u0004\u0002\u0000+*\u0001\u0000\u0000\u0000,-\u0001\u0000\u0000"+
		"\u0000-+\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000.0\u0001\u0000"+
		"\u0000\u0000/\u0019\u0001\u0000\u0000\u0000/\u001d\u0001\u0000\u0000\u0000"+
		"/\u001e\u0001\u0000\u0000\u0000/\u001f\u0001\u0000\u0000\u0000/ \u0001"+
		"\u0000\u0000\u0000/!\u0001\u0000\u0000\u0000/\"\u0001\u0000\u0000\u0000"+
		"/#\u0001\u0000\u0000\u0000/$\u0001\u0000\u0000\u0000/%\u0001\u0000\u0000"+
		"\u0000/+\u0001\u0000\u0000\u00000\u0003\u0001\u0000\u0000\u000012\u0003"+
		"\n\u0005\u000023\u0005\u0002\u0000\u000034\u0003\u0002\u0001\u00004C\u0001"+
		"\u0000\u0000\u00005C\u0003\u0006\u0003\u00006C\u0003\b\u0004\u00007C\u0003"+
		"\f\u0006\u00008C\u0005\u0012\u0000\u00009C\u0005\u0013\u0000\u0000:C\u0005"+
		"\u0014\u0000\u0000;C\u0005\u0015\u0000\u0000<C\u0005\u0016\u0000\u0000"+
		"=?\u0005\u0003\u0000\u0000>@\u0003\u0002\u0001\u0000?>\u0001\u0000\u0000"+
		"\u0000?@\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000AC\u0005\u0004"+
		"\u0000\u0000B1\u0001\u0000\u0000\u0000B5\u0001\u0000\u0000\u0000B6\u0001"+
		"\u0000\u0000\u0000B7\u0001\u0000\u0000\u0000B8\u0001\u0000\u0000\u0000"+
		"B9\u0001\u0000\u0000\u0000B:\u0001\u0000\u0000\u0000B;\u0001\u0000\u0000"+
		"\u0000B<\u0001\u0000\u0000\u0000B=\u0001\u0000\u0000\u0000C\u0005\u0001"+
		"\u0000\u0000\u0000DE\u0007\u0001\u0000\u0000EF\u0005\u0016\u0000\u0000"+
		"FG\u0007\u0002\u0000\u0000GH\u0005\u0003\u0000\u0000HI\u0003\u0002\u0001"+
		"\u0000IJ\u0005\u0004\u0000\u0000J\u0007\u0001\u0000\u0000\u0000KL\u0005"+
		"\t\u0000\u0000LM\u0003\u0002\u0001\u0000MN\u0005\n\u0000\u0000NO\u0003"+
		"\u0002\u0001\u0000OP\u0005\u000b\u0000\u0000PQ\u0003\u0002\u0001\u0000"+
		"Q\t\u0001\u0000\u0000\u0000RS\u0005\f\u0000\u0000ST\u0005\u0016\u0000"+
		"\u0000TW\u0005\r\u0000\u0000UX\u0003\u0002\u0001\u0000VX\u0005\u000e\u0000"+
		"\u0000WU\u0001\u0000\u0000\u0000WV\u0001\u0000\u0000\u0000X\u000b\u0001"+
		"\u0000\u0000\u0000YZ\u0005\u000f\u0000\u0000Z_\u0005\u0016\u0000\u0000"+
		"[\\\u0005\u0007\u0000\u0000\\^\u0005\u0016\u0000\u0000][\u0001\u0000\u0000"+
		"\u0000^a\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000_`\u0001\u0000"+
		"\u0000\u0000`b\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000bd\u0005"+
		"\u0003\u0000\u0000ce\u0005\u0016\u0000\u0000dc\u0001\u0000\u0000\u0000"+
		"de\u0001\u0000\u0000\u0000ej\u0001\u0000\u0000\u0000fg\u0005\u0010\u0000"+
		"\u0000gi\u0005\u0016\u0000\u0000hf\u0001\u0000\u0000\u0000il\u0001\u0000"+
		"\u0000\u0000jh\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000km\u0001"+
		"\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000mn\u0005\u0004\u0000\u0000"+
		"no\u0005\u0011\u0000\u0000op\u0005\u0016\u0000\u0000p\r\u0001\u0000\u0000"+
		"\u0000\u000b\u0010\u0016\'-/?BW_dj";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}