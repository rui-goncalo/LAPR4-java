package eapli.base.questionnairemanagement.repositories;

import eapli.base.questionnairemanagement.domain.Answer;
import eapli.base.questionnairemanagement.domain.AnswerID;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface AnswerRepository extends DomainRepository<AnswerID, Answer> {
//    List<Answer> getUniverse(String opt);
}
