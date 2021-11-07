package com.redditcloneserver.redditclone.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DTOPost {

    private String id;
    private String title, body, username;
    private int points;
    private String hyperLink;

    public DTOPost(String id, String title, String body, String username, int points) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.username = username;
        this.points = points;
        this.hyperLink = "/post/" + id;
    }
}
