package com.jlambda.core;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class JlambdaParser extends Parser {
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, T__7 = 8, T__8 = 9,
            T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, T__13 = 14, T__14 = 15, T__15 = 16, T__16 = 17,
            T__17 = 18, T__18 = 19, T__19 = 20, T__20 = 21, T__21 = 22, STRING = 23, FLOAT = 24,
            INT = 25, BOOL = 26, VARIABLE = 27, COMMENT = 28, WS = 29;
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
                null, "';'", "'|'", "'by'", "'value'", "'name'", "'with'", "'steps'",
                "'in'", "'('", "')'", "'\\u03BB'", "'fun'", "'.'", "'->'", "'if'", "'then'",
                "'else'", "'let'", "'='", "'native'", "','", "':'"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[] {
                null, null, null, null, null, null, null, null, null, null, null, null,
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

    @SuppressWarnings("CheckReturnValue")
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
                setState(22);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 261396992L) != 0)) {
                    {
                        {
                            setState(16);
                            _errHandler.sync(this);
                            switch (getInterpreter().adaptivePredict(_input, 0, _ctx)) {
                                case 1: {
                                    setState(14);
                                    let();
                                }
                                break;
                                case 2: {
                                    setState(15);
                                    expr();
                                }
                                break;
                            }
                            setState(18);
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
                    setState(24);
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

    @SuppressWarnings("CheckReturnValue")
    public static class ExprContext extends ParserRuleContext {
        public List<SubexprContext> subexpr() {
            return getRuleContexts(SubexprContext.class);
        }

        public SubexprContext subexpr(int i) {
            return getRuleContext(SubexprContext.class, i);
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
        ExprContext _localctx = new ExprContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_expr);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(26);
                _errHandler.sync(this);
                _alt = 1;
                do {
                    switch (_alt) {
                        case 1: {
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
                    _alt = getInterpreter().adaptivePredict(_input, 2, _ctx);
                } while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
                setState(39);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 5, _ctx)) {
                    case 1: {
                        setState(30);
                        match(T__1);
                        setState(33);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == T__2) {
                            {
                                setState(31);
                                match(T__2);
                                setState(32);
                                _la = _input.LA(1);
                                if (!(_la == T__3 || _la == T__4)) {
                                    _errHandler.recoverInline(this);
                                } else {
                                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                    _errHandler.reportMatch(this);
                                    consume();
                                }
                            }
                        }

                        setState(37);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == T__5) {
                            {
                                setState(35);
                                match(T__5);
                                setState(36);
                                match(T__6);
                            }
                        }

                    }
                    break;
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

    @SuppressWarnings("CheckReturnValue")
    public static class SubexprContext extends ParserRuleContext {
        public LetContext let() {
            return getRuleContext(LetContext.class, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public FunContext fun() {
            return getRuleContext(FunContext.class, 0);
        }

        public SelectContext select() {
            return getRuleContext(SelectContext.class, 0);
        }

        public LoadContext load() {
            return getRuleContext(LoadContext.class, 0);
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

        public TerminalNode VARIABLE() {
            return getToken(JlambdaParser.VARIABLE, 0);
        }

        public SubexprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_subexpr;
        }
    }

    public final SubexprContext subexpr() throws RecognitionException {
        SubexprContext _localctx = new SubexprContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_subexpr);
        int _la;
        try {
            setState(58);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__17:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(41);
                    let();
                    setState(42);
                    match(T__7);
                    setState(43);
                    expr();
                }
                break;
                case T__10:
                case T__11:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(45);
                    fun();
                }
                break;
                case T__14:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(46);
                    select();
                }
                break;
                case T__19:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(47);
                    load();
                }
                break;
                case STRING:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(48);
                    match(STRING);
                }
                break;
                case FLOAT:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(49);
                    match(FLOAT);
                }
                break;
                case INT:
                    enterOuterAlt(_localctx, 7);
                {
                    setState(50);
                    match(INT);
                }
                break;
                case BOOL:
                    enterOuterAlt(_localctx, 8);
                {
                    setState(51);
                    match(BOOL);
                }
                break;
                case VARIABLE:
                    enterOuterAlt(_localctx, 9);
                {
                    setState(52);
                    match(VARIABLE);
                }
                break;
                case T__8:
                    enterOuterAlt(_localctx, 10);
                {
                    setState(53);
                    match(T__8);
                    setState(55);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 261396992L) != 0)) {
                        {
                            setState(54);
                            expr();
                        }
                    }

                    setState(57);
                    match(T__9);
                }
                break;
                default:
                    throw new NoViableAltException(this);
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

    @SuppressWarnings("CheckReturnValue")
    public static class FunContext extends ParserRuleContext {
        public TerminalNode VARIABLE() {
            return getToken(JlambdaParser.VARIABLE, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public FunContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_fun;
        }
    }

    public final FunContext fun() throws RecognitionException {
        FunContext _localctx = new FunContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_fun);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(60);
                _la = _input.LA(1);
                if (!(_la == T__10 || _la == T__11)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
                setState(61);
                match(VARIABLE);
                setState(62);
                _la = _input.LA(1);
                if (!(_la == T__12 || _la == T__13)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
                setState(63);
                match(T__8);
                setState(64);
                expr();
                setState(65);
                match(T__9);
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

    @SuppressWarnings("CheckReturnValue")
    public static class SelectContext extends ParserRuleContext {
        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public SelectContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_select;
        }
    }

    public final SelectContext select() throws RecognitionException {
        SelectContext _localctx = new SelectContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_select);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(67);
                match(T__14);
                setState(68);
                expr();
                setState(69);
                match(T__15);
                setState(70);
                expr();
                setState(71);
                match(T__16);
                setState(72);
                expr();
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

    @SuppressWarnings("CheckReturnValue")
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
        enterRule(_localctx, 10, RULE_let);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(74);
                match(T__17);
                setState(75);
                match(VARIABLE);
                setState(76);
                match(T__18);
                setState(77);
                expr();
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

    @SuppressWarnings("CheckReturnValue")
    public static class LoadContext extends ParserRuleContext {
        public List<TerminalNode> VARIABLE() {
            return getTokens(JlambdaParser.VARIABLE);
        }

        public TerminalNode VARIABLE(int i) {
            return getToken(JlambdaParser.VARIABLE, i);
        }

        public LoadContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_load;
        }
    }

    public final LoadContext load() throws RecognitionException {
        LoadContext _localctx = new LoadContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_load);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(79);
                match(T__19);
                setState(80);
                match(VARIABLE);
                setState(85);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__12) {
                    {
                        {
                            setState(81);
                            match(T__12);
                            setState(82);
                            match(VARIABLE);
                        }
                    }
                    setState(87);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(88);
                match(T__8);
                setState(90);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == VARIABLE) {
                    {
                        setState(89);
                        match(VARIABLE);
                    }
                }

                setState(96);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__20) {
                    {
                        {
                            setState(92);
                            match(T__20);
                            setState(93);
                            match(VARIABLE);
                        }
                    }
                    setState(98);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(99);
                match(T__9);
                setState(100);
                match(T__21);
                setState(101);
                match(VARIABLE);
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

    public static final String _serializedATN =
            "\u0004\u0001\u001dh\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002" +
                    "\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002" +
                    "\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0001\u0000\u0001\u0000\u0003" +
                    "\u0000\u0011\b\u0000\u0001\u0000\u0001\u0000\u0005\u0000\u0015\b\u0000" +
                    "\n\u0000\f\u0000\u0018\t\u0000\u0001\u0001\u0004\u0001\u001b\b\u0001\u000b" +
                    "\u0001\f\u0001\u001c\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001\"" +
                    "\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001&\b\u0001\u0003\u0001(\b\u0001" +
                    "\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002" +
                    "\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002" +
                    "\u0001\u0002\u0001\u0002\u0003\u00028\b\u0002\u0001\u0002\u0003\u0002" +
                    ";\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003" +
                    "\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004" +
                    "\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005" +
                    "\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006" +
                    "\u0005\u0006T\b\u0006\n\u0006\f\u0006W\t\u0006\u0001\u0006\u0001\u0006" +
                    "\u0003\u0006[\b\u0006\u0001\u0006\u0001\u0006\u0005\u0006_\b\u0006\n\u0006" +
                    "\f\u0006b\t\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001" +
                    "\u0006\u0000\u0000\u0007\u0000\u0002\u0004\u0006\b\n\f\u0000\u0004\u0001" +
                    "\u0001\u0001\u0001\u0001\u0000\u0004\u0005\u0001\u0000\u000b\f\u0001\u0000" +
                    "\r\u000es\u0000\u0016\u0001\u0000\u0000\u0000\u0002\u001a\u0001\u0000" +
                    "\u0000\u0000\u0004:\u0001\u0000\u0000\u0000\u0006<\u0001\u0000\u0000\u0000" +
                    "\bC\u0001\u0000\u0000\u0000\nJ\u0001\u0000\u0000\u0000\fO\u0001\u0000" +
                    "\u0000\u0000\u000e\u0011\u0003\n\u0005\u0000\u000f\u0011\u0003\u0002\u0001" +
                    "\u0000\u0010\u000e\u0001\u0000\u0000\u0000\u0010\u000f\u0001\u0000\u0000" +
                    "\u0000\u0011\u0012\u0001\u0000\u0000\u0000\u0012\u0013\u0007\u0000\u0000" +
                    "\u0000\u0013\u0015\u0001\u0000\u0000\u0000\u0014\u0010\u0001\u0000\u0000" +
                    "\u0000\u0015\u0018\u0001\u0000\u0000\u0000\u0016\u0014\u0001\u0000\u0000" +
                    "\u0000\u0016\u0017\u0001\u0000\u0000\u0000\u0017\u0001\u0001\u0000\u0000" +
                    "\u0000\u0018\u0016\u0001\u0000\u0000\u0000\u0019\u001b\u0003\u0004\u0002" +
                    "\u0000\u001a\u0019\u0001\u0000\u0000\u0000\u001b\u001c\u0001\u0000\u0000" +
                    "\u0000\u001c\u001a\u0001\u0000\u0000\u0000\u001c\u001d\u0001\u0000\u0000" +
                    "\u0000\u001d\'\u0001\u0000\u0000\u0000\u001e!\u0005\u0002\u0000\u0000" +
                    "\u001f \u0005\u0003\u0000\u0000 \"\u0007\u0001\u0000\u0000!\u001f\u0001" +
                    "\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\"%\u0001\u0000\u0000\u0000" +
                    "#$\u0005\u0006\u0000\u0000$&\u0005\u0007\u0000\u0000%#\u0001\u0000\u0000" +
                    "\u0000%&\u0001\u0000\u0000\u0000&(\u0001\u0000\u0000\u0000\'\u001e\u0001" +
                    "\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000(\u0003\u0001\u0000\u0000" +
                    "\u0000)*\u0003\n\u0005\u0000*+\u0005\b\u0000\u0000+,\u0003\u0002\u0001" +
                    "\u0000,;\u0001\u0000\u0000\u0000-;\u0003\u0006\u0003\u0000.;\u0003\b\u0004" +
                    "\u0000/;\u0003\f\u0006\u00000;\u0005\u0017\u0000\u00001;\u0005\u0018\u0000" +
                    "\u00002;\u0005\u0019\u0000\u00003;\u0005\u001a\u0000\u00004;\u0005\u001b" +
                    "\u0000\u000057\u0005\t\u0000\u000068\u0003\u0002\u0001\u000076\u0001\u0000" +
                    "\u0000\u000078\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u00009;\u0005" +
                    "\n\u0000\u0000:)\u0001\u0000\u0000\u0000:-\u0001\u0000\u0000\u0000:.\u0001" +
                    "\u0000\u0000\u0000:/\u0001\u0000\u0000\u0000:0\u0001\u0000\u0000\u0000" +
                    ":1\u0001\u0000\u0000\u0000:2\u0001\u0000\u0000\u0000:3\u0001\u0000\u0000" +
                    "\u0000:4\u0001\u0000\u0000\u0000:5\u0001\u0000\u0000\u0000;\u0005\u0001" +
                    "\u0000\u0000\u0000<=\u0007\u0002\u0000\u0000=>\u0005\u001b\u0000\u0000" +
                    ">?\u0007\u0003\u0000\u0000?@\u0005\t\u0000\u0000@A\u0003\u0002\u0001\u0000" +
                    "AB\u0005\n\u0000\u0000B\u0007\u0001\u0000\u0000\u0000CD\u0005\u000f\u0000" +
                    "\u0000DE\u0003\u0002\u0001\u0000EF\u0005\u0010\u0000\u0000FG\u0003\u0002" +
                    "\u0001\u0000GH\u0005\u0011\u0000\u0000HI\u0003\u0002\u0001\u0000I\t\u0001" +
                    "\u0000\u0000\u0000JK\u0005\u0012\u0000\u0000KL\u0005\u001b\u0000\u0000" +
                    "LM\u0005\u0013\u0000\u0000MN\u0003\u0002\u0001\u0000N\u000b\u0001\u0000" +
                    "\u0000\u0000OP\u0005\u0014\u0000\u0000PU\u0005\u001b\u0000\u0000QR\u0005" +
                    "\r\u0000\u0000RT\u0005\u001b\u0000\u0000SQ\u0001\u0000\u0000\u0000TW\u0001" +
                    "\u0000\u0000\u0000US\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000" +
                    "VX\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000XZ\u0005\t\u0000\u0000" +
                    "Y[\u0005\u001b\u0000\u0000ZY\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000" +
                    "\u0000[`\u0001\u0000\u0000\u0000\\]\u0005\u0015\u0000\u0000]_\u0005\u001b" +
                    "\u0000\u0000^\\\u0001\u0000\u0000\u0000_b\u0001\u0000\u0000\u0000`^\u0001" +
                    "\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000ac\u0001\u0000\u0000\u0000" +
                    "b`\u0001\u0000\u0000\u0000cd\u0005\n\u0000\u0000de\u0005\u0016\u0000\u0000" +
                    "ef\u0005\u001b\u0000\u0000f\r\u0001\u0000\u0000\u0000\u000b\u0010\u0016" +
                    "\u001c!%\'7:UZ`";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}