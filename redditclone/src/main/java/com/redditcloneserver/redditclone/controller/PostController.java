package com.redditcloneserver.redditclone.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import com.redditcloneserver.redditclone.dto.DTOPost;
import com.redditcloneserver.redditclone.model.Post;
import com.redditcloneserver.redditclone.model.User;
import com.redditcloneserver.redditclone.service.PostService;
import com.redditcloneserver.redditclone.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/post")
@Controller
public class PostController {

    @Autowired
    PostService postService;
    UserService userService;

    @GetMapping("/all")
    public Collection<DTOPost> getAllPosts() {
        return postService.getPosts();
    }

    @GetMapping("/get-post/{id}")
    public DTOPost getPost(@RequestBody Post post, HttpServletResponse response) {
        DTOPost exists = postService.getPost(post.getTitle());
        if (exists != null) {
            response.setStatus(200);
            return exists;
        } else {
            response.setStatus(401);
            return null;
        }

    }

    @PutMapping("/create")
    public Post newPost(@RequestHeader("token") String token, @RequestBody Post post, HttpServletResponse response) {

        User user = userService.validate(token);

        if (token != null) {
            response.setStatus(200);
            return postService.newPost(post);
        } else {
            response.setStatus(401);
            return null;
        }
    }
}
