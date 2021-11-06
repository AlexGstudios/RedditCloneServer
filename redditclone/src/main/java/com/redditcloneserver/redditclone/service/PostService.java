package com.redditcloneserver.redditclone.service;

import java.util.ArrayList;
import java.util.Collection;

import com.redditcloneserver.redditclone.Repositories.PostRepository;
import com.redditcloneserver.redditclone.dto.DTOPost;
import com.redditcloneserver.redditclone.model.Post;
import com.redditcloneserver.redditclone.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public Collection<DTOPost> getPosts() {
        Collection<Post> posts = postRepository.getPosts();
        Collection<DTOPost> dtoPosts = new ArrayList<>();

        for (Post post : posts) {
            dtoPosts.add(new DTOPost(post.getId(), post.getTitle(), post.getBody(), post.getPoints()));
        }

        return dtoPosts;
    }

    public DTOPost getPost(String post) {
        Post exists = postRepository.get(post);
        if (exists != null) {
            DTOPost dtoPost = new DTOPost(exists.getId(), exists.getTitle(), exists.getBody(), exists.getPoints());
            return dtoPost;
        } else {
            return null;
        }
    }

    public DTOPost newPost(Post post) {
        Post existing = postRepository.get(post.getId());

        if (existing == null) {
            postRepository.savePost(post);
            DTOPost dtoPost = new DTOPost(post.getId(), post.getTitle(), post.getBody(), post.getPoints());
            return dtoPost;
        } else {
            return null;
        }
    }

    public Post addComment(User user, String postTitle) {
        Post post = postRepository.get(postTitle);
        if (post != null) {
            return post;
        }

        user.getUserPost().add(post);
        return post;
    }

    // public DTOPost update(Post post){
    // return;
    // }

    public String delete(String id) {
        Post exists = postRepository.get(id.toLowerCase());

        if (exists != null) {
            return postRepository.delete(id);
        } else {
            return "Nothing to delete";
        }
    }
}