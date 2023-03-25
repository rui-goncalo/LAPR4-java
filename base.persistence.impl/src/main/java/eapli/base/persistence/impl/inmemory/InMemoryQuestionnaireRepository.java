package eapli.base.persistence.impl.inmemory;

import eapli.base.questionnairemanagement.domain.AlphanumericCodeQuestionnaire;
import eapli.base.questionnairemanagement.domain.Questionnaire;
import eapli.base.questionnairemanagement.repositories.QuestionnaireRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;

public class InMemoryQuestionnaireRepository extends InMemoryDomainRepository<Questionnaire, AlphanumericCodeQuestionnaire> implements QuestionnaireRepository {
    static {
        InMemoryInitializer.init();
    }


    @Override
    public List<Questionnaire> findAllQuestionnaires() {
        return findAllQuestionnaires();
    }

    @Override
    public Questionnaire findByAlphanumericCode(AlphanumericCodeQuestionnaire alphanumericCodeQuestionnaire) {
        return findByAlphanumericCode(alphanumericCodeQuestionnaire);
    }
}
