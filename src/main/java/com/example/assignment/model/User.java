package com.example.assignment.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Wadi
 * Date 7/21/2024
 **/
@Setter
@Getter
public class User {
    private int id;
    private String name;
    private String email;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

}