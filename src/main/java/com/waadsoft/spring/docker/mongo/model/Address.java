package com.waadsoft.spring.docker.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Alassani ABODJI <abodjialassani[at]gmail.com>
 */
@Document("address")
public class Address {

    @Id
    private Long id;

    private String city;

    private String country;

    private String postalCode;

    private String state;

    private String street;

    /*---------------------------------------------------------
    |      C   O   N   S   T   R   U   C   T   O   R   S      |
    ==========================================================*/
    public Address() {
    }

    public Address(Long id, String city, String country, String postalCode, String state, String street) {
        this.id = id;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
        this.state = state;
        this.street = street;
    }

    /*---------------------------------------------------------
    |       A C C E S S O R S    /    M O D I F I E R S       |
    ==========================================================*/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    /*---------------------------------------------------------
    |   H A S H C O D E  /  E Q U A L S  /  T O S T R I N G   |
    ==========================================================*/
    @Override
    public String toString() {
        return "Address{" + "id=" + id + ", city=" + city + ", country=" + country + ", postalCode=" + postalCode + ", state=" + state + ", street=" + street + '}';
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
