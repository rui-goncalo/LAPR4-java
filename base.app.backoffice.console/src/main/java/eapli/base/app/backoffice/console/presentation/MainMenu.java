/*
 * Copyright (c) 2013-2019 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.base.app.backoffice.console.presentation;

import eapli.base.app.backoffice.console.presentation.customermanagement.RegisterCustomerUI;
import eapli.base.app.backoffice.console.presentation.ordermanagement.OrderUI;
import eapli.base.app.backoffice.console.presentation.ordermanagement.SalesClerkUpdateOrderUI;
import eapli.base.app.backoffice.console.presentation.ordermanagement.WarehouseUpdateOrderUI;
import eapli.base.app.backoffice.console.presentation.productmanagement.ListProductsAction;
import eapli.base.app.backoffice.console.presentation.productmanagement.ListProductsByBrandAction;
import eapli.base.app.backoffice.console.presentation.productmanagement.RegisterCategoryUI;
import eapli.base.app.backoffice.console.presentation.productmanagement.RegisterProductUI;
import eapli.base.app.backoffice.console.presentation.questionnairemanagement.AnswerUI;
import eapli.base.app.backoffice.console.presentation.questionnairemanagement.QuestionnaireUI;
import eapli.base.app.backoffice.console.presentation.questionnairemanagement.ReportUI;
import eapli.base.app.backoffice.console.presentation.warehouse.AGVOrderUI;
import eapli.base.app.backoffice.console.presentation.warehouse.Actions.*;
import eapli.base.app.common.console.presentation.authz.MyUserMenu;
import eapli.base.Application;
import eapli.base.app.backoffice.console.presentation.authz.AddUserUI;
import eapli.base.app.backoffice.console.presentation.authz.DeactivateUserAction;
import eapli.base.app.backoffice.console.presentation.authz.ListUsersAction;
import eapli.base.app.backoffice.console.presentation.clientuser.AcceptRefuseSignupRequestAction;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.ShowMessageAction;
import eapli.framework.presentation.console.menu.HorizontalMenuRenderer;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

/**
 * TODO split this class in more specialized classes for each menu
 *
 * @author Paulo Gandra Sousa
 */
public class MainMenu extends AbstractUI {

    private static final String RETURN_LABEL = "Return ";

    private static final int EXIT_OPTION = 0;

    // PRODUCT
    private static final int ADD_PROD_OPTION = 1;
    private static final int LIST_PROD_OPTION = 2;
    private static final int LIST_PROD_BY_BRAND = 3;

    // USERS
    private static final int ADD_USER_OPTION = 1;
    private static final int LIST_USERS_OPTION = 2;
    private static final int DEACTIVATE_USER_OPTION = 3;
    private static final int ACCEPT_REFUSE_SIGNUP_REQUEST_OPTION = 4;

    // SETTINGS
    private static final int SET_KITCHEN_ALERT_LIMIT_OPTION = 1;

    //WAREHOUSES
    private static final int WAREHOUSE_IMPORT = 1;
    private static final int WAREHOUSE_LIST = 2;
    private static final int WAISLE_LIST = 3;
    private static final int WROW_LIST = 4;
    private static final int AGVDOCK_LIST = 5;
    private static final int COORDINATE_LIST = 6;
    private static final int AGV_ORDER = 7;
    private static final int UPDATE_ORDER = 8;

    // MAIN MENU
    private static final int MY_USER_OPTION = 1;
    private static final int USERS_OPTION = 2;
    private static final int SALES_CLERK_OPTION = 3;
    private static final int SETTINGS_OPTION = 4;
    private static final int WAREHOUSE_OPTION = 5;

    //SALES_CLERK
    private static final int REGISTER_CUSTOMER = 1;
    private static final int REGISTER_CATEGORY = 2;
    private static final int NEW_ORDER = 3;
    private static final int SC_UPDATE_ORDER = 4;

    //SALES_MANAGER
    private static final int NEW_VALIDATION = 1;
    private static final int NEW_REPORT = 2;

    //Customer
    private static final int ANSWER_QUESTIONNAIRE = 1;

    private static final String SEPARATOR_LABEL = "--------------";

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    @Override
    public boolean show() {
        drawFormTitle();
        return doShow();
    }

    /**
     * @return true if the user selected the exit option
     */
    @Override
    public boolean doShow() {
        final Menu menu = buildMainMenu();
        final MenuRenderer renderer;
        if (Application.settings().isMenuLayoutHorizontal()) {
            renderer = new HorizontalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        } else {
            renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        }
        return renderer.render();
    }

    @Override
    public String headline() {

        return authz.session().map(s -> "Base [ @" + s.authenticatedUser().identity() + " ]")
                .orElse("Base [ ==Anonymous== ]");
    }

    private Menu buildMainMenu() {
        final Menu mainMenu = new Menu();

        final Menu myUserMenu = new MyUserMenu();
        mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.POWER_USER, BaseRoles.ADMIN)) {
            final Menu usersMenu = buildUsersMenu();
            mainMenu.addSubMenu(USERS_OPTION, usersMenu);
            final Menu settingsMenu = buildAdminSettingsMenu();
            mainMenu.addSubMenu(SETTINGS_OPTION, settingsMenu);
        }

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.SALES_CLERK)) {
            final Menu productMenu = buildProductMenu();
            mainMenu.addSubMenu(USERS_OPTION, productMenu);
            final Menu costumerMenu = buildSalesClerkMenu();
            mainMenu.addSubMenu(SALES_CLERK_OPTION, costumerMenu);
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.POWER_USER, BaseRoles.ADMIN, BaseRoles.WAREHOUSE_EMPLOYEE)) {
            final Menu warehouseMenu = buildWarehouseMenu();
            mainMenu.addSubMenu(WAREHOUSE_OPTION, warehouseMenu);
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.SALES_MANAGER)) {
            final Menu salesManagerMenu = buildSalesManagerMenu();
            mainMenu.addSubMenu(USERS_OPTION, salesManagerMenu);
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.CUSTOMER)) {
            final Menu buildCustomerMenu = buildCustomerMenu();
            mainMenu.addSubMenu(USERS_OPTION, buildCustomerMenu);
        }

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        return mainMenu;
    }

    private Menu buildWarehouseMenu() {
        final Menu menu = new Menu("Warehouse >");
        menu.addItem(WAREHOUSE_IMPORT, "Import Warehouses from JSON", new ImportWarehouseAction());
        menu.addItem(WAREHOUSE_LIST, "List all Warehouses", new ListWarehouseAction());
        menu.addItem(WAISLE_LIST, "List all Aisles", new ListWAisleAction());
        menu.addItem(WROW_LIST, "List all Rows", new ListWRowAction());
        menu.addItem(AGVDOCK_LIST, "List all AGVDocks", new ListAGVDockAction());
        menu.addItem(COORDINATE_LIST, "List all Coordinates", new ListCoordinatesAction());
        menu.addItem(AGV_ORDER, "AGV to prepare an Order", new AGVOrderUI()::show);
        menu.addItem(UPDATE_ORDER, "Update Order Status", new WarehouseUpdateOrderUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        return menu;
    }

    private Menu buildAdminSettingsMenu() {
        final Menu menu = new Menu("Settings >");

        menu.addItem(SET_KITCHEN_ALERT_LIMIT_OPTION, "Set kitchen alert limit",
                new ShowMessageAction("Not implemented yet"));
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildUsersMenu() {
        final Menu menu = new Menu("Users >");

        menu.addItem(ADD_USER_OPTION, "Add User", new AddUserUI()::show);
        menu.addItem(LIST_USERS_OPTION, "List all Users", new ListUsersAction());
        menu.addItem(DEACTIVATE_USER_OPTION, "Deactivate User", new DeactivateUserAction());
        menu.addItem(ACCEPT_REFUSE_SIGNUP_REQUEST_OPTION, "Accept/Refuse Signup Request",
                new AcceptRefuseSignupRequestAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildSalesClerkMenu() {
        final Menu menu = new Menu("Sales Clerk >");

        menu.addItem(REGISTER_CUSTOMER, "Register Customer", new RegisterCustomerUI()::show);
        menu.addItem(REGISTER_CATEGORY, "Register Category", new RegisterCategoryUI()::show);
        menu.addItem(NEW_ORDER, "New Order", new OrderUI()::show);
        menu.addItem(SC_UPDATE_ORDER, "Update Order Status", new SalesClerkUpdateOrderUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildProductMenu() {
        final Menu menu = new Menu("Products >");

        menu.addItem(ADD_PROD_OPTION, "Add Product", new RegisterProductUI()::show);
        menu.addItem(LIST_PROD_OPTION, "List All Products", new ListProductsAction());
        menu.addItem(LIST_PROD_BY_BRAND, "Products By Brand", new ListProductsByBrandAction());

        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildSalesManagerMenu() {
        final Menu menu = new Menu("Sales Manager >");

        menu.addItem(NEW_VALIDATION, "Validate Questionnaire and save it", new QuestionnaireUI()::show);
        menu.addItem(NEW_REPORT, "Generate Report", new ReportUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildCustomerMenu() {
        final Menu menu = new Menu("Customer >");

        menu.addItem(ANSWER_QUESTIONNAIRE, "Answer Questionnaire", new AnswerUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }
}
