package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.questionnairemanagement.domain.AlphanumericCodeQuestionnaire;
import eapli.base.questionnairemanagement.domain.Questionnaire;
import eapli.base.questionnairemanagement.repositories.QuestionnaireRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class JpaQuestionnaireRepository extends JpaAutoTxRepository<Questionnaire, AlphanumericCodeQuestionnaire, AlphanumericCodeQuestionnaire> implements QuestionnaireRepository {
    public JpaQuestionnaireRepository(TransactionalContext autoTx) {
        super(autoTx, "alphanumericCode");
    }

    public JpaQuestionnaireRepository(String PUName) {
        super(PUName, Application.settings().getExtendedPersistenceProperties(), "alphanumericCode");
    }


    @Override
    public List<Questionnaire> findAllQuestionnaires() {
        List<Questionnaire> questionnaires = new ArrayList<>();
        TypedQuery<Questionnaire> query = super.createQuery("SELECT DISTINCT q FROM Questionnaire q", Questionnaire.class);
        for (Questionnaire q: query.getResultList()) {
            questionnaires.add(q);
        }
        return questionnaires;
    }

    @Override
    public Questionnaire findByAlphanumericCode(AlphanumericCodeQuestionnaire alphanumericCode) {
        TypedQuery<Questionnaire> query = entityManager().createQuery("SELECT q FROM Questionnaire q WHERE q.alphanumericCode = :alphanumericCode", Questionnaire.class);
        query.setParameter("alphanumericCode", alphanumericCode);
        return query.getSingleResult();
    }
}
