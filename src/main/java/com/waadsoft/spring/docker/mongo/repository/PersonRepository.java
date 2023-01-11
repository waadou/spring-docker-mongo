package com.waadsoft.spring.docker.mongo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.waadsoft.spring.docker.mongo.model.Person;

/**
 * A customized {@link MongoRepository} to add additional methods.
 *
 * @author Alassani ABODJI <abodjialassani[at]gmail.com>
 */
public interface PersonRepository extends MongoRepository<Person, String> {

    @Query("{email:'?0'}")
    Optional<Person> findByEmail(String email);

    @Query("{firstName:'?0', lastName:'?1'}")
    Optional<Person> findByFirstAndLastName(String firstName, String lastName);

    @Query("{firstName:'?0'}")
    List<Person> findAllByFistName(String firstName);

    @Query("{lastName:'?0'}")
    List<Person> findAllByLastName(String lastName);

    @Query(value = "{firstName:'?0'}", fields = "{'firstName' : 1, 'lastName' : 1, 'birthDate': 1}")
    List<Person> findPersonByFirstName(String firstName);

    @Override
    long count();

    default void deleteByEmail(String email) {
        findByEmail(email).ifPresent(this::delete);
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
