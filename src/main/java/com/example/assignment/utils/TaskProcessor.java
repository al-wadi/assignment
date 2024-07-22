package com.example.assignment.utils;

import com.example.assignment.model.Task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class TaskProcessor {
    private final ExecutorService executorService = Executors.newFixedThreadPool(5); // Reduced thread pool size
    private List<Task> completedTasks = new ArrayList<>(); // Store completed tasks

    public void processTasks(List<Task> tasks) {
        for (Task task : tasks) {
            executorService.execute(() -> {
                try {
                    System.out.println("Processing task: " + task.getTitle());
                    Thread.sleep(1000);
                    task.setStatus("Completed");
                    System.out.println("Completed task: " + task.getTitle());
                    completedTasks.add(task); // Add to completed tasks list
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Task processing interrupted: " + task.getTitle());
                    // Handle error
                }
            });
        }

        executorService.shutdown();
    }

    public List<Task> getCompletedTasks() {
        return completedTasks;
    }
}