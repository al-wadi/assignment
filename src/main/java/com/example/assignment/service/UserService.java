package com.example.assignment.service;

import com.example.assignment.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUser(int userId);
    List<User> getAllUsers();
    User updateUser(int userId, User updatedUser);
    void deleteUser(int userId);
}