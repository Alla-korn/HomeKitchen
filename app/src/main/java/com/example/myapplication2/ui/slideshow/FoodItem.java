package com.example.myapplication2.ui.slideshow;

public class FoodItem {
    private String name;
    private int calories;

    public FoodItem(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }
}
