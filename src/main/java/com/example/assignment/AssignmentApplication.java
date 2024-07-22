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
    private final ProjectService projectService;

    @Autowired
    private final TaskProcessor taskProcessor;

    public AssignmentApplication(ProjectService projectService, TaskProcessor taskProcessor) {
        this.projectService = projectService;
        this.taskProcessor = taskProcessor;
    }

    public static void main(String[] args) {
        SpringApplication.run(AssignmentApplication.class, args);
    }

    @Override
    public void run(String... args){
        // Create and add tasks
        addTask("Task 1", "description 1", "pending",Priority.LOW, new Date());
        addTask("Task 2", "description 2", "pending", Priority.LOW, new Date());
        addTask("Task 3", "description 3", "pending", Priority.MEDIUM, new Date());
        addTask("Task 4", "description 4", "pending", Priority.HIGH, new Date());
        addTask("Task 5", "description 5", "pending", Priority.HIGH, new Date());

        // Print task count
        System.out.println("tasks :-" + projectService.countTask());

        // Process tasks asynchronously
        taskProcessor.processTasks(projectService.getTasks());
    }

    private void addTask(String title, String description, String status, Priority priority, Date dueDate) {
        projectService.addTask(new Task(0, title, description, status, priority, dueDate));
    }
}