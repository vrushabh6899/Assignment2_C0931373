package com.example;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Blog {
    private final List<BlogPost> posts;
    private final List<Person> contributors;

    public Blog(List<BlogPost> posts, List<Person> contributors) {
        this.posts = posts;
        this.contributors = contributors;
    }

    public List<BlogPost> getPosts() {
        return posts;
    }

    public List<Person> getContributors() {
        return contributors;
    }

    public List<String> getPostsByAuthorAge(Integer age) {
        return posts.stream()
                .filter(post -> contributors.stream()
                        .anyMatch(person -> person.getId().equals(post.getAuthorId()) &&
                                person.getAge() != null && person.getAge().equals(age)))
                .map(BlogPost::getId)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Blog blog = (Blog) o;
        return Objects.equals(posts, blog.posts) && Objects.equals(contributors, blog.contributors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(posts, contributors);
    }

    @Override
    public String toString() {
        return "Blog{" +
                "posts=" + posts +
                ", contributors=" + contributors +
                '}';
    }
}