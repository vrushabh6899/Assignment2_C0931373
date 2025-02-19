package com.example;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

@Getter
@ToString
@EqualsAndHashCode
@Jacksonized
@Builder
public class Person {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final Integer age;
    private final String gender;

    private Person(String id, String firstName, String lastName, Integer age, String gender) {
        if (id == null) throw new IllegalArgumentException("id cannot be null");
        if (firstName == null || firstName.isBlank()) throw new IllegalArgumentException("firstName cannot be null or blank");
        if (lastName == null || lastName.isBlank()) throw new IllegalArgumentException("lastName cannot be null or blank");
        if (age != null && age < 0) throw new IllegalArgumentException("age cannot be negative");

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }
}