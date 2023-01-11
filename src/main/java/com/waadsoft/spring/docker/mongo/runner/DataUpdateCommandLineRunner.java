package com.waadsoft.spring.docker.mongo.runner;

import java.util.List;
import static java.util.Objects.nonNull;

import org.springframework.stereotype.Component;
import org.springframework.core.annotation.Order;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.waadsoft.spring.docker.mongo.model.Person;
import com.waadsoft.spring.docker.mongo.repository.PersonRepository;

/**
 *
 * @author Alassani ABODJI <abodjialassani[at]gmail.com>
 */
@Order(3)
@Component
public class DataUpdateCommandLineRunner implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepo;

    @Override
    public void run(String... args) {

        updatePersonHeight("Alassani");

        deletePersonById("meheza");

        deletePersonByEmail("larealaza@lare.com");
    }

    void updatePersonHeight(String firstName) {

        log("\n--------------- UPDATE THE HEIGHT OF ALL PERSONS WITH FIRST NAME: '" + firstName + "'-------------------------------\n");

        // Find all the persons with the first name snacks
        List<Person> persons = personRepo.findAllByFistName(firstName);

        persons.forEach(person -> {
            // Set height to 1.80 if height >= 1.70
            if (person.getHeight() >= 1.70) {
                person.setHeight(1.80);
            } else {
                person.setHeight(1.60);
            }
        });

        // Save all the items in database
        List<Person> updatedPersons = personRepo.saveAll(persons);

        if (nonNull(updatedPersons)) {
            log("Successfully updated " + updatedPersons.size() + " persons.");
        }
    }

    void deletePersonById(String id) {
        log("\n---------- DELETE PERSON HAVING ID: '" + id + "' -------------------\n");

        personRepo.deleteById(id);

        log("Person with id " + id + " deleted...");
    }

    void deletePersonByEmail(String email) {
        log("\n---------- DELETE PERSON HAVING EMAIL: '" + email + "' -------------------\n");

        personRepo.deleteByEmail(email);

        log("Person with email " + email + " deleted...");
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
