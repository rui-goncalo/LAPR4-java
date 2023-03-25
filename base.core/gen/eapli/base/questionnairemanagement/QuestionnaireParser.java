// Generated from /Users/tiagoandre/Downloads/lei21_22_s4_2dk_03/base.core/src/main/java/eapli/base/questionnairemanagement/Questionnaire.g4 by ANTLR 4.10.1
package eapli.base.questionnairemanagement;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QuestionnaireParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, QTITLE=12, SID=13, INT=14, END=15, SPACE=16, COMMA=17, 
		SPECIAL_CHAR=18, NEWLINE=19, STRING=20, SIGNAL=21, QID=22, Q_ID=23, STITLE=24, 
		MANDATORY=25, OPTIONAL=26, CONDITION=27, PHRASE=28, WORD=29, WS=30;
	public static final int
		RULE_start = 0, RULE_questionnaire = 1, RULE_welcome_message = 2, RULE_final_message = 3, 
		RULE_section = 4, RULE_sdescription = 5, RULE_question = 6, RULE_q_text = 7, 
		RULE_qinstruction = 8, RULE_qtype = 9, RULE_free_text = 10, RULE_numeric = 11, 
		RULE_single_choice = 12, RULE_multiple_choice = 13, RULE_opts = 14, RULE_opt = 15, 
		RULE_obligatoriness = 16, RULE_extra_info = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "questionnaire", "welcome_message", "final_message", "section", 
			"sdescription", "question", "q_text", "qinstruction", "qtype", "free_text", 
			"numeric", "single_choice", "multiple_choice", "opts", "opt", "obligatoriness", 
			"extra_info"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Welcome message:'", "'Final message: '", "'Section:'", "'Description:'", 
			"'?'", "'Type:'", "'Free-Text'", "'Single-choice'", "'Single-Choice'", 
			"'Multiple-choice'", "'Multiple-Choice'", null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "'Obligatoriness: Mandatory.'", 
			"'Obligatoriness: Optional.'", "'Obligatoriness: Condition.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"QTITLE", "SID", "INT", "END", "SPACE", "COMMA", "SPECIAL_CHAR", "NEWLINE", 
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
	public String getGrammarFileName() { return "Questionnaire.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public QuestionnaireParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public QuestionnaireContext questionnaire() {
			return getRuleContext(QuestionnaireContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionnaireVisitor ) return ((QuestionnaireVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			questionnaire();
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

	public static class QuestionnaireContext extends ParserRuleContext {
		public TerminalNode QID() { return getToken(QuestionnaireParser.QID, 0); }
		public TerminalNode QTITLE() { return getToken(QuestionnaireParser.QTITLE, 0); }
		public Welcome_messageContext welcome_message() {
			return getRuleContext(Welcome_messageContext.class,0);
		}
		public Final_messageContext final_message() {
			return getRuleContext(Final_messageContext.class,0);
		}
		public List<SectionContext> section() {
			return getRuleContexts(SectionContext.class);
		}
		public SectionContext section(int i) {
			return getRuleContext(SectionContext.class,i);
		}
		public QuestionnaireContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionnaire; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterQuestionnaire(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitQuestionnaire(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionnaireVisitor ) return ((QuestionnaireVisitor<? extends T>)visitor).visitQuestionnaire(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionnaireContext questionnaire() throws RecognitionException {
		QuestionnaireContext _localctx = new QuestionnaireContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_questionnaire);
		int _la;
		try {
			setState(57);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				match(QID);
				setState(39);
				match(QTITLE);
				setState(40);
				welcome_message();
				setState(42); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(41);
					section();
					}
					}
					setState(44); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__2 || _la==SID );
				setState(46);
				final_message();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(48);
				match(QID);
				setState(49);
				match(QTITLE);
				setState(51); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(50);
					section();
					}
					}
					setState(53); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__2 || _la==SID );
				setState(55);
				final_message();
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

	public static class Welcome_messageContext extends ParserRuleContext {
		public List<TerminalNode> PHRASE() { return getTokens(QuestionnaireParser.PHRASE); }
		public TerminalNode PHRASE(int i) {
			return getToken(QuestionnaireParser.PHRASE, i);
		}
		public List<TerminalNode> END() { return getTokens(QuestionnaireParser.END); }
		public TerminalNode END(int i) {
			return getToken(QuestionnaireParser.END, i);
		}
		public Welcome_messageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_welcome_message; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterWelcome_message(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitWelcome_message(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionnaireVisitor ) return ((QuestionnaireVisitor<? extends T>)visitor).visitWelcome_message(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Welcome_messageContext welcome_message() throws RecognitionException {
		Welcome_messageContext _localctx = new Welcome_messageContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_welcome_message);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(T__0);
			setState(62); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(60);
				match(PHRASE);
				setState(61);
				match(END);
				}
				}
				setState(64); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==PHRASE );
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

	public static class Final_messageContext extends ParserRuleContext {
		public List<TerminalNode> PHRASE() { return getTokens(QuestionnaireParser.PHRASE); }
		public TerminalNode PHRASE(int i) {
			return getToken(QuestionnaireParser.PHRASE, i);
		}
		public List<TerminalNode> END() { return getTokens(QuestionnaireParser.END); }
		public TerminalNode END(int i) {
			return getToken(QuestionnaireParser.END, i);
		}
		public Final_messageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_final_message; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterFinal_message(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitFinal_message(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionnaireVisitor ) return ((QuestionnaireVisitor<? extends T>)visitor).visitFinal_message(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Final_messageContext final_message() throws RecognitionException {
		Final_messageContext _localctx = new Final_messageContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_final_message);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(T__1);
			setState(69); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(67);
				match(PHRASE);
				setState(68);
				match(END);
				}
				}
				setState(71); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==PHRASE );
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

	public static class SectionContext extends ParserRuleContext {
		public TerminalNode SID() { return getToken(QuestionnaireParser.SID, 0); }
		public TerminalNode STITLE() { return getToken(QuestionnaireParser.STITLE, 0); }
		public SdescriptionContext sdescription() {
			return getRuleContext(SdescriptionContext.class,0);
		}
		public ObligatorinessContext obligatoriness() {
			return getRuleContext(ObligatorinessContext.class,0);
		}
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public SectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionnaireVisitor ) return ((QuestionnaireVisitor<? extends T>)visitor).visitSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SectionContext section() throws RecognitionException {
		SectionContext _localctx = new SectionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_section);
		int _la;
		try {
			setState(91);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				match(T__2);
				setState(74);
				match(SID);
				setState(75);
				match(STITLE);
				setState(76);
				sdescription();
				setState(77);
				obligatoriness();
				setState(79); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(78);
					question();
					}
					}
					setState(81); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==Q_ID );
				}
				break;
			case SID:
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				match(SID);
				setState(84);
				match(STITLE);
				setState(85);
				obligatoriness();
				setState(87); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(86);
					question();
					}
					}
					setState(89); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==Q_ID );
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

	public static class SdescriptionContext extends ParserRuleContext {
		public List<TerminalNode> PHRASE() { return getTokens(QuestionnaireParser.PHRASE); }
		public TerminalNode PHRASE(int i) {
			return getToken(QuestionnaireParser.PHRASE, i);
		}
		public List<TerminalNode> END() { return getTokens(QuestionnaireParser.END); }
		public TerminalNode END(int i) {
			return getToken(QuestionnaireParser.END, i);
		}
		public SdescriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sdescription; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterSdescription(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitSdescription(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionnaireVisitor ) return ((QuestionnaireVisitor<? extends T>)visitor).visitSdescription(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SdescriptionContext sdescription() throws RecognitionException {
		SdescriptionContext _localctx = new SdescriptionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_sdescription);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(93);
				match(T__3);
				setState(96); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(94);
					match(PHRASE);
					setState(95);
					match(END);
					}
					}
					setState(98); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==PHRASE );
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

	public static class QuestionContext extends ParserRuleContext {
		public TerminalNode Q_ID() { return getToken(QuestionnaireParser.Q_ID, 0); }
		public Q_textContext q_text() {
			return getRuleContext(Q_textContext.class,0);
		}
		public QinstructionContext qinstruction() {
			return getRuleContext(QinstructionContext.class,0);
		}
		public ObligatorinessContext obligatoriness() {
			return getRuleContext(ObligatorinessContext.class,0);
		}
		public Extra_infoContext extra_info() {
			return getRuleContext(Extra_infoContext.class,0);
		}
		public QtypeContext qtype() {
			return getRuleContext(QtypeContext.class,0);
		}
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionnaireVisitor ) return ((QuestionnaireVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(Q_ID);
			setState(103);
			q_text();
			setState(104);
			qinstruction();
			setState(105);
			obligatoriness();
			setState(106);
			extra_info();
			setState(107);
			qtype();
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
		public TerminalNode PHRASE() { return getToken(QuestionnaireParser.PHRASE, 0); }
		public Q_textContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_q_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterQ_text(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitQ_text(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionnaireVisitor ) return ((QuestionnaireVisitor<? extends T>)visitor).visitQ_text(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Q_textContext q_text() throws RecognitionException {
		Q_textContext _localctx = new Q_textContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_q_text);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(PHRASE);
			setState(110);
			match(T__4);
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

	public static class QinstructionContext extends ParserRuleContext {
		public List<TerminalNode> PHRASE() { return getTokens(QuestionnaireParser.PHRASE); }
		public TerminalNode PHRASE(int i) {
			return getToken(QuestionnaireParser.PHRASE, i);
		}
		public List<TerminalNode> END() { return getTokens(QuestionnaireParser.END); }
		public TerminalNode END(int i) {
			return getToken(QuestionnaireParser.END, i);
		}
		public QinstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qinstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterQinstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitQinstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionnaireVisitor ) return ((QuestionnaireVisitor<? extends T>)visitor).visitQinstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QinstructionContext qinstruction() throws RecognitionException {
		QinstructionContext _localctx = new QinstructionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_qinstruction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PHRASE) {
				{
				setState(114); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(112);
					match(PHRASE);
					setState(113);
					match(END);
					}
					}
					setState(116); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==PHRASE );
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

	public static class QtypeContext extends ParserRuleContext {
		public Free_textContext free_text() {
			return getRuleContext(Free_textContext.class,0);
		}
		public NumericContext numeric() {
			return getRuleContext(NumericContext.class,0);
		}
		public Single_choiceContext single_choice() {
			return getRuleContext(Single_choiceContext.class,0);
		}
		public Multiple_choiceContext multiple_choice() {
			return getRuleContext(Multiple_choiceContext.class,0);
		}
		public QtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qtype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterQtype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitQtype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionnaireVisitor ) return ((QuestionnaireVisitor<? extends T>)visitor).visitQtype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QtypeContext qtype() throws RecognitionException {
		QtypeContext _localctx = new QtypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_qtype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(T__5);
			setState(125);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				{
				setState(121);
				free_text();
				}
				break;
			case INT:
				{
				setState(122);
				numeric();
				}
				break;
			case T__7:
			case T__8:
				{
				setState(123);
				single_choice();
				}
				break;
			case T__9:
			case T__10:
				{
				setState(124);
				multiple_choice();
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

	public static class Free_textContext extends ParserRuleContext {
		public TerminalNode END() { return getToken(QuestionnaireParser.END, 0); }
		public Free_textContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_free_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterFree_text(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitFree_text(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionnaireVisitor ) return ((QuestionnaireVisitor<? extends T>)visitor).visitFree_text(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Free_textContext free_text() throws RecognitionException {
		Free_textContext _localctx = new Free_textContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_free_text);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(T__6);
			setState(128);
			match(END);
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

	public static class NumericContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(QuestionnaireParser.INT, 0); }
		public TerminalNode END() { return getToken(QuestionnaireParser.END, 0); }
		public NumericContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numeric; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterNumeric(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitNumeric(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionnaireVisitor ) return ((QuestionnaireVisitor<? extends T>)visitor).visitNumeric(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumericContext numeric() throws RecognitionException {
		NumericContext _localctx = new NumericContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_numeric);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(INT);
			setState(131);
			match(END);
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

	public static class Single_choiceContext extends ParserRuleContext {
		public TerminalNode END() { return getToken(QuestionnaireParser.END, 0); }
		public OptsContext opts() {
			return getRuleContext(OptsContext.class,0);
		}
		public Single_choiceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_single_choice; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterSingle_choice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitSingle_choice(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionnaireVisitor ) return ((QuestionnaireVisitor<? extends T>)visitor).visitSingle_choice(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Single_choiceContext single_choice() throws RecognitionException {
		Single_choiceContext _localctx = new Single_choiceContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_single_choice);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			_la = _input.LA(1);
			if ( !(_la==T__7 || _la==T__8) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(134);
			match(END);
			setState(135);
			opts();
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

	public static class Multiple_choiceContext extends ParserRuleContext {
		public TerminalNode END() { return getToken(QuestionnaireParser.END, 0); }
		public OptsContext opts() {
			return getRuleContext(OptsContext.class,0);
		}
		public Multiple_choiceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiple_choice; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterMultiple_choice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitMultiple_choice(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionnaireVisitor ) return ((QuestionnaireVisitor<? extends T>)visitor).visitMultiple_choice(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Multiple_choiceContext multiple_choice() throws RecognitionException {
		Multiple_choiceContext _localctx = new Multiple_choiceContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_multiple_choice);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			_la = _input.LA(1);
			if ( !(_la==T__9 || _la==T__10) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(138);
			match(END);
			setState(139);
			opts();
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

	public static class OptsContext extends ParserRuleContext {
		public OptContext opt() {
			return getRuleContext(OptContext.class,0);
		}
		public OptsContext opts() {
			return getRuleContext(OptsContext.class,0);
		}
		public OptsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opts; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterOpts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitOpts(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionnaireVisitor ) return ((QuestionnaireVisitor<? extends T>)visitor).visitOpts(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptsContext opts() throws RecognitionException {
		OptsContext _localctx = new OptsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_opts);
		try {
			setState(145);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(141);
				opt();
				setState(142);
				opts();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(144);
				opt();
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

	public static class OptContext extends ParserRuleContext {
		public TerminalNode SID() { return getToken(QuestionnaireParser.SID, 0); }
		public TerminalNode PHRASE() { return getToken(QuestionnaireParser.PHRASE, 0); }
		public TerminalNode END() { return getToken(QuestionnaireParser.END, 0); }
		public OptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterOpt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitOpt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionnaireVisitor ) return ((QuestionnaireVisitor<? extends T>)visitor).visitOpt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptContext opt() throws RecognitionException {
		OptContext _localctx = new OptContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_opt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(SID);
			setState(148);
			match(PHRASE);
			setState(149);
			match(END);
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
		public TerminalNode MANDATORY() { return getToken(QuestionnaireParser.MANDATORY, 0); }
		public TerminalNode OPTIONAL() { return getToken(QuestionnaireParser.OPTIONAL, 0); }
		public TerminalNode CONDITION() { return getToken(QuestionnaireParser.CONDITION, 0); }
		public ObligatorinessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_obligatoriness; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterObligatoriness(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitObligatoriness(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionnaireVisitor ) return ((QuestionnaireVisitor<? extends T>)visitor).visitObligatoriness(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObligatorinessContext obligatoriness() throws RecognitionException {
		ObligatorinessContext _localctx = new ObligatorinessContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_obligatoriness);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
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

	public static class Extra_infoContext extends ParserRuleContext {
		public TerminalNode PHRASE() { return getToken(QuestionnaireParser.PHRASE, 0); }
		public TerminalNode END() { return getToken(QuestionnaireParser.END, 0); }
		public Extra_infoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extra_info; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).enterExtra_info(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener ) ((QuestionnaireListener)listener).exitExtra_info(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionnaireVisitor ) return ((QuestionnaireVisitor<? extends T>)visitor).visitExtra_info(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Extra_infoContext extra_info() throws RecognitionException {
		Extra_infoContext _localctx = new Extra_infoContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_extra_info);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PHRASE) {
				{
				setState(153);
				match(PHRASE);
				setState(154);
				match(END);
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

	public static final String _serializedATN =
		"\u0004\u0001\u001e\u009e\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0004\u0001+\b"+
		"\u0001\u000b\u0001\f\u0001,\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0004\u00014\b\u0001\u000b\u0001\f\u00015\u0001\u0001"+
		"\u0001\u0001\u0003\u0001:\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0004\u0002?\b\u0002\u000b\u0002\f\u0002@\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0004\u0003F\b\u0003\u000b\u0003\f\u0003G\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0004\u0004P\b\u0004"+
		"\u000b\u0004\f\u0004Q\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0004\u0004X\b\u0004\u000b\u0004\f\u0004Y\u0003\u0004\\\b\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0004\u0005a\b\u0005\u000b\u0005\f\u0005"+
		"b\u0003\u0005e\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0004\bs\b\b\u000b\b\f\bt\u0003\bw\b\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0003\t~\b\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0003\u000e\u0092\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0003\u0011\u009c\b\u0011"+
		"\u0001\u0011\u0000\u0000\u0012\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"\u0000\u0003\u0001\u0000"+
		"\b\t\u0001\u0000\n\u000b\u0001\u0000\u0019\u001b\u009c\u0000$\u0001\u0000"+
		"\u0000\u0000\u00029\u0001\u0000\u0000\u0000\u0004;\u0001\u0000\u0000\u0000"+
		"\u0006B\u0001\u0000\u0000\u0000\b[\u0001\u0000\u0000\u0000\nd\u0001\u0000"+
		"\u0000\u0000\ff\u0001\u0000\u0000\u0000\u000em\u0001\u0000\u0000\u0000"+
		"\u0010v\u0001\u0000\u0000\u0000\u0012x\u0001\u0000\u0000\u0000\u0014\u007f"+
		"\u0001\u0000\u0000\u0000\u0016\u0082\u0001\u0000\u0000\u0000\u0018\u0085"+
		"\u0001\u0000\u0000\u0000\u001a\u0089\u0001\u0000\u0000\u0000\u001c\u0091"+
		"\u0001\u0000\u0000\u0000\u001e\u0093\u0001\u0000\u0000\u0000 \u0097\u0001"+
		"\u0000\u0000\u0000\"\u009b\u0001\u0000\u0000\u0000$%\u0003\u0002\u0001"+
		"\u0000%\u0001\u0001\u0000\u0000\u0000&\'\u0005\u0016\u0000\u0000\'(\u0005"+
		"\f\u0000\u0000(*\u0003\u0004\u0002\u0000)+\u0003\b\u0004\u0000*)\u0001"+
		"\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,*\u0001\u0000\u0000\u0000"+
		",-\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000./\u0003\u0006\u0003"+
		"\u0000/:\u0001\u0000\u0000\u000001\u0005\u0016\u0000\u000013\u0005\f\u0000"+
		"\u000024\u0003\b\u0004\u000032\u0001\u0000\u0000\u000045\u0001\u0000\u0000"+
		"\u000053\u0001\u0000\u0000\u000056\u0001\u0000\u0000\u000067\u0001\u0000"+
		"\u0000\u000078\u0003\u0006\u0003\u00008:\u0001\u0000\u0000\u00009&\u0001"+
		"\u0000\u0000\u000090\u0001\u0000\u0000\u0000:\u0003\u0001\u0000\u0000"+
		"\u0000;>\u0005\u0001\u0000\u0000<=\u0005\u001c\u0000\u0000=?\u0005\u000f"+
		"\u0000\u0000><\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000@>\u0001"+
		"\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000A\u0005\u0001\u0000\u0000"+
		"\u0000BE\u0005\u0002\u0000\u0000CD\u0005\u001c\u0000\u0000DF\u0005\u000f"+
		"\u0000\u0000EC\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000GE\u0001"+
		"\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000H\u0007\u0001\u0000\u0000"+
		"\u0000IJ\u0005\u0003\u0000\u0000JK\u0005\r\u0000\u0000KL\u0005\u0018\u0000"+
		"\u0000LM\u0003\n\u0005\u0000MO\u0003 \u0010\u0000NP\u0003\f\u0006\u0000"+
		"ON\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000"+
		"\u0000QR\u0001\u0000\u0000\u0000R\\\u0001\u0000\u0000\u0000ST\u0005\r"+
		"\u0000\u0000TU\u0005\u0018\u0000\u0000UW\u0003 \u0010\u0000VX\u0003\f"+
		"\u0006\u0000WV\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000YW\u0001"+
		"\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z\\\u0001\u0000\u0000\u0000"+
		"[I\u0001\u0000\u0000\u0000[S\u0001\u0000\u0000\u0000\\\t\u0001\u0000\u0000"+
		"\u0000]`\u0005\u0004\u0000\u0000^_\u0005\u001c\u0000\u0000_a\u0005\u000f"+
		"\u0000\u0000`^\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000b`\u0001"+
		"\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000ce\u0001\u0000\u0000\u0000"+
		"d]\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000e\u000b\u0001\u0000"+
		"\u0000\u0000fg\u0005\u0017\u0000\u0000gh\u0003\u000e\u0007\u0000hi\u0003"+
		"\u0010\b\u0000ij\u0003 \u0010\u0000jk\u0003\"\u0011\u0000kl\u0003\u0012"+
		"\t\u0000l\r\u0001\u0000\u0000\u0000mn\u0005\u001c\u0000\u0000no\u0005"+
		"\u0005\u0000\u0000o\u000f\u0001\u0000\u0000\u0000pq\u0005\u001c\u0000"+
		"\u0000qs\u0005\u000f\u0000\u0000rp\u0001\u0000\u0000\u0000st\u0001\u0000"+
		"\u0000\u0000tr\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000uw\u0001"+
		"\u0000\u0000\u0000vr\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000"+
		"w\u0011\u0001\u0000\u0000\u0000x}\u0005\u0006\u0000\u0000y~\u0003\u0014"+
		"\n\u0000z~\u0003\u0016\u000b\u0000{~\u0003\u0018\f\u0000|~\u0003\u001a"+
		"\r\u0000}y\u0001\u0000\u0000\u0000}z\u0001\u0000\u0000\u0000}{\u0001\u0000"+
		"\u0000\u0000}|\u0001\u0000\u0000\u0000~\u0013\u0001\u0000\u0000\u0000"+
		"\u007f\u0080\u0005\u0007\u0000\u0000\u0080\u0081\u0005\u000f\u0000\u0000"+
		"\u0081\u0015\u0001\u0000\u0000\u0000\u0082\u0083\u0005\u000e\u0000\u0000"+
		"\u0083\u0084\u0005\u000f\u0000\u0000\u0084\u0017\u0001\u0000\u0000\u0000"+
		"\u0085\u0086\u0007\u0000\u0000\u0000\u0086\u0087\u0005\u000f\u0000\u0000"+
		"\u0087\u0088\u0003\u001c\u000e\u0000\u0088\u0019\u0001\u0000\u0000\u0000"+
		"\u0089\u008a\u0007\u0001\u0000\u0000\u008a\u008b\u0005\u000f\u0000\u0000"+
		"\u008b\u008c\u0003\u001c\u000e\u0000\u008c\u001b\u0001\u0000\u0000\u0000"+
		"\u008d\u008e\u0003\u001e\u000f\u0000\u008e\u008f\u0003\u001c\u000e\u0000"+
		"\u008f\u0092\u0001\u0000\u0000\u0000\u0090\u0092\u0003\u001e\u000f\u0000"+
		"\u0091\u008d\u0001\u0000\u0000\u0000\u0091\u0090\u0001\u0000\u0000\u0000"+
		"\u0092\u001d\u0001\u0000\u0000\u0000\u0093\u0094\u0005\r\u0000\u0000\u0094"+
		"\u0095\u0005\u001c\u0000\u0000\u0095\u0096\u0005\u000f\u0000\u0000\u0096"+
		"\u001f\u0001\u0000\u0000\u0000\u0097\u0098\u0007\u0002\u0000\u0000\u0098"+
		"!\u0001\u0000\u0000\u0000\u0099\u009a\u0005\u001c\u0000\u0000\u009a\u009c"+
		"\u0005\u000f\u0000\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009b\u009c"+
		"\u0001\u0000\u0000\u0000\u009c#\u0001\u0000\u0000\u0000\u000f,59@GQY["+
		"bdtv}\u0091\u009b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}