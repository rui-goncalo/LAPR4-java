package eapli.base.questionnairemanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import java.util.Locale;

@Embeddable
public class RulesQuestionnaire implements ValueObject {
    private int minimum_age;
    private String gender;

//    private String brand;

    protected RulesQuestionnaire() {
    }

    public RulesQuestionnaire(int minimum_age) {
        if (StringPredicates.isNullOrEmpty(String.valueOf(minimum_age)) || minimum_age > 100 || minimum_age < 18) {
            throw new IllegalArgumentException("Minimum age should be between 18 and 100 and not blank. Try again.");
        }
        this.minimum_age = minimum_age;
    }

    public RulesQuestionnaire(String gender) {
        this.gender = gender;
    }

    public RulesQuestionnaire(int minimum_age, String gender) {
        if (StringPredicates.isNullOrEmpty(String.valueOf(minimum_age)) || minimum_age > 100 || minimum_age < 18) {
            throw new IllegalArgumentException("Minimum age should be between 18 and 100 and not blank. Try again.");
        }
        this.minimum_age = minimum_age;
        this.gender = gender;
    }

//    public RulesQuestionnaire(String gender, String brand) {
//        if (!gender.toLowerCase().equals("male") || !gender.toLowerCase().equals("female") || !gender.toLowerCase().equals("other")) {
//            throw new IllegalArgumentException("Choose between male, female or other.");
//        }
//        this.gender = gender;
//        this.brand = brand;
//    }

    public int getMinimum_age() {
        return minimum_age;
    }

    public String getGender() {
        return gender;
    }

//    public String getBrand() {
//        return brand;
//    }

    public void setMinimum_age(int minimum_age) {
        this.minimum_age = minimum_age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

//    public void setBrand(String brand) {
//        this.brand = brand;
//    }

    @Override
    public String toString() {
        return "Rules Questionnaire: " +
                "\nminimum_age: " + minimum_age +
                "\ngender: " + gender;
//                "\nbrand: " + brand;
    }
}
