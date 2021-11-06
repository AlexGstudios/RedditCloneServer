package com.redditcloneserver.redditclone.controller;

import javax.servlet.http.HttpServletResponse;

import com.redditcloneserver.redditclone.Repositories.UserRepository;
import com.redditcloneserver.redditclone.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    // @PutMapping("/register")
    // public DTOUser register(@RequestBody User user, HttpServletResponse response) {

    //     return dtoUser;
    // }
}
