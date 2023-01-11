package com.waadsoft.spring.docker.mongo.runner;


import org.springframework.stereotype.Component;
import org.springframework.core.annotation.Order;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.waadsoft.spring.docker.mongo.repository.PersonRepository;

/**
 *
 * @author Alassani ABODJI <abodjialassani[at]gmail.com>
 */
@Order(2)
@Component
public class DataRetrievalCommandLineRunner implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepo;

    @Override
    public void run(String... args) {

        showAllPersons();

        getPersonsByFirstName("Alassani");

        getPersonsByLastName("ABODJI");

        getPersonsByFirstAndLastName("Meheza", "GENTLE");

        getPersonByEmail("gold-modjo@waadsoft.com");

        findCountOfPersons();
    }

    void showAllPersons() {
        log("\n--------------- SHOW ALL PERSONS -------------------------------\n");

        personRepo.findAll().forEach(DataRetrievalCommandLineRunner::log);
    }

    void getPersonsByFirstName(String firstName) {
        log("\n---------- SHOW ALL PERSONS HAVING FIRST NAME: '" + firstName + "'-----------------------------\n");

        personRepo.findAllByFistName(firstName).forEach(DataRetrievalCommandLineRunner::log);
    }

    void getPersonsByLastName(String lastName) {
        log("\n---------- SHOW ALL PERSONS HAVING LAST NAME: '" + lastName + "'-----------------------------\n");

        personRepo.findAllByLastName(lastName).forEach(DataRetrievalCommandLineRunner::log);
    }

    void getPersonsByFirstAndLastName(String firstName, String lastName) {
        log("\n---------- SHOW PERSON HAVING FIRST NAME: '" + firstName + "' AND LAST NAME: '" + lastName + "' -----\n");

        personRepo.findByFirstAndLastName(firstName, lastName).ifPresent(DataRetrievalCommandLineRunner::log);
    }

    void getPersonByEmail(String email) {
        log("\n---------- SHOW PERSON HAVING EMAIL: '" + email + "' -------------------\n");

        personRepo.findByEmail(email).ifPresent(DataRetrievalCommandLineRunner::log);
    }

    // 4. Get count of documents in the collection
    void findCountOfPersons() {
        long count = personRepo.count();
        log("\nNumber of documents in the collection: " + count);
    }

    static void log(Object o) {
        System.out.println(o);
    }
}

/*=============================================================================
 * Copyright 2023 Waad Soft<https://www.waadsoft.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 =============================================================================*/
