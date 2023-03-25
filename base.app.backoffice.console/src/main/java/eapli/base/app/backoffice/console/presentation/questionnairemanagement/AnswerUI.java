package eapli.base.app.backoffice.console.presentation.questionnairemanagement;

import eapli.base.customermanagement.application.RegisterCustomerController;
import eapli.base.customermanagement.domain.Customer;
import eapli.base.questionnairemanagement.application.AnswerController;
import eapli.base.questionnairemanagement.application.QuestionnaireController;
import eapli.base.questionnairemanagement.domain.Answer;
import eapli.base.questionnairemanagement.domain.AnswerID;
import eapli.base.questionnairemanagement.domain.EvalVisitor;
import eapli.base.questionnairemanagement.domain.Questionnaire;
import eapli.base.questionnairemanagement.domain.antlr4.QuestionnaireLexer;
import eapli.base.questionnairemanagement.domain.antlr4.QuestionnaireParser;
import eapli.base.questionnairemanagement.dto.QuestionnaireDTO;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.*;
import java.util.*;

public class AnswerUI extends AbstractUI {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final AnswerController answerController = new AnswerController();
    private final QuestionnaireController questionnaireController = new QuestionnaireController();
    private final RegisterCustomerController customerController = new RegisterCustomerController();


    @Override
    protected boolean doShow() {
        List<Questionnaire> questionnaires = answerController.findAllQuestionnaires();
//        answerController.listQuestionnaires(questionnaires);

        String email = authz.session().get().authenticatedUser().username().toString();
        List<Customer> customers = customerController.findAllCustomers();
        Customer customer = null;

        for (Customer c : customers) {
            if (c.getEmail().toString().equals(email.toString())) {
                customer = c;
            }
        }

        Customer customer1 = customerController.findByPK(customer.getPk());

        List<QuestionnaireDTO> customerQuestionnaires = new ArrayList<>();
        boolean hasQuestionnaires = false;

        for (Questionnaire q : questionnaires) {
            for (Customer cust : q.getCustomers()) {
                if (cust.getPk().equals(customer1.getPk())) {
                    customerQuestionnaires.add(questionnaireController.toDTO(q));
                }
            }
        }

        if (customerQuestionnaires.isEmpty()) {
            System.out.println("You do not have any questionnaire to answer.\n");
        } else {
            hasQuestionnaires = true;
        }

        if (hasQuestionnaires == true) {
            for (QuestionnaireDTO qdto : customerQuestionnaires) {
                System.out.println(qdto.toString() + "\n");
            }

            String opt = Console.readNonEmptyLine("Choose the alphanumeric code: ", "Alphanumeric Code required.");
            Questionnaire questionnaire = answerController.findByAlphanumericCode(opt);
            System.out.println("\nThe chosen questionnaire was: ");
            System.out.println(questionnaire.toString());

            String path = answerController.findPathByAlphanumericCode(opt);

            try {
                FileInputStream fis = new FileInputStream(new File(path));
                QuestionnaireLexer lexer = new QuestionnaireLexer(new ANTLRInputStream(fis));
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                QuestionnaireParser parser = new QuestionnaireParser(tokens);
                ParseTree tree = parser.start(); // parse
                EvalVisitor eval = new EvalVisitor();
                eval.visit(tree);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            answerController.removeQuestionnaireFromCustomer(questionnaire, questionnaire.getCustomers(), customer1);
        }

        return true;
    }

    @Override
    public String headline() {
        return "answer questionnaire";
    }
}
