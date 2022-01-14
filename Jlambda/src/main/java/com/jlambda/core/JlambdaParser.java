// Generated from C:/Users/Tommaso/Documents/Studio/Progetti/Java/Jlambda/src/main/java/com/jlambda/core\Jlambda.g4 by ANTLR 4.9.2
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
    static {
        RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, T__7 = 8, T__8 = 9,
            T__9 = 10, STRING = 11, FLOAT = 12, INT = 13, BOOL = 14, VARIABLE = 15, COMMENT = 16,
            WS = 17;
    public static final int
            RULE_stmt = 0, RULE_expr = 1, RULE_let = 2;

    private static String[] makeRuleNames() {
        return new String[] {
                "stmt", "expr", "let"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[] {
                null, "';'", "'in'", "'\u00CE\u00BB'", "'fun'", "'.'", "'->'", "'('",
                "')'", "'let'", "'='"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[] {
                null, null, null, null, null, null, null, null, null, null, null, "STRING",
                "FLOAT", "INT", "BOOL", "VARIABLE", "COMMENT", "WS"
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
    public String getGrammarFileName() {
        return "Jlambda.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public JlambdaParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    public static class StmtContext extends ParserRuleContext {
        public List<TerminalNode> EOF() {
            return getTokens(JlambdaParser.EOF);
        }

        public TerminalNode EOF(int i) {
            return getToken(JlambdaParser.EOF, i);
        }

        public List<LetContext> let() {
            return getRuleContexts(LetContext.class);
        }

        public LetContext let(int i) {
            return getRuleContext(LetContext.class, i);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public StmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_stmt;
        }
    }

    public final StmtContext stmt() throws RecognitionException {
        StmtContext _localctx = new StmtContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_stmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(14);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__6) | (1L << T__8) | (1L << STRING) | (1L << FLOAT) | (1L << INT) | (1L << BOOL) | (1L << VARIABLE))) != 0)) {
                    {
                        {
                            setState(8);
                            _errHandler.sync(this);
                            switch (getInterpreter().adaptivePredict(_input, 0, _ctx)) {
                                case 1: {
                                    setState(6);
                                    let();
                                }
                                break;
                                case 2: {
                                    setState(7);
                                    expr(0);
                                }
                                break;
                            }
                            setState(10);
                            _la = _input.LA(1);
                            if (!(_la == EOF || _la == T__0)) {
                                _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                        }
                    }
                    setState(16);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ExprContext extends ParserRuleContext {
        public LetContext let() {
            return getRuleContext(LetContext.class, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode VARIABLE() {
            return getToken(JlambdaParser.VARIABLE, 0);
        }

        public TerminalNode STRING() {
            return getToken(JlambdaParser.STRING, 0);
        }

        public TerminalNode FLOAT() {
            return getToken(JlambdaParser.FLOAT, 0);
        }

        public TerminalNode INT() {
            return getToken(JlambdaParser.INT, 0);
        }

        public TerminalNode BOOL() {
            return getToken(JlambdaParser.BOOL, 0);
        }

        public ExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_expr;
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
        int _startState = 2;
        enterRecursionRule(_localctx, 2, RULE_expr, _p);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(35);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case T__8: {
                        setState(18);
                        let();
                        setState(19);
                        match(T__1);
                        setState(20);
                        expr(9);
                    }
                    break;
                    case T__2:
                    case T__3: {
                        setState(22);
                        _la = _input.LA(1);
                        if (!(_la == T__2 || _la == T__3)) {
                            _errHandler.recoverInline(this);
                        } else {
                            if (_input.LA(1) == Token.EOF) matchedEOF = true;
                            _errHandler.reportMatch(this);
                            consume();
                        }
                        setState(23);
                        match(VARIABLE);
                        setState(24);
                        _la = _input.LA(1);
                        if (!(_la == T__4 || _la == T__5)) {
                            _errHandler.recoverInline(this);
                        } else {
                            if (_input.LA(1) == Token.EOF) matchedEOF = true;
                            _errHandler.reportMatch(this);
                            consume();
                        }
                        setState(25);
                        expr(8);
                    }
                    break;
                    case STRING: {
                        setState(26);
                        match(STRING);
                    }
                    break;
                    case FLOAT: {
                        setState(27);
                        match(FLOAT);
                    }
                    break;
                    case INT: {
                        setState(28);
                        match(INT);
                    }
                    break;
                    case BOOL: {
                        setState(29);
                        match(BOOL);
                    }
                    break;
                    case VARIABLE: {
                        setState(30);
                        match(VARIABLE);
                    }
                    break;
                    case T__6: {
                        setState(31);
                        match(T__6);
                        setState(32);
                        expr(0);
                        setState(33);
                        match(T__7);
                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                }
                _ctx.stop = _input.LT(-1);
                setState(45);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 4, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            {
                                _localctx = new ExprContext(_parentctx, _parentState);
                                pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                setState(37);
                                if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
                                setState(39);
                                _errHandler.sync(this);
                                _alt = 1;
                                do {
                                    switch (_alt) {
                                        case 1: {
                                            {
                                                setState(38);
                                                expr(0);
                                            }
                                        }
                                        break;
                                        default:
                                            throw new NoViableAltException(this);
                                    }
                                    setState(41);
                                    _errHandler.sync(this);
                                    _alt = getInterpreter().adaptivePredict(_input, 3, _ctx);
                                } while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
                            }
                        }
                    }
                    setState(47);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 4, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    public static class LetContext extends ParserRuleContext {
        public TerminalNode VARIABLE() {
            return getToken(JlambdaParser.VARIABLE, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public LetContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_let;
        }
    }

    public final LetContext let() throws RecognitionException {
        LetContext _localctx = new LetContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_let);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(48);
                match(T__8);
                setState(49);
                match(VARIABLE);
                setState(50);
                match(T__9);
                setState(51);
                expr(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
        switch (ruleIndex) {
            case 1:
                return expr_sempred((ExprContext) _localctx, predIndex);
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
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\238\4\2\t\2\4\3\t" +
                    "\3\4\4\t\4\3\2\3\2\5\2\13\n\2\3\2\3\2\7\2\17\n\2\f\2\16\2\22\13\2\3\3" +
                    "\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5" +
                    "\3&\n\3\3\3\3\3\6\3*\n\3\r\3\16\3+\7\3.\n\3\f\3\16\3\61\13\3\3\4\3\4\3" +
                    "\4\3\4\3\4\3\4\2\3\4\5\2\4\6\2\5\3\3\3\3\3\2\5\6\3\2\7\b\2?\2\20\3\2\2" +
                    "\2\4%\3\2\2\2\6\62\3\2\2\2\b\13\5\6\4\2\t\13\5\4\3\2\n\b\3\2\2\2\n\t\3" +
                    "\2\2\2\13\f\3\2\2\2\f\r\t\2\2\2\r\17\3\2\2\2\16\n\3\2\2\2\17\22\3\2\2" +
                    "\2\20\16\3\2\2\2\20\21\3\2\2\2\21\3\3\2\2\2\22\20\3\2\2\2\23\24\b\3\1" +
                    "\2\24\25\5\6\4\2\25\26\7\4\2\2\26\27\5\4\3\13\27&\3\2\2\2\30\31\t\3\2" +
                    "\2\31\32\7\21\2\2\32\33\t\4\2\2\33&\5\4\3\n\34&\7\r\2\2\35&\7\16\2\2\36" +
                    "&\7\17\2\2\37&\7\20\2\2 &\7\21\2\2!\"\7\t\2\2\"#\5\4\3\2#$\7\n\2\2$&\3" +
                    "\2\2\2%\23\3\2\2\2%\30\3\2\2\2%\34\3\2\2\2%\35\3\2\2\2%\36\3\2\2\2%\37" +
                    "\3\2\2\2% \3\2\2\2%!\3\2\2\2&/\3\2\2\2\')\f\3\2\2(*\5\4\3\2)(\3\2\2\2" +
                    "*+\3\2\2\2+)\3\2\2\2+,\3\2\2\2,.\3\2\2\2-\'\3\2\2\2.\61\3\2\2\2/-\3\2" +
                    "\2\2/\60\3\2\2\2\60\5\3\2\2\2\61/\3\2\2\2\62\63\7\13\2\2\63\64\7\21\2" +
                    "\2\64\65\7\f\2\2\65\66\5\4\3\2\66\7\3\2\2\2\7\n\20%+/";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}