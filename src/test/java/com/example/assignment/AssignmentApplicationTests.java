package com.example.assignment;

import com.example.assignment.model.Priority;
import com.example.assignment.model.Task;
import com.example.assignment.utils.TaskProcessor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@SpringBootTest
class AssignmentApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private TaskProcessor taskProcessor;

    @Test
    public void testProcessTasks() {

        taskProcessor.processTasks(new ArrayList<>());

        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1, "Task 1", "Description 1", "Pending", Priority.HIGH, new Date()));
        tasks.add(new Task(2, "Task 2", "Description 2", "Pending", Priority.LOW, new Date()));

    }
}