package com.example.assignment.controller;

import com.example.assignment.model.Priority;
import com.example.assignment.model.Task;
import com.example.assignment.model.User;
import com.example.assignment.service.ProjectService;
import com.example.assignment.utils.TaskProcessor;
import com.example.assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Wadi
 * @since 7/21/2024
 **/

@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private TaskProcessor taskProcessor;

    @Autowired
    private UserService userService;

    @GetMapping("/tasks/highPriority")
    public Set<Task> getHighPriorityTasks() {
        List<Task> tasks = projectService.getTasks();

        // Filter tasks by priority using the PriorityLevel enum
        Set<Task> highPriorityTasks = tasks.stream()
                .filter(task -> task.getPriority().equals(Priority.HIGH))
                .collect(Collectors.toSet());

        return highPriorityTasks;
    }

    @GetMapping("/process")
    public void processTasks() {
        taskProcessor.processTasks(projectService.getTasks());
    }

    // User related endpoints

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable int userId) {
        return userService.getUser(userId);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/users/{userId}")
    public User updateUser(@PathVariable int userId, @RequestBody User updatedUser) {
        return userService.updateUser(userId, updatedUser);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
    }
}


