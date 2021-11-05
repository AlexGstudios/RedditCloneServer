package com.redditcloneserver.redditclone.Repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.redditcloneserver.redditclone.model.Post;

import org.springframework.stereotype.Repository;

@Repository
public class PostRepository {

    private final Map<String, Post> posts = new HashMap<>();

    public Post get(String post) {
        return posts.get(post.toLowerCase());
    }

    public void savePost(Post post) {
        posts.put(post.getTitle().toLowerCase(), post);
    }

    public Collection<Post> getPosts() {
        return posts.values();
    }
}