package eapli.base.persistence.impl.inmemory;

import eapli.base.questionnairemanagement.domain.AlphanumericCodeQuestionnaire;
import eapli.base.questionnairemanagement.domain.Answer;
import eapli.base.questionnairemanagement.domain.AnswerID;
import eapli.base.questionnairemanagement.domain.Questionnaire;
import eapli.base.questionnairemanagement.repositories.AnswerRepository;
import eapli.base.questionnairemanagement.repositories.QuestionnaireRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;

public class InMemoryAnswerRepository extends InMemoryDomainRepository<Answer, AnswerID> implements AnswerRepository {
    static {
        InMemoryInitializer.init();
    }

//    @Override
//    public List<Answer> getUniverse(String opt) {
//        return null;
//    }
}
