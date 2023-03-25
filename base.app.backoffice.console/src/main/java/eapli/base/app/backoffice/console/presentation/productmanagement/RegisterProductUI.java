package eapli.base.app.backoffice.console.presentation.productmanagement;

import eapli.base.productmanagement.application.RegisterProductController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

public class RegisterProductUI extends AbstractUI {
    private final RegisterProductController prdtControl = new RegisterProductController();
    private static final Logger LOGGER = LogManager.getLogger(RegisterProductUI.class);


    @Override
    protected boolean doShow() {

        final String name = Console.readLine("Product Name: \n");
        final String short_description = Console.readLine("Short Description: \n");
        final String long_description = Console.readLine("Long Description: \n");
        final String category = Console.readLine("Category: \n");
        final String brand = Console.readLine("Brand: \n");
        final String ref = Console.readLine("Product Reference: ");
        final int barcode = Integer.parseInt(Console.readLine("Barcode: "));
        final double price = Double.parseDouble(Console.readLine("Price: "));
        final int internal_code = Integer.parseInt(Console.readLine("Internal Code: "));
        final double weight = Double.parseDouble(Console.readLine("Weight: "));
        final String imgs = Console.readLine("Photo URL: ");


        // getting the input stream is a responsibility of the presentation layer
        final InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(imgs);

        if (inputStream == null) {
            LOGGER.warn("Could not load image {}", imgs);
            // fallback to registration without image
            register(name, short_description, long_description, category, brand, ref, barcode, price, internal_code, weight);
            return true;

        } else {
            try {
                this.prdtControl.registerProduct(name, short_description, long_description, category, brand, ref, barcode, price, internal_code, weight, inputStream);
                LOGGER.info(name);
                return true;
            } catch (final IntegrityViolationException | ConcurrencyException e) {
                // ignoring exception. assuming it is just a primary key violation
                // due to the tentative of inserting a duplicated user
                LOGGER.warn("Assuming {} already exists (activate trace log for details)", name);
                LOGGER.trace("Assuming existing record", e);
            } catch (final IOException e) {
                LOGGER.error("There was a problem loading the image file {} while registering allergen {}",
                        imgs, name);
            }
        }
        return false;

    }

    private void register(String name, String short_description, String long_description, String category, String brand, String reference, int barcode, double price, int internal_code, double weight) {
        try {
            prdtControl.registerProduct(name, short_description, long_description, category, brand, reference, barcode,
                    price, internal_code, weight);
            LOGGER.info(name);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", name);
            LOGGER.trace("Assuming existing record", e);
        }
    }

    @Override
    public String headline() {
        return "Register Product.\n";
    }
}