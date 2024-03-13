package com.example.autolookbook;

public class Car {
    private String name;
    private String description;
    private int imageResource; // Variable to hold the image resource ID

    // Constructor
    public Car(String name, String description, int imageResource) {
        this.name = name;
        this.description = description;
        this.imageResource = imageResource; // Initialize the image resource ID
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResource() {
        return imageResource; // Getter method for the image resource ID
    }

    // You might have other methods here as needed
}
