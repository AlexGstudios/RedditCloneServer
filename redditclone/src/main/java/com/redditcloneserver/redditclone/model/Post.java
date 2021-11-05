package com.redditcloneserver.redditclone.model;

import lombok.*;

@Getter
@Setter
public class Post {
    private String id, title, body;
    private int points;

    public Post(String id, String title, String body, int points) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.points = points;
    }
}
