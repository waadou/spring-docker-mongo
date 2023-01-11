package com.waadsoft.spring.docker.mongo.repository;

import java.time.Month;
import java.time.LocalDate;
import static java.util.Objects.isNull;

import com.mongodb.client.result.UpdateResult;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.beans.factory.annotation.Autowired;

import com.waadsoft.spring.docker.mongo.model.Person;

/**
 *
 * @author Alassani ABODJI <abodjialassani[at]gmail.com>
 */
@Repository
public class CustomPersonRepositoryImpl implements CustomPersonRepository {

    @Autowired
    private MongoTemplate mongo;

    @Override
    public void updatePersonBirthDate(String email, LocalDate newBirthDate) {
        Query query = new Query(Criteria.where("email").is(email));
        Update update = new Update();
        update.set("birthDate", LocalDate.of(2023, Month.JANUARY, 11));

        UpdateResult result = mongo.updateFirst(query, update, Person.class);

        System.out.println((isNull(result) ? "No documents updated" : result.getModifiedCount() + " document(s) updated.."));
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
