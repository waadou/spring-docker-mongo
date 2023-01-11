package com.waadsoft.spring.docker.mongo;

import org.bson.Document;
import com.mongodb.DBObject;
import org.junit.jupiter.api.Test;
import com.mongodb.BasicDBObjectBuilder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.data.mongodb.core.MongoTemplate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.assertj.core.api.Java6Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

/**
 *
 * @author Alassani ABODJI <abodjialassani[at]gmail.com>
 */
@DataMongoTest
@ExtendWith(SpringExtension.class)
class SpringDockerMongoApplicationTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void givenObjectAvailableWhenSaveToCollectionThenExpectValue() {
        String firstName = "Alassani";
        String lastName = "ABODJI";

        // given
        DBObject object = BasicDBObjectBuilder.start().add("Manning", "Spring Boot In Practice").get();
        // when
        mongoTemplate.save(object, "collection");
        // then
        assertThat(mongoTemplate.findAll(DBObject.class, "collection"))
                .extracting("Manning")
                .containsOnly("Spring Boot In Practice");

        Document doc = Document.parse("{\"firstname\":\"" + firstName
                + "\", \"lastname\":\"" + lastName + "\"}");

        Document inserted = mongoTemplate.insert(doc, "items");

        System.out.println(inserted);

        assertNotNull(inserted.get("_id"));
        assertEquals(inserted.get("firstname"), firstName);
        assertEquals(inserted.get("lastname"), lastName);
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
