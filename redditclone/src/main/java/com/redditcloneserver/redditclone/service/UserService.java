package com.redditcloneserver.redditclone.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.redditcloneserver.redditclone.Repositories.UserRepository;
import com.redditcloneserver.redditclone.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    Map<String, User> tokens = new HashMap<>();

    public String registerUser(String userName, String passWord) {

        User existing = userRepository.getUser(userName);

        if (existing != null) {
            return "Account with that username is already taken.";
        }
        userRepository.saveUser(new User(userName, passWord));

        return "Account created";
    }

    public String login(String userName, String passWord) {
        User user = userRepository.getUser(userName);
        if (user == null) {
            return "Account not found.";
        }
        if (!user.getPassword().equals(passWord)) {
            return "Username or Password are incorrect.";
        }

        String token = UUID.randomUUID().toString();
        tokens.put(token, user);
        return token;
    }

    public void logout(String token) {
        tokens.remove(token);
    }

    public User validate(String token) {
        return tokens.get(token);
    }
}