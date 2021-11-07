package com.redditcloneserver.redditclone.controller;

import javax.servlet.http.HttpServletResponse;

import com.redditcloneserver.redditclone.model.User;
import com.redditcloneserver.redditclone.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PutMapping("/register")
    public String register(@RequestBody User user, HttpServletResponse response) {
        response.setStatus(201);
        return userService.registerUser(user.getUsername(), user.getPassword());
    }

    @PostMapping("/login")
    public String login(@RequestBody User user, HttpServletResponse response) {
        response.setStatus(200);
        return userService.login(user.getUsername(), user.getPassword());
    }

    @PostMapping("/logout")
    public String logout(@RequestHeader("token") String token) {
        userService.logout(token);
        return "Logged out";
    }
}