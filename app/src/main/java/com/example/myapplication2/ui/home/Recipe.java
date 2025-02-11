package com.example.myapplication2.ui.home;

import java.util.List;

public class Recipe {
    private String imageUrl;
    private String title;
    private String description;
    private String[] ingredients; // Массив строк для ингредиентов
    private List<Step> steps; // Новый список шагов

    public Recipe(String imageUrl, String title, String description, String[] ingredients, List<Step> steps) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.description = description;
        this.ingredients = ingredients; // Инициализация массива ингредиентов
        this.steps = steps; // Инициализация списка шагов
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String[] getIngredients() {
        return ingredients; // Геттер для массива ингредиентов
    }

    public List<Step> getSteps() {
        return steps; // Геттер для списка шагов
    }
}
