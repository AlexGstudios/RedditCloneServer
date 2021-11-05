package com.redditcloneserver.redditclone.Repositories;

import java.util.HashMap;
import java.util.Map;

import com.redditcloneserver.redditclone.model.User;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private final Map<String, User> users = new HashMap<>();

    public User getUser(String name) {
        return users.get(name.toLowerCase());
    }

    public void saveUser(User user) {
        users.put(user.getUserName().toLowerCase(), user);
    }
}
