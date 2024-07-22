package com.example.assignment.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Wadi
 * @since 7/21/2024
 **/

@Getter
@Setter
public class Task {
    private int id;
    private String title;
    private String description;
    private String status;
    private Priority priority;
    private Date dueDate;


    public Task(int id, String title, String description, String status, Priority priority, Date dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.dueDate = dueDate;
    }
}