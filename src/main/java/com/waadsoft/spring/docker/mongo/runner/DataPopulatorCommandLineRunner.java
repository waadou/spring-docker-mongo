package com.waadsoft.spring.docker.mongo.runner;

import java.time.LocalDate;

import org.springframework.stereotype.Component;
import org.springframework.core.annotation.Order;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.waadsoft.spring.docker.mongo.model.Person;
import com.waadsoft.spring.docker.mongo.model.Address;
import com.waadsoft.spring.docker.mongo.repository.PersonRepository;

/**
 *
 * @author Alassani ABODJI <abodjialassani[at]gmail.com>
 */
@Order(1)
@Component
public class DataPopulatorCommandLineRunner implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepo;

    @Override
    public void run(String... args) {
        System.out.println("\n--------------- CREATE PERSONS -------------------------------\n");

        Person person = Person.builder()
                .id("alz")
                .firstName("Alassani")
                .lastName("ABODJI")
                .email("wise-alassani@waadsoft.com")
                .birthDate(LocalDate.of(2000, 12, 2))
                .height(1.76)
                .address(new Address(1L, "Lomé", "Togo", "00", "Togo", "Colombe de la Paix"))
                .build();
        personRepo.save(person);

        person = Person.builder()
                .id("baros")
                .firstName("Aminou")
                .lastName("ABODJI")
                .email("baros-aminou@waadsoft.com")
                .birthDate(LocalDate.of(2002, 12, 4))
                .height(1.76)
                .address(new Address(2L, "Kara", "Togo", "00", "Togo", "Gnrl Eyadema GNASSIMGBE"))
                .build();
        personRepo.save(person);

        person = Person.builder()
                .id("modjo")
                .firstName("Asmiou")
                .lastName("ABODJI")
                .email("gold-modjo@waadsoft.com")
                .birthDate(LocalDate.of(1996, 9, 17))
                .address(new Address(3L, "Libreville", "Gabon", "00", "Gabon", "Akanda"))
                .height(1.58)
                .build();
        personRepo.save(person);

        person = Person.builder()
                .id("meheza")
                .firstName("Meheza")
                .lastName("GENTLE")
                .email("gentle-meheza@meheza.com")
                .birthDate(LocalDate.of(1997, 8, 7))
                .height(1.52)
                .address(new Address(4L, "Adetikope", "Togo", "00", "Togo", "Rue PIA"))
                .build();
        personRepo.save(person);

        person = Person.builder()
                .id("alaza")
                .firstName("Alassani")
                .lastName("LARE")
                .email("larealaza@lare.com")
                .birthDate(LocalDate.of(1994, 8, 8))
                .height(1.62)
                .address(new Address(5L, "Dakar", "Senegal", "00", "Senegal", "Rue Abdoulaye Wad"))
                .build();
        personRepo.save(person);
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
