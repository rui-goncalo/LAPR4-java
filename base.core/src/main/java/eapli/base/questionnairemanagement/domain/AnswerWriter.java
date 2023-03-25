package eapli.base.questionnairemanagement.domain;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AnswerWriter {
    public static boolean answerFile(String answer) {
        try {
            File myObj = new File("Answer.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            String location = "/Users/tiagoandre/Downloads/lei21_22_s4_2dk_03/base.core/src/main/java/eapli/base/questionnairemanagement/Answer.txt";
            FileWriter fileWriter = new FileWriter(location, true);

            try {
                fileWriter.write(answer + "\n");
            } finally {
                fileWriter.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return true;
    }
}
