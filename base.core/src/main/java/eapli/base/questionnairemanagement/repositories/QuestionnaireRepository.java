package eapli.base.questionnairemanagement.repositories;

import eapli.base.questionnairemanagement.domain.Questionnaire;
import eapli.base.questionnairemanagement.domain.AlphanumericCodeQuestionnaire;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface QuestionnaireRepository extends DomainRepository<AlphanumericCodeQuestionnaire, Questionnaire> {
    public List<Questionnaire> findAllQuestionnaires();

    Questionnaire findByAlphanumericCode(AlphanumericCodeQuestionnaire alphanumericCodeQuestionnaire);
}
