// Generated from C:/Users/Tommaso/Documents/Progetti/Java/Jlambda/src/main/java/com/jlambda/core\Jlambda.g4 by ANTLR 4.9.2
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
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		VARIABLE=10, STRING=11, FLOAT=12, INT=13, BOOL=14, COOMENT=15, WS=16;
	public static final int
		RULE_expr = 0, RULE_let = 1, RULE_stmt = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"expr", "let", "stmt"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'in'", "'\u00CE\u00BB'", "'fun'", "'.'", "'->'", "'('", "')'", 
			"'let'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "VARIABLE", 
			"STRING", "FLOAT", "INT", "BOOL", "COOMENT", "WS"
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
		public TerminalNode VARIABLE() { return getToken(JlambdaParser.VARIABLE, 0); }
		public TerminalNode STRING() { return getToken(JlambdaParser.STRING, 0); }
		public TerminalNode FLOAT() { return getToken(JlambdaParser.FLOAT, 0); }
		public TerminalNode INT() { return getToken(JlambdaParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(JlambdaParser.BOOL, 0); }
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
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				{
				setState(7);
				let();
				setState(8);
				match(T__0);
				setState(9);
				expr(9);
				}
				break;
			case T__1:
			case T__2:
				{
				setState(11);
				_la = _input.LA(1);
				if ( !(_la==T__1 || _la==T__2) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(12);
				match(VARIABLE);
				setState(13);
				_la = _input.LA(1);
				if ( !(_la==T__3 || _la==T__4) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(14);
				expr(8);
				}
				break;
			case STRING:
				{
				setState(15);
				match(STRING);
				}
				break;
			case FLOAT:
				{
				setState(16);
				match(FLOAT);
				}
				break;
			case INT:
				{
				setState(17);
				match(INT);
				}
				break;
			case BOOL:
				{
				setState(18);
				match(BOOL);
				}
				break;
			case VARIABLE:
				{
				setState(19);
				match(VARIABLE);
				}
				break;
			case T__5:
				{
				setState(20);
				match(T__5);
				setState(21);
				expr(0);
				setState(22);
				match(T__6);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(34);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(26);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(28); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(27);
							expr(0);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(30); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					} 
				}
				setState(36);
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
		enterRule(_localctx, 2, RULE_let);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			match(T__7);
			setState(38);
			match(VARIABLE);
			setState(39);
			match(T__8);
			setState(40);
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

	public static class StmtContext extends ParserRuleContext {
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
		enterRule(_localctx, 4, RULE_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__5) | (1L << T__7) | (1L << VARIABLE) | (1L << STRING) | (1L << FLOAT) | (1L << INT) | (1L << BOOL))) != 0)) {
				{
				setState(44);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(42);
					let();
					}
					break;
				case 2:
					{
					setState(43);
					expr(0);
					}
					break;
				}
				}
				setState(48);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\22\64\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\5\2\33\n\2\3\2\3\2\6\2\37\n\2\r\2\16\2 \7\2#\n\2\f\2\16"+
		"\2&\13\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\7\4/\n\4\f\4\16\4\62\13\4\3\4\2\3"+
		"\2\5\2\4\6\2\4\3\2\4\5\3\2\6\7\2;\2\32\3\2\2\2\4\'\3\2\2\2\6\60\3\2\2"+
		"\2\b\t\b\2\1\2\t\n\5\4\3\2\n\13\7\3\2\2\13\f\5\2\2\13\f\33\3\2\2\2\r\16"+
		"\t\2\2\2\16\17\7\f\2\2\17\20\t\3\2\2\20\33\5\2\2\n\21\33\7\r\2\2\22\33"+
		"\7\16\2\2\23\33\7\17\2\2\24\33\7\20\2\2\25\33\7\f\2\2\26\27\7\b\2\2\27"+
		"\30\5\2\2\2\30\31\7\t\2\2\31\33\3\2\2\2\32\b\3\2\2\2\32\r\3\2\2\2\32\21"+
		"\3\2\2\2\32\22\3\2\2\2\32\23\3\2\2\2\32\24\3\2\2\2\32\25\3\2\2\2\32\26"+
		"\3\2\2\2\33$\3\2\2\2\34\36\f\3\2\2\35\37\5\2\2\2\36\35\3\2\2\2\37 \3\2"+
		"\2\2 \36\3\2\2\2 !\3\2\2\2!#\3\2\2\2\"\34\3\2\2\2#&\3\2\2\2$\"\3\2\2\2"+
		"$%\3\2\2\2%\3\3\2\2\2&$\3\2\2\2\'(\7\n\2\2()\7\f\2\2)*\7\13\2\2*+\5\2"+
		"\2\2+\5\3\2\2\2,/\5\4\3\2-/\5\2\2\2.,\3\2\2\2.-\3\2\2\2/\62\3\2\2\2\60"+
		".\3\2\2\2\60\61\3\2\2\2\61\7\3\2\2\2\62\60\3\2\2\2\7\32 $.\60";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}