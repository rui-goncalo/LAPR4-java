package eapli.base.questionnairemanagement.application;

import eapli.base.questionnairemanagement.domain.Questionnaire;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ReportController {
    private final AnswerController answerController = new AnswerController();

    public Integer[] getReport(String opt) {
        Questionnaire questionnaire = answerController.findByAlphanumericCode(opt);
        Integer[] report = new Integer[10];

        try {
            boolean flag = true;
            int num_respostas = 0, num_perguntas = 0;

            Scanner scanner = null;
            try {
                scanner = new Scanner(new FileReader("/Users/tiagoandre/Downloads/lei21_22_s4_2dk_03/base.core/src/main/java/eapli/base/questionnairemanagement/Answer.txt"));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            List<String> answers = new LinkedList<>();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equals("Q1:")) {
                    flag = true;
                }

                if (flag == true) {
                    if (line.contains("?")) {
                        num_perguntas++;
                        while (!line.contains("Obligatoriness")) {
                            line = scanner.nextLine();
                        }
                        if (line.equals("Obligatoriness: Mandatory.")) {
                            while (!line.contains("Type")) {
                                line = scanner.nextLine();
                            }
                            if (line.contains("Free-Text")) {
                                num_respostas++;
                            } else if (line.contains("Single-choice")) {
                                num_respostas++;
                            } else if (line.contains("Multiple-choice")) {
                                num_respostas++;
                                while (!line.equals("")) {
                                    line = scanner.nextLine();
                                }
                            }
                        }
                        else if (line.equals("Obligatoriness: Optional.")) {
                            while (!line.contains("Type")) {
                                line = scanner.nextLine();
                            }
                            if (line.contains("Free-Text")) {
                                if (!scanner.nextLine().equals("Not answered.")) {
                                    num_respostas++;
                                }
                            } else if (line.contains("Single-choice")) {
                                if (!scanner.nextLine().equals("Not answered.")) {
                                    num_respostas++;
                                }
                            } else if (line.contains("Multiple-choice")) {
                                if (!scanner.nextLine().equals("Not answered.")) {
                                    num_respostas++;
                                }
                                while (!line.equals("")) {
                                    line = scanner.nextLine();
                                }
                            }
                        }
                    }
                }
            }

            report[0] = num_perguntas;
            report[1] = num_respostas;
            report[2] = (report[1] * 100) / report[0];

            scanner.close();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

        return report;
    }
}
