package com.redditcloneserver.redditclone.model;

import java.util.ArrayList;
import java.util.List;

import lombok.*;

@Getter
@Setter
public class User {

    private String username, password;
    private List<Post> userpost;

    public User(String name, String pass) {
        this.username = name;
        this.password = pass;
        this.userpost = new ArrayList<>();
    }
}
