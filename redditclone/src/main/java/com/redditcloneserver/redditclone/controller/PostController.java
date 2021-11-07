package com.redditcloneserver.redditclone.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import com.redditcloneserver.redditclone.dto.DTOPost;
import com.redditcloneserver.redditclone.model.Post;
import com.redditcloneserver.redditclone.model.User;
import com.redditcloneserver.redditclone.service.PostService;
import com.redditcloneserver.redditclone.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    public DTOPost getPost(@RequestHeader("token") String token, @RequestBody Post post, HttpServletResponse response) {

        if (token != null) {
            DTOPost dtoPost = postService.getPost(post.getId());

            if (dtoPost != null) {
                response.setStatus(200);
                return dtoPost;
            } else {
                response.setStatus(401);
                return null;
            }
        } else {
            return null;
        }
    }

    @PutMapping("/create")
    public DTOPost newPost(@RequestHeader("token") String token, @RequestBody Post post, HttpServletResponse response) {

        if (token != null) {
            response.setStatus(201);
            return postService.newPost(post);
        } else {
            response.setStatus(401);
            return null;
        }
    }

    // // @RequestHeader("token") String token,
    // @PutMapping("/update")
    // public DTOPost update(@RequestBody Post post, HttpServletResponse response){

    // return dtoPost;
    // }

    @DeleteMapping("/delete")
    public String delete(@RequestHeader("token") String token, @RequestBody String id, HttpServletResponse response) {

        if (token != null) {
            String deleted = postService.delete(id);
            if (deleted == "Post has been deleted")
                response.setStatus(200);
            else
                response.setStatus(401);

            return deleted;
        } else {
            response.setStatus(401);
            return "Please create a Account.";
        }
    }
}
