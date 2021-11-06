package com.redditcloneserver.redditclone.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DTOPost {
    @JsonIgnore
    private String id;
    
    private String title, body;
    private int points;
    private String hyperLink;

    public DTOPost(String id, String title, String body, int points) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.points = points;
        this.hyperLink = "/post/" + title;
    }
}
