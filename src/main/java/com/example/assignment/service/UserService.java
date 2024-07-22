package com.example.assignment.service;

import com.example.assignment.model.User;

import java.util.List;

/**
 * Created by Wadi
 * Date 7/21/2024
 **/

public interface UserService {

    User createUser(User user);

    User getUser(int userId);

    List<User> getAllUsers();

    User updateUser(int userId, User updatedUser);

    void deleteUser(int userId);

}