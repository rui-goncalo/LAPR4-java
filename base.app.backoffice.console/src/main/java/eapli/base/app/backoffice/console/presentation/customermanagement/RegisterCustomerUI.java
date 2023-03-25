package eapli.base.app.backoffice.console.presentation.customermanagement;

import eapli.base.customermanagement.application.RegisterCustomerController;
import eapli.base.customermanagement.domain.Customer;
import eapli.base.customermanagement.domain.NameCustomer;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import javax.persistence.Column;

public class RegisterCustomerUI extends AbstractUI {
    private final RegisterCustomerController theController = new RegisterCustomerController();

    @Override
    protected boolean doShow() {
        final Iterable<Customer> customers = this.theController.customers();

        final String firstName = Console.readNonEmptyLine("Insert first name:", "First name required.");
        final String lastName = Console.readNonEmptyLine("Insert last name:", "Last name required.");
        final String name = Console.readNonEmptyLine("Insert full name:", "Full name required.");
        final String gender = Console.readLine("\nInsert gender:");
        final String extension_str = Console.readNonEmptyLine("\nInsert extension:", "Extension required.");
        final String phone_str = Console.readNonEmptyLine("\nInsert phone:", "Phone required.");
        final String vat = Console.readNonEmptyLine("\nInsert VAT:", "VAT required.");
        final String postalAddress = Console.readLine("\nInsert Postal Address:");
        final String email = Console.readNonEmptyLine("\nInsert Email:", "Email required.");
        final int year = Console.readInteger("\nInsert year of birth:");
        final int month = Console.readInteger("\nInsert month of birth:");
        final int day = Console.readInteger("\nInsert day of birth:");

        int extension = Integer.parseInt(extension_str);
        int phone = Integer.parseInt(phone_str);

        try {
            this.theController.registerCustomer(firstName, lastName, name, gender, extension, phone, vat, postalAddress, email, year, month, day);
        } catch (@SuppressWarnings("unused") final IntegrityViolationException e) {
            System.out.println("This customer already exists in the database.");
        }

        return false;
    }

    @Override
    public String headline() {
        return "Register Customer";
    }
}