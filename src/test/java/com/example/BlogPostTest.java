package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BlogPostTest {
    @Test
    void whenIdIsNull_throwException() {
        BlogPost.BlogPostBuilder builder = BlogPost.builder()
                .id(null)
                .authorId("author1");
        assertThrows(IllegalArgumentException.class, builder::build);
    }

    @Test
    void whenAuthorIdIsNull_throwException() {
        BlogPost.BlogPostBuilder builder = BlogPost.builder()
                .id("1")
                .authorId(null);
        assertThrows(IllegalArgumentException.class, builder::build);
    }

    @Test
    void validBlogPost_createdSuccessfully() {
        BlogPost post = BlogPost.builder()
                .id("1")
                .authorId("author1")
                .postContent("Hello World")
                .build();
        assertNotNull(post);
        assertEquals("author1", post.getAuthorId());
    }
}