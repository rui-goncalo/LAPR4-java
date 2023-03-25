package eapli.base.questionnairemanagement.application;

import eapli.base.customermanagement.domain.Customer;
import eapli.base.questionnairemanagement.domain.Questionnaire;
import eapli.base.questionnairemanagement.domain.RulesQuestionnaire;
import eapli.base.questionnairemanagement.domain.AlphanumericCodeQuestionnaire;
import eapli.base.questionnairemanagement.domain.PeriodQuestionnaire;
import eapli.base.questionnairemanagement.domain.antlr4.QuestionnaireLexer;
import eapli.base.questionnairemanagement.domain.antlr4.QuestionnaireParser;
import eapli.base.questionnairemanagement.dto.QuestionnaireDTO;
import eapli.base.questionnairemanagement.repositories.QuestionnaireRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.general.domain.model.Description;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import java.io.IOException;
import java.util.BitSet;
import java.util.List;

public class QuestionnaireController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final QuestionnaireRepository questionnaireRepository = PersistenceContext.repositories().questionnaires();
    private final QuestionnaireService questionnaireService = new QuestionnaireService();
    public static boolean isValid = true;

    public Questionnaire saveQuestionnaire(final AlphanumericCodeQuestionnaire alphanumericCode, final Description description, final PeriodQuestionnaire period, final byte[] questionnaire, final RulesQuestionnaire rulesQuestionnaire, final List<Customer> customers) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.SALES_MANAGER);

        final var questionnaire_final = new Questionnaire(alphanumericCode, description, period, questionnaire, rulesQuestionnaire, customers);

        System.out.printf("The questionnaire was saved.");

        return questionnaireRepository.save(questionnaire_final);
    }

    public boolean questionnaireValidation(String path) throws IOException {
        ParserRuleContext tree = null;

        try {
            CharStream charStream = CharStreams.fromFileName(path);
            QuestionnaireLexer lexer = new QuestionnaireLexer(charStream);
            lexer.removeErrorListeners();
            lexer.addErrorListener(new ANTLRErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer, Object o, int i, int i1, String s, RecognitionException e) throws ParseCancellationException {
                    System.out.println("line " + i + ":" + i1 + " " + s);
                    isValid = false;
                }

                @Override
                public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean b, BitSet bitSet, ATNConfigSet atnConfigSet) {
                    isValid = false;
                    return;
                }

                @Override
                public void reportAttemptingFullContext(Parser parser, DFA dfa, int i, int i1, BitSet bitSet, ATNConfigSet atnConfigSet) {
                    isValid = false;
                    return;
                }

                @Override
                public void reportContextSensitivity(Parser parser, DFA dfa, int i, int i1, int i2, ATNConfigSet atnConfigSet) {
                    isValid = false;
                    return;
                }
            });
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            QuestionnaireParser parser = new QuestionnaireParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(new ANTLRErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer, Object o, int i, int i1, String s, RecognitionException e) throws ParseCancellationException {
                    isValid = false;
                    System.out.println("line " + i + ":" + i1 + " " + s);
                }

                @Override
                public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean b, BitSet bitSet, ATNConfigSet atnConfigSet) {
                    isValid = false;
                    return;
                }

                @Override
                public void reportAttemptingFullContext(Parser parser, DFA dfa, int i, int i1, BitSet bitSet, ATNConfigSet atnConfigSet) {
                    isValid = false;
                    return;
                }

                @Override
                public void reportContextSensitivity(Parser parser, DFA dfa, int i, int i1, int i2, ATNConfigSet atnConfigSet) {
                    isValid = false;
                    return;
                }
            });

            tree = parser.start();
        } catch (ParseCancellationException e) {
            System.out.println("Questionnaire is not valid:\n" + e.getMessage());
        }

        return isValid;
    }

    public QuestionnaireDTO toDTO (Questionnaire questionnaire) {
        return questionnaireService.toDTO(questionnaire);
    }

}
