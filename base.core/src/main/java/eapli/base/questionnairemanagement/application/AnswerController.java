package eapli.base.questionnairemanagement.application;

import eapli.base.customermanagement.application.RegisterCustomerController;
import eapli.base.customermanagement.domain.Customer;
import eapli.base.customermanagement.repositories.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.questionnairemanagement.domain.*;
import eapli.base.questionnairemanagement.repositories.QuestionnaireRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.List;

public class AnswerController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final QuestionnaireRepository questionnaireRepository = PersistenceContext.repositories().questionnaires();
    private final AnswerService answerService = new AnswerService();
    private final RegisterCustomerController customerController = new RegisterCustomerController();
    private final CustomerRepository customerRepository = PersistenceContext.repositories().customers();

    public List<Questionnaire> findAllQuestionnaires() {
        return questionnaireRepository.findAllQuestionnaires();
    }

    public Questionnaire findByAlphanumericCode(String alphanumeric) {
        AlphanumericCodeQuestionnaire alphanumericCodeQuestionnaire = AlphanumericCodeQuestionnaire.valueOf(alphanumeric);
        return questionnaireRepository.findByAlphanumericCode(alphanumericCodeQuestionnaire);
    }

    public void listQuestionnaires(List<Questionnaire> questionnaires) {
        answerService.showAllQuestionnaires(questionnaires);
    }

    public void answerWriter(String answer) {
        AnswerWriter.answerFile(answer);
    }

    public String findPathByAlphanumericCode(String alphanumericcode) {
        return answerService.findPathByAlphanumericCode(alphanumericcode);
    }

    public void removeQuestionnaireFromCustomer(Questionnaire questionnaire, List<Customer> customers, Customer customer) {
        questionnaire.getCustomers().removeIf(a -> a.getPk().equals(customer.getPk()));
        for (Customer c : customers) {
            this.customerRepository.save(c);
        }
        this.questionnaireRepository.save(questionnaire);
    }
}
