package org.example;

import com.example.Blog;
import com.example.BlogPost;
import com.example.Person;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Read person.json and blogPosts.json
            List<Person> persons = mapper.readValue(new File("src/main/resources/person.json"), new TypeReference<>() {});
            List<BlogPost> blogPosts = mapper.readValue(new File("src/main/resources/blogpost.json"), new TypeReference<>() {});

            // Create a Blog instance
            Blog blog = new Blog(blogPosts, persons);

            // Call getPostsByAuthorAge and print results
            List<String> postsByAge = blog.getPostsByAuthorAge(30);
            System.out.println("Posts by authors aged 30: " + postsByAge);

            // Print total number of blog posts and contributors
            System.out.println("Total blog posts: " + blog.getPosts().size());
            System.out.println("Total contributors: " + blog.getContributors().size());

        } catch (IOException e) {
            System.err.println("Error reading JSON files: " + e.getMessage());
        }
    }
}