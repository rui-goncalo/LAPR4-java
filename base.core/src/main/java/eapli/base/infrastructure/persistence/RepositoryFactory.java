/*
 * Copyright (c) 2013-2021 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eapli.base.infrastructure.persistence;

import eapli.base.questionnairemanagement.repositories.AnswerRepository;
import eapli.base.questionnairemanagement.repositories.QuestionnaireRepository;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.customermanagement.repositories.CustomerRepository;
import eapli.base.itemorderedmanagement.repositories.ItemOrderedRepository;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.productmanagement.repositories.CategoryRepository;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.base.warehousemanagement.repositories.*;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;

/**
 * @author Paulo Gandra Sousa
 */
public interface RepositoryFactory {

    /**
     * factory method to create a transactional context to use in the repositories
     *
     * @return
     */
    TransactionalContext newTransactionalContext();

    /**
     * @param autoTx the transactional context to enrol
     * @return
     */
    UserRepository users(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    UserRepository users();

    /**
     * @param autoTx the transactional context to enroll
     * @return
     */
    ClientUserRepository clientUsers(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    ClientUserRepository clientUsers();

    /**
     * @param autoTx the transactional context to enroll
     * @return
     */
    SignupRequestRepository signupRequests(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    SignupRequestRepository signupRequests();

    CustomerRepository customers();

    OrderRepository orders();

    ItemOrderedRepository itemsOrdered();

    CategoryRepository categories();

    ProductRepository products();

    WarehouseRepository warehouses();

    WAisleRepository waisles();

    WRowRepository wrows();

    AGVDocksRepository agvdocks();

    CoordinatesRepository coordinates();

    QuestionnaireRepository questionnaires();

    AnswerRepository answers();
}