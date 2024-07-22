package com.example.assignment;


import com.example.assignment.model.Priority;
import com.example.assignment.model.Task;
import com.example.assignment.service.ProjectService;
import com.example.assignment.utils.TaskProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;


@SpringBootApplication
public class AssignmentApplication implements CommandLineRunner {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private TaskProcessor taskProcessor;

    public static void main(String[] args) {
        SpringApplication.run(AssignmentApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Create and add tasks
        addTask("Task 1", "description", "pending",Priority.LOW, new Date());
        addTask("Task 2", "description", "pending", Priority.LOW, new Date());
        addTask("Task 3", "description", "pending", Priority.MEDIUM, new Date());
        addTask("Task 4", "description", "pending", Priority.HIGH, new Date());
        addTask("Task 5", "description", "pending", Priority.HIGH, new Date());

        // Print task count
        System.out.println("tasks :-" + projectService.countTask());

        // Process tasks asynchronously
        taskProcessor.processTasks(projectService.getTasks());
    }

    // Helper method to add tasks using a lambda
    private void addTask(String title, String description, String status, Priority priority, Date dueDate) {
        projectService.addTask(new Task(0, title, description, status, priority, dueDate));
    }
}