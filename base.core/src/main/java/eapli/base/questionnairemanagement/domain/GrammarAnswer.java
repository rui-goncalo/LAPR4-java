package eapli.base.questionnairemanagement.domain;

import eapli.base.questionnairemanagement.domain.antlr4Answer.AnswerLexer;
import eapli.base.questionnairemanagement.domain.antlr4Answer.AnswerParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class GrammarAnswer {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(new File("/Users/tiagoandre/Downloads/lei21_22_s4_2dk_03/base.core/src/main/java/eapli/base/questionnairemanagement/Answer.txt"));
        AnswerLexer lexer = new AnswerLexer(new ANTLRInputStream(fis));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        AnswerParser parser = new AnswerParser(tokens);
        ParseTree tree = parser.init(); // parse
        EvalVisitorAnswer eval = new EvalVisitorAnswer();
        eval.visit(tree);
    }
}
