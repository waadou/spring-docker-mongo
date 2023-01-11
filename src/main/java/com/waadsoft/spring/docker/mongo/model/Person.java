package com.waadsoft.spring.docker.mongo.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Alassani ABODJI <abodjialassani[at]gmail.com>
 */
@Document("persons")
public class Person {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private LocalDate birthDate;

    private double height;

    private Address address;

    /*---------------------------------------------------------
    |      C   O   N   S   T   R   U   C   T   O   R   S      |
    ==========================================================*/
    protected Person() {
    }

    /*---------------------------------------------------------
    |       A C C E S S O R S    /    M O D I F I E R S       |
    ==========================================================*/
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    /*---------------------------------------------------------
    |   H A S H C O D E  /  E Q U A L S  /  T O S T R I N G   |
    ==========================================================*/
    @Override
    public String toString() {
        return "Person{"
                + "id=" + id
                + ", email=" + email
                + ", firstName=" + firstName
                + ", lastName=" + lastName
                + ", birthDate=" + birthDate
                + ", height=" + height + '}';
    }

    /*---------------------------------------------------------
    |          B   U   I   L   D   E   R                      |
    ==========================================================*/
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private final Person person;

        private Builder() {
            this.person = new Person();
        }

        public Person build() {
            return person;
        }

        public Builder firstName(String firstName) {
            this.person.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.person.lastName = lastName;
            return this;
        }

        public Builder email(String email) {
            this.person.email = email;
            return this;
        }

        public Builder birthDate(LocalDate birthDate) {
            this.person.birthDate = birthDate;
            return this;
        }

        public Builder id(String id) {
            this.person.id = id;
            return this;
        }

        public Builder height(double height) {
            this.person.height = height;
            return this;
        }

        public Builder address(Address address) {
            this.person.address = address;
            return this;
        }
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
