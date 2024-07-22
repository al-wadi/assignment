package com.example.assignment.model;

/**
 * @author Wadi
 * @since 7/21/2024
 **/

public enum Priority {
    HIGH(3),
    MEDIUM(2),
    LOW(1);

    private final int priority;

    Priority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
    public static Priority castPriority(String s){
        return switch (s.toUpperCase()) {
            case "HIGH" -> Priority.HIGH;
            case "MEDIUM" -> Priority.MEDIUM;
            case "LOW" -> Priority.LOW;
            default -> null;
        };
    }


}
