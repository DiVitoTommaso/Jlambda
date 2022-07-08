// Generated from C:/Users/Tommaso/Documents/Studio/Progetti/Java/Jlambda/src/main/java/com/jlambda/core\Jlambda.g4 by ANTLR 4.10.1
package com.jlambda.core;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JlambdaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, STRING=15, FLOAT=16, 
		INT=17, BOOL=18, VARIABLE=19, COMMENT=20, WS=21;
	public static final int
		RULE_stmt = 0, RULE_expr = 1, RULE_fun = 2, RULE_select = 3, RULE_let = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"stmt", "expr", "fun", "select", "let"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'in'", "'('", "')'", "'\\u00CE\\u00BB'", "'fun'", "'.'", 
			"'->'", "'if'", "'then'", "'else'", "'let'", "'='", "'free'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "STRING", "FLOAT", "INT", "BOOL", "VARIABLE", "COMMENT", 
			"WS"
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
	public String getGrammarFileName() { return "Jlambda.g4"; }

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
			setState(18);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__4) | (1L << T__5) | (1L << T__8) | (1L << T__11) | (1L << STRING) | (1L << FLOAT) | (1L << INT) | (1L << BOOL) | (1L << VARIABLE))) != 0)) {
				{
				{
				setState(12);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(10);
					let();
					}
					break;
				case 2:
					{
					setState(11);
					expr(0);
					}
					break;
				}
				setState(14);
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
				setState(20);
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

	public static class ExprContext extends ParserRuleContext {
		public LetContext let() {
			return getRuleContext(LetContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FunContext fun() {
			return getRuleContext(FunContext.class,0);
		}
		public SelectContext select() {
			return getRuleContext(SelectContext.class,0);
		}
		public TerminalNode STRING() { return getToken(JlambdaParser.STRING, 0); }
		public TerminalNode FLOAT() { return getToken(JlambdaParser.FLOAT, 0); }
		public TerminalNode INT() { return getToken(JlambdaParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(JlambdaParser.BOOL, 0); }
		public TerminalNode VARIABLE() { return getToken(JlambdaParser.VARIABLE, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }

	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				{
				setState(22);
				let();
				setState(23);
				match(T__1);
				setState(24);
				expr(10);
				}
				break;
			case T__4:
			case T__5:
				{
				setState(26);
				fun();
				}
				break;
			case T__8:
				{
				setState(27);
				select();
				}
				break;
			case STRING:
				{
				setState(28);
				match(STRING);
				}
				break;
			case FLOAT:
				{
				setState(29);
				match(FLOAT);
				}
				break;
			case INT:
				{
				setState(30);
				match(INT);
				}
				break;
			case BOOL:
				{
				setState(31);
				match(BOOL);
				}
				break;
			case VARIABLE:
				{
				setState(32);
				match(VARIABLE);
				}
				break;
			case T__2:
				{
				setState(33);
				match(T__2);
				setState(34);
				expr(0);
				setState(35);
				match(T__3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(47);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(39);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(41); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(40);
							expr(0);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(43); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					} 
				}
				setState(49);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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
		enterRule(_localctx, 4, RULE_fun);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			_la = _input.LA(1);
			if ( !(_la==T__4 || _la==T__5) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(51);
			match(VARIABLE);
			setState(52);
			_la = _input.LA(1);
			if ( !(_la==T__6 || _la==T__7) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(53);
			match(T__2);
			setState(54);
			expr(0);
			setState(55);
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
		enterRule(_localctx, 6, RULE_select);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(T__8);
			setState(58);
			expr(0);
			setState(59);
			match(T__9);
			setState(60);
			expr(0);
			setState(61);
			match(T__10);
			setState(62);
			expr(0);
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
		enterRule(_localctx, 8, RULE_let);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(T__11);
			setState(65);
			match(VARIABLE);
			setState(66);
			match(T__12);
			setState(69);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__4:
			case T__5:
			case T__8:
			case T__11:
			case STRING:
			case FLOAT:
			case INT:
			case BOOL:
			case VARIABLE:
				{
				setState(67);
				expr(0);
				}
				break;
			case T__13:
				{
				setState(68);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0015H\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0001"+
		"\u0000\u0001\u0000\u0003\u0000\r\b\u0000\u0001\u0000\u0001\u0000\u0005"+
		"\u0000\u0011\b\u0000\n\u0000\f\u0000\u0014\t\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001&\b\u0001\u0001\u0001\u0001\u0001"+
		"\u0004\u0001*\b\u0001\u000b\u0001\f\u0001+\u0005\u0001.\b\u0001\n\u0001"+
		"\f\u00011\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0003\u0004F\b\u0004\u0001\u0004\u0000"+
		"\u0001\u0002\u0005\u0000\u0002\u0004\u0006\b\u0000\u0003\u0001\u0001\u0001"+
		"\u0001\u0001\u0000\u0005\u0006\u0001\u0000\u0007\bO\u0000\u0012\u0001"+
		"\u0000\u0000\u0000\u0002%\u0001\u0000\u0000\u0000\u00042\u0001\u0000\u0000"+
		"\u0000\u00069\u0001\u0000\u0000\u0000\b@\u0001\u0000\u0000\u0000\n\r\u0003"+
		"\b\u0004\u0000\u000b\r\u0003\u0002\u0001\u0000\f\n\u0001\u0000\u0000\u0000"+
		"\f\u000b\u0001\u0000\u0000\u0000\r\u000e\u0001\u0000\u0000\u0000\u000e"+
		"\u000f\u0007\u0000\u0000\u0000\u000f\u0011\u0001\u0000\u0000\u0000\u0010"+
		"\f\u0001\u0000\u0000\u0000\u0011\u0014\u0001\u0000\u0000\u0000\u0012\u0010"+
		"\u0001\u0000\u0000\u0000\u0012\u0013\u0001\u0000\u0000\u0000\u0013\u0001"+
		"\u0001\u0000\u0000\u0000\u0014\u0012\u0001\u0000\u0000\u0000\u0015\u0016"+
		"\u0006\u0001\uffff\uffff\u0000\u0016\u0017\u0003\b\u0004\u0000\u0017\u0018"+
		"\u0005\u0002\u0000\u0000\u0018\u0019\u0003\u0002\u0001\n\u0019&\u0001"+
		"\u0000\u0000\u0000\u001a&\u0003\u0004\u0002\u0000\u001b&\u0003\u0006\u0003"+
		"\u0000\u001c&\u0005\u000f\u0000\u0000\u001d&\u0005\u0010\u0000\u0000\u001e"+
		"&\u0005\u0011\u0000\u0000\u001f&\u0005\u0012\u0000\u0000 &\u0005\u0013"+
		"\u0000\u0000!\"\u0005\u0003\u0000\u0000\"#\u0003\u0002\u0001\u0000#$\u0005"+
		"\u0004\u0000\u0000$&\u0001\u0000\u0000\u0000%\u0015\u0001\u0000\u0000"+
		"\u0000%\u001a\u0001\u0000\u0000\u0000%\u001b\u0001\u0000\u0000\u0000%"+
		"\u001c\u0001\u0000\u0000\u0000%\u001d\u0001\u0000\u0000\u0000%\u001e\u0001"+
		"\u0000\u0000\u0000%\u001f\u0001\u0000\u0000\u0000% \u0001\u0000\u0000"+
		"\u0000%!\u0001\u0000\u0000\u0000&/\u0001\u0000\u0000\u0000\')\n\u0001"+
		"\u0000\u0000(*\u0003\u0002\u0001\u0000)(\u0001\u0000\u0000\u0000*+\u0001"+
		"\u0000\u0000\u0000+)\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000"+
		",.\u0001\u0000\u0000\u0000-\'\u0001\u0000\u0000\u0000.1\u0001\u0000\u0000"+
		"\u0000/-\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000\u00000\u0003\u0001"+
		"\u0000\u0000\u00001/\u0001\u0000\u0000\u000023\u0007\u0001\u0000\u0000"+
		"34\u0005\u0013\u0000\u000045\u0007\u0002\u0000\u000056\u0005\u0003\u0000"+
		"\u000067\u0003\u0002\u0001\u000078\u0005\u0004\u0000\u00008\u0005\u0001"+
		"\u0000\u0000\u00009:\u0005\t\u0000\u0000:;\u0003\u0002\u0001\u0000;<\u0005"+
		"\n\u0000\u0000<=\u0003\u0002\u0001\u0000=>\u0005\u000b\u0000\u0000>?\u0003"+
		"\u0002\u0001\u0000?\u0007\u0001\u0000\u0000\u0000@A\u0005\f\u0000\u0000"+
		"AB\u0005\u0013\u0000\u0000BE\u0005\r\u0000\u0000CF\u0003\u0002\u0001\u0000"+
		"DF\u0005\u000e\u0000\u0000EC\u0001\u0000\u0000\u0000ED\u0001\u0000\u0000"+
		"\u0000F\t\u0001\u0000\u0000\u0000\u0006\f\u0012%+/E";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}