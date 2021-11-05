package com.redditcloneserver.redditclone.model;

import java.util.ArrayList;
import java.util.List;

import lombok.*;

@Getter
@Setter
public class User {

    private String userName, passWord;
    private List<Post> userPost;

    public User(String name, String pass) {
        this.userName = name;
        this.passWord = pass;
        this.userPost = new ArrayList<>();
    }
}
