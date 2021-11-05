package com.redditcloneserver.redditclone.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import com.redditcloneserver.redditclone.model.Post;

@Getter
@Setter
public class DTOUser {

    private String userName, passWord;
    private List<Post> userPost;

    public DTOUser(String userName, String passWord, Post post) {
        this.userName = userName;
        this.passWord = passWord;
        userPost.add(post);
    }
}
