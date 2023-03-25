package eapli.base.questionnairemanagement.domain;

import eapli.base.customermanagement.domain.Customer;
import eapli.base.questionnairemanagement.domain.antlr4.QuestionnaireLexer;
import eapli.base.questionnairemanagement.domain.antlr4.QuestionnaireParser;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import javax.persistence.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Entity
public class Questionnaire implements AggregateRoot<AlphanumericCodeQuestionnaire>, Serializable {
    @Id
    @GeneratedValue
    private Integer pk;

    @Embedded
    @GeneratedValue(strategy = GenerationType.AUTO)
    private AlphanumericCodeQuestionnaire alphanumericCode;

    @Embedded
    private Description questionnaireDescription;

    @Embedded
    private PeriodQuestionnaire period;

    @Lob
    @Basic(fetch=FetchType.LAZY)
    private byte[] questionnaire;

    @Embedded
    private RulesQuestionnaire rules;

    @OneToMany
    private List<Customer> customers;

    @OneToMany
    private List<Answer> answers;

    protected Questionnaire() {
    }

    public Questionnaire(AlphanumericCodeQuestionnaire alphanumericCode, Description questionnaireDescription, PeriodQuestionnaire period, byte[] questionnaire) {
        this.alphanumericCode = alphanumericCode;
        this.questionnaireDescription = questionnaireDescription;
        this.period = period;
        this.questionnaire = Arrays.copyOf(questionnaire, questionnaire.length);
    }

    public Questionnaire(AlphanumericCodeQuestionnaire alphanumericCode, Description questionnaireDescription, PeriodQuestionnaire period, byte[] questionnaire, RulesQuestionnaire rules, List<Customer> customers) {
        this.alphanumericCode = alphanumericCode;
        this.questionnaireDescription = questionnaireDescription;
        this.period = period;
        this.questionnaire = questionnaire;
        this.rules = rules;
        this.customers = customers;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Questionnaire)) {
            return false;
        }

        final Questionnaire that = (Questionnaire) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity());
    }

    @Override
    public AlphanumericCodeQuestionnaire identity() {
        return this.alphanumericCode;
    }

    public AlphanumericCodeQuestionnaire getAlphanumericCode() {
        return alphanumericCode;
    }

    public void setAlphanumericCode(AlphanumericCodeQuestionnaire alphanumericCode) {
        this.alphanumericCode = alphanumericCode;
    }

    public Description getQuestionnaireDescription() {
        return questionnaireDescription;
    }

    public void setQuestionnaireDescription(Description questionnaireDescription) {
        this.questionnaireDescription = questionnaireDescription;
    }

    public PeriodQuestionnaire getPeriod() {
        return period;
    }

    public void setPeriod(PeriodQuestionnaire period) {
        this.period = period;
    }

    public byte[] getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(byte[] questionnaire) {
        this.questionnaire = questionnaire;
    }

    public RulesQuestionnaire getRules() {
        return rules;
    }

    public void setRules(RulesQuestionnaire rules) {
        this.rules = rules;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Questionnaire: " +
                "\nAlphanumeric Code = " + alphanumericCode +
                "\nDescription = " + questionnaireDescription +
                "\nPeriod = " + period;
    }

    public String getQuestionnaireBD() throws IOException {
//        FileInputStream fis = new FileInputStream(new File("/Users/tiagoandre/Downloads/lei21_22_s4_2dk_03/base.core/src/main/java/eapli/base/questionnairemanagement/Questionnaire1.txt"));
        CharStream charStream = CharStreams.fromString(new String(questionnaire));
        QuestionnaireLexer lexer = new QuestionnaireLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QuestionnaireParser parser = new QuestionnaireParser(tokens);
        ParseTree tree = parser.start(); // parse
        EvalVisitor eval = new EvalVisitor();
        return eval.visit(tree);
    }
}
