package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    void whenIdIsNull_throwException() {
        Person.PersonBuilder builder = Person.builder()
                .id(null)
                .firstName("John")
                .lastName("Doe");
        assertThrows(IllegalArgumentException.class, builder::build);
    }

    @Test
    void whenFirstNameIsBlank_throwException() {
        Person.PersonBuilder builder = Person.builder()
                .id("1")
                .firstName(" ")
                .lastName("Doe");
        assertThrows(IllegalArgumentException.class, builder::build);
    }

    @Test
    void whenAgeIsNegative_throwException() {
        Person.PersonBuilder builder = Person.builder()
                .id("1")
                .firstName("John")
                .lastName("Doe")
                .age(-1);
        assertThrows(IllegalArgumentException.class, builder::build);
    }

    @Test
    void validPerson_createdSuccessfully() {
        Person person = Person.builder()
                .id("1")
                .firstName("John")
                .lastName("Doe")
                .age(30)
                .build();
        assertNotNull(person);
        assertEquals("John", person.getFirstName());
    }
}