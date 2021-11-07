package com.redditcloneserver.redditclone.model;

import lombok.*;

@Getter
@Setter
public class Post {
    private String id, title, body, username;
    private int points;

    public Post(String title, String body, String username, int points) {
        this.id = title;
        this.title = title;
        this.body = body;
        this.username = username;
        this.points = points;
    }
}
