package eapli.base.questionnairemanagement.domain;

import eapli.base.questionnairemanagement.domain.antlr4.QuestionnaireLexer;
import eapli.base.questionnairemanagement.domain.antlr4.QuestionnaireParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Grammar {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(new File("/Users/tiagoandre/Downloads/lei21_22_s4_2dk_03/base.core/src/main/java/eapli/base/questionnairemanagement/Questionnaire2.txt"));
        QuestionnaireLexer lexer = new QuestionnaireLexer(new ANTLRInputStream(fis));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QuestionnaireParser parser = new QuestionnaireParser(tokens);
        ParseTree tree = parser.start(); // parse
        EvalVisitor eval = new EvalVisitor();
        eval.visit(tree);
    }
}
