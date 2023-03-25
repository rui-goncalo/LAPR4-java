package eapli.base.app.backoffice.console.presentation.questionnairemanagement;

import eapli.base.customermanagement.application.RegisterCustomerController;
import eapli.base.customermanagement.domain.Customer;
import eapli.base.questionnairemanagement.application.QuestionnaireController;
import eapli.base.questionnairemanagement.domain.AlphanumericCodeQuestionnaire;
import eapli.base.questionnairemanagement.domain.PeriodQuestionnaire;
import eapli.base.questionnairemanagement.domain.RulesQuestionnaire;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.Description;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import net.bytebuddy.asm.Advice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class QuestionnaireUI extends AbstractUI {

    private final QuestionnaireController questionnaireController = new QuestionnaireController();
    private final RegisterCustomerController customerController = new RegisterCustomerController();

    @Override
    protected boolean doShow() {
        String path = Console.readNonEmptyLine("Insert questionnaire path.", "Path required.");

        boolean isValid = false;

        try {
            isValid = questionnaireController.questionnaireValidation(path);
            if (isValid == true) {
                System.out.println("Your questionnaire is valid!\n");

                String alphanumericCode = Console.readNonEmptyLine("Insert the alphanumeric code.", "Alphanumeric Code required.");
                String description = Console.readNonEmptyLine("Insert the description.", "Description required.");
                int period = Console.readInteger("Insert the period.");

                try {
                    File questionnaire_file = new File(path);
                    byte[] questionnaire = new byte[(int) questionnaire_file.length()];

                    FileInputStream fis = new FileInputStream(questionnaire_file);
                    if (fis.read(questionnaire) == 0) {
                        System.out.println("Error!! Empty questionnaire.\n");
                    } else {
                        fis.close();
                    }

                    System.out.println("Choose a rule for your questionnaire.\n");
                    System.out.println("1. Age\n2. Gender\n3. Age and Gender\n"); //4.Gender and Brand
                    String rule = Console.readNonEmptyLine("Insert the number of the rule for your questionnaire.", "Required field.");

                    RulesQuestionnaire rulesQuestionnaire = null;
                    List<Customer> customers;
                    List<Customer> ruleCustomers = new ArrayList<>();

                    if (rule.equals("1")) {
                        int age = Console.readInteger("Insert the minimum age: ");
                        rulesQuestionnaire = new RulesQuestionnaire(age);

                        customers = customerController.findAllCustomers();

                        for (Customer c : customers) {
                            if (c.getBirthDate().getAge() >= rulesQuestionnaire.getMinimum_age()) {
                                ruleCustomers.add(c);
                            }
                        }

                        System.out.println("Customers added: " + ruleCustomers);

                    } else if (rule.equals("2")) {
                        String gender = Console.readLine("Insert the gender: (male/female/other)");
                        rulesQuestionnaire = new RulesQuestionnaire(gender);

                        customers = customerController.findAllCustomers();

                        for (Customer c : customers) {
                            if (c.getGender().toString().equals(rulesQuestionnaire.getGender())) {
                                ruleCustomers.add(c);
                            }
                        }

                        System.out.println("Customers added: " + ruleCustomers);

                    } else if (rule.equals("3")) {
                        int age = Console.readInteger("Insert the minimum age: ");
                        String gender = Console.readLine("Insert the gender: (male/female/other)");
                        rulesQuestionnaire = new RulesQuestionnaire(age, gender);

                        customers = customerController.findAllCustomers();

                        for (Customer c : customers) {
                            if (c.getBirthDate().getAge() >= rulesQuestionnaire.getMinimum_age() && c.getGender().toString().equals(rulesQuestionnaire.getGender())) {
                                ruleCustomers.add(c);
                            }
                        }

                        System.out.println("Customers added: " + ruleCustomers);

                    }

                    boolean flag = false;
                    while (flag == false) {
                        String opt = Console.readLine("Do you want to save your questionnarie in the database? (y/n)");
                        if (opt.equals("y")) {
                            try {
                                questionnaireController.saveQuestionnaire(AlphanumericCodeQuestionnaire.valueOf(alphanumericCode), Description.valueOf(description), PeriodQuestionnaire.valueOf(period), questionnaire, rulesQuestionnaire, ruleCustomers);
                            } catch (@SuppressWarnings("unused") final IntegrityViolationException e) {
                                System.out.println("Error while saving the questionnaire in the database.");
                            }
                            flag = true;
                        } else {
                            System.out.println("We'll not save your questionnaire in the database.\n");
                            flag = true;
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException("File not found in the path.\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    @Override
    public String headline() {
        return "questionnaire";
    }
}
