package com.redditcloneserver.redditclone.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import com.redditcloneserver.redditclone.dto.DTOPost;
import com.redditcloneserver.redditclone.model.Post;
import com.redditcloneserver.redditclone.service.PostService;
import com.redditcloneserver.redditclone.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;
    UserService userService;

    @GetMapping("/all")
    public Collection<DTOPost> getAllPosts() {
        return postService.getPosts();
    }

    @GetMapping("/{id}")
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

    // @RequetHeader("token") String token,
    @PutMapping("/create")
    public DTOPost newPost( @RequestBody Post post, HttpServletResponse response) {

        // User user = userService.validate(token);

        if (post != null) { // ska vara token
            response.setStatus(200);
            return postService.newPost(post);
        } else {
            response.setStatus(401);
            return null;
        }
    }

    // @RequetHeader("token") String token,
    @PutMapping("/update")
    public DTOPost update(@RequestBody Post post, HttpServletResponse response){
        
        return dtoPost;
    }
}
