package com.example.assignment.service;

import com.example.assignment.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Wadi
 * @since 7/21/2024
 **/
//wadi
@Service
public class UserServiceImpl implements UserService {

    private Map<Integer, User> users = new HashMap<>();
    private int nextUserId = 1;

    @Override
    public User createUser(User user) {
        user.setId(nextUserId++);
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public User getUser(int userId) {
        return users.get(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    @Override
    public User updateUser(int userId, User updatedUser) {
        users.put(userId, updatedUser);
        return updatedUser;
    }

    @Override
    public void deleteUser(int userId) {
        users.remove(userId);
    }
}