package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.questionnairemanagement.domain.AlphanumericCodeQuestionnaire;
import eapli.base.questionnairemanagement.domain.Answer;
import eapli.base.questionnairemanagement.domain.AnswerID;
import eapli.base.questionnairemanagement.domain.Questionnaire;
import eapli.base.questionnairemanagement.repositories.AnswerRepository;
import eapli.base.questionnairemanagement.repositories.QuestionnaireRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.Query;
import java.util.List;

public class JpaAnswerRepository extends JpaAutoTxRepository<Answer, AnswerID, AnswerID> implements AnswerRepository {
    public JpaAnswerRepository(TransactionalContext autoTx) {
        super(autoTx, "answerID");
    }

    public JpaAnswerRepository(String PUName) {
        super(PUName, Application.settings().getExtendedPersistenceProperties(), "answerID");
    }

//    @Override
//    public List<Answer> getUniverse(String opt) {
//        Query q = entityManager().createQuery("SELECT q.answers FROM Questionnaire q WHERE q.alphanumericCode = :opt", Answer.class);
//        q.setParameter("opt", opt);
//
//        return q.getResultList();
//    }
}
