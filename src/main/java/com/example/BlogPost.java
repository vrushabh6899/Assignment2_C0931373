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
public class BlogPost {
    private final String id;
    private final String authorId;
    private final String postContent;

    private BlogPost(String id, String authorId, String postContent) {
        if (id == null) throw new IllegalArgumentException("id cannot be null");
        if (authorId == null) throw new IllegalArgumentException("authorId cannot be null");

        this.id = id;
        this.authorId = authorId;
        this.postContent = postContent;
    }
}