package com.example.autolookbook;

public class Car {
    private String name;
    private String description;
    private int imageUrl; // Assuming drawable resources for simplicity

    // Constructor, getters, and setters
    public Car(String name, String description, int imageUrl) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageUrl() {
        return imageUrl;
    }
}
