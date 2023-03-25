// Generated from /Users/tiagoandre/Downloads/lei21_22_s4_2dk_03/base.core/src/main/java/eapli/base/questionnairemanagement/Answer.g4 by ANTLR 4.10.1
package eapli.base.questionnairemanagement.domain.antlr4Answer;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AnswerParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, INT=2, END=3, SPACE=4, COMMA=5, SPECIAL_CHAR=6, NEWLINE=7, STRING=8, 
		SIGNAL=9, QID=10, Q_ID=11, STITLE=12, MANDATORY=13, OPTIONAL=14, CONDITION=15, 
		PHRASE=16, WORD=17, WS=18;
	public static final int
		RULE_init = 0, RULE_answers = 1, RULE_answer = 2, RULE_q_text = 3, RULE_c_answer = 4, 
		RULE_obligatoriness = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"init", "answers", "answer", "q_text", "c_answer", "obligatoriness"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'?'", null, null, null, null, null, null, null, null, null, null, 
			null, "'Obligatoriness: Mandatory.'", "'Obligatoriness: Optional.'", 
			"'Obligatoriness: Condition.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "INT", "END", "SPACE", "COMMA", "SPECIAL_CHAR", "NEWLINE", 
			"STRING", "SIGNAL", "QID", "Q_ID", "STITLE", "MANDATORY", "OPTIONAL", 
			"CONDITION", "PHRASE", "WORD", "WS"
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
	public String getGrammarFileName() { return "Answer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AnswerParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class InitContext extends ParserRuleContext {
		public AnswersContext answers() {
			return getRuleContext(AnswersContext.class,0);
		}
		public InitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerListener ) ((AnswerListener)listener).enterInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerListener ) ((AnswerListener)listener).exitInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVisitor ) return ((AnswerVisitor<? extends T>)visitor).visitInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitContext init() throws RecognitionException {
		InitContext _localctx = new InitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_init);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12);
			answers();
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

	public static class AnswersContext extends ParserRuleContext {
		public List<AnswerContext> answer() {
			return getRuleContexts(AnswerContext.class);
		}
		public AnswerContext answer(int i) {
			return getRuleContext(AnswerContext.class,i);
		}
		public AnswersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerListener ) ((AnswerListener)listener).enterAnswers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerListener ) ((AnswerListener)listener).exitAnswers(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVisitor ) return ((AnswerVisitor<? extends T>)visitor).visitAnswers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswersContext answers() throws RecognitionException {
		AnswersContext _localctx = new AnswersContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_answers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(14);
				answer();
				}
				}
				setState(17); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Q_ID );
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

	public static class AnswerContext extends ParserRuleContext {
		public TerminalNode Q_ID() { return getToken(AnswerParser.Q_ID, 0); }
		public Q_textContext q_text() {
			return getRuleContext(Q_textContext.class,0);
		}
		public ObligatorinessContext obligatoriness() {
			return getRuleContext(ObligatorinessContext.class,0);
		}
		public C_answerContext c_answer() {
			return getRuleContext(C_answerContext.class,0);
		}
		public AnswerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerListener ) ((AnswerListener)listener).enterAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerListener ) ((AnswerListener)listener).exitAnswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVisitor ) return ((AnswerVisitor<? extends T>)visitor).visitAnswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswerContext answer() throws RecognitionException {
		AnswerContext _localctx = new AnswerContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_answer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			match(Q_ID);
			setState(20);
			q_text();
			setState(21);
			obligatoriness();
			setState(22);
			c_answer();
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

	public static class Q_textContext extends ParserRuleContext {
		public TerminalNode PHRASE() { return getToken(AnswerParser.PHRASE, 0); }
		public Q_textContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_q_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerListener ) ((AnswerListener)listener).enterQ_text(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerListener ) ((AnswerListener)listener).exitQ_text(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVisitor ) return ((AnswerVisitor<? extends T>)visitor).visitQ_text(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Q_textContext q_text() throws RecognitionException {
		Q_textContext _localctx = new Q_textContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_q_text);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			match(PHRASE);
			setState(25);
			match(T__0);
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

	public static class C_answerContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(AnswerParser.INT, 0); }
		public TerminalNode PHRASE() { return getToken(AnswerParser.PHRASE, 0); }
		public TerminalNode END() { return getToken(AnswerParser.END, 0); }
		public C_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_c_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerListener ) ((AnswerListener)listener).enterC_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerListener ) ((AnswerListener)listener).exitC_answer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVisitor ) return ((AnswerVisitor<? extends T>)visitor).visitC_answer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final C_answerContext c_answer() throws RecognitionException {
		C_answerContext _localctx = new C_answerContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_c_answer);
		try {
			setState(31);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(27);
				match(INT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(28);
				match(PHRASE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(29);
				match(PHRASE);
				setState(30);
				match(END);
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

	public static class ObligatorinessContext extends ParserRuleContext {
		public TerminalNode MANDATORY() { return getToken(AnswerParser.MANDATORY, 0); }
		public TerminalNode OPTIONAL() { return getToken(AnswerParser.OPTIONAL, 0); }
		public TerminalNode CONDITION() { return getToken(AnswerParser.CONDITION, 0); }
		public ObligatorinessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_obligatoriness; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerListener ) ((AnswerListener)listener).enterObligatoriness(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerListener ) ((AnswerListener)listener).exitObligatoriness(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVisitor ) return ((AnswerVisitor<? extends T>)visitor).visitObligatoriness(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObligatorinessContext obligatoriness() throws RecognitionException {
		ObligatorinessContext _localctx = new ObligatorinessContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_obligatoriness);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MANDATORY) | (1L << OPTIONAL) | (1L << CONDITION))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static final String _serializedATN =
		"\u0004\u0001\u0012$\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0001\u0000\u0001\u0000\u0001\u0001\u0004\u0001\u0010"+
		"\b\u0001\u000b\u0001\f\u0001\u0011\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004 \b\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0000\u0000\u0006\u0000\u0002\u0004\u0006\b\n"+
		"\u0000\u0001\u0001\u0000\r\u000f \u0000\f\u0001\u0000\u0000\u0000\u0002"+
		"\u000f\u0001\u0000\u0000\u0000\u0004\u0013\u0001\u0000\u0000\u0000\u0006"+
		"\u0018\u0001\u0000\u0000\u0000\b\u001f\u0001\u0000\u0000\u0000\n!\u0001"+
		"\u0000\u0000\u0000\f\r\u0003\u0002\u0001\u0000\r\u0001\u0001\u0000\u0000"+
		"\u0000\u000e\u0010\u0003\u0004\u0002\u0000\u000f\u000e\u0001\u0000\u0000"+
		"\u0000\u0010\u0011\u0001\u0000\u0000\u0000\u0011\u000f\u0001\u0000\u0000"+
		"\u0000\u0011\u0012\u0001\u0000\u0000\u0000\u0012\u0003\u0001\u0000\u0000"+
		"\u0000\u0013\u0014\u0005\u000b\u0000\u0000\u0014\u0015\u0003\u0006\u0003"+
		"\u0000\u0015\u0016\u0003\n\u0005\u0000\u0016\u0017\u0003\b\u0004\u0000"+
		"\u0017\u0005\u0001\u0000\u0000\u0000\u0018\u0019\u0005\u0010\u0000\u0000"+
		"\u0019\u001a\u0005\u0001\u0000\u0000\u001a\u0007\u0001\u0000\u0000\u0000"+
		"\u001b \u0005\u0002\u0000\u0000\u001c \u0005\u0010\u0000\u0000\u001d\u001e"+
		"\u0005\u0010\u0000\u0000\u001e \u0005\u0003\u0000\u0000\u001f\u001b\u0001"+
		"\u0000\u0000\u0000\u001f\u001c\u0001\u0000\u0000\u0000\u001f\u001d\u0001"+
		"\u0000\u0000\u0000 \t\u0001\u0000\u0000\u0000!\"\u0007\u0000\u0000\u0000"+
		"\"\u000b\u0001\u0000\u0000\u0000\u0002\u0011\u001f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}