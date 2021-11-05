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

    public int registerUser(String userName, String passWord) {

        User existing = userRepository.getUser(userName);

        if (existing != null) {
            return 1;
        }
        userRepository.saveUser(new User(userName, passWord));

        return 0;
    }

    public String login(String userName, String passWord) {
        User user = userRepository.getUser(userName);
        if (user == null) {
            return null;
        }
        if (!user.getPassWord().equals(passWord)) {
            return null;
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