package com.example.assignment.utils;

import com.example.assignment.model.Task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Wadi
 * Date 7/21/2024
 **/

@Component
public class TaskProcessor {
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);
    private final List<Task> completedTasks = new ArrayList<>();

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
                }
            });
        }

        executorService.shutdown();
    }

}