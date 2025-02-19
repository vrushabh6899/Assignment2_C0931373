package com.example;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class BlogTest {
    @Test
    void getPostsByAuthorAge_validAge_returnsPosts() {
        Person person1 = Person.builder().id("1").firstName("John").lastName("Doe").age(30).build();
        Person person2 = Person.builder().id("2").firstName("Jane").lastName("Doe").age(25).build();

        BlogPost post1 = BlogPost.builder().id("p1").authorId("1").postContent("Post 1").build();
        BlogPost post2 = BlogPost.builder().id("p2").authorId("2").postContent("Post 2").build();

        Blog blog = new Blog(Arrays.asList(post1, post2), Arrays.asList(person1, person2));

        List<String> posts = blog.getPostsByAuthorAge(30);
        assertEquals(1, posts.size());
        assertEquals("p1", posts.get(0));
    }

    @Test
    void getPostsByAuthorAge_noMatchingAge_returnsEmptyList() {
        Person person1 = Person.builder().id("1").firstName("John").lastName("Doe").age(30).build();
        BlogPost post1 = BlogPost.builder().id("p1").authorId("1").postContent("Post 1").build();

        Blog blog = new Blog(Collections.singletonList(post1), Collections.singletonList(person1));

        List<String> posts = blog.getPostsByAuthorAge(25);
        assertTrue(posts.isEmpty());
    }

    @Test
    void getPostsByAuthorAge_missingAuthor_returnsEmptyList() {
        Person person1 = Person.builder().id("1").firstName("John").lastName("Doe").age(30).build();
        BlogPost post1 = BlogPost.builder().id("p1").authorId("2").postContent("Post 1").build();

        Blog blog = new Blog(Collections.singletonList(post1), Collections.singletonList(person1));

        List<String> posts = blog.getPostsByAuthorAge(30);
        assertTrue(posts.isEmpty());
    }
}