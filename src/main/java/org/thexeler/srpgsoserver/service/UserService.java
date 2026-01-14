package org.thexeler.srpgsoserver.service;

import org.springframework.stereotype.Service;
import org.thexeler.srpgsoserver.User;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private Map<String, User> users = new HashMap<>();

    public boolean validateUser(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }

    public void registerUser(User user) {
        users.put(user.getUsername(), user);
    }
}
