package com.example.assignment.service;

import com.example.assignment.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Wadi
 * Date 7/21/2024
 **/
@Service
public class ProjectService {
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        // Data validation
        if (task.getTitle() == null || task.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Task title cannot be empty.");
        }
        if (task.getDescription() == null || task.getDescription().isEmpty()) {
            throw new IllegalArgumentException("Task description cannot be empty.");
        }
        if (task.getStatus() == null || task.getStatus().isEmpty()) {
            throw new IllegalArgumentException("Task status cannot be empty.");
        }
        if (task.getPriority() == null) {
            throw new IllegalArgumentException("Task priority cannot be empty.");
        }
        if (task.getDueDate() == null) {
            throw new IllegalArgumentException("Task due date cannot be null.");
        }

        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }

    public Map<String, Long> countTask() {
        return tasks.stream().collect(Collectors.groupingBy(Task::getStatus, Collectors.counting()));
    }
}