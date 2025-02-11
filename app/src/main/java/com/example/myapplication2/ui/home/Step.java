package com.example.myapplication2.ui.home;



public class Step {
    private String text;       // Текст шага
    private String imageUrl;   // URL изображения шага

    public Step(String text, String imageUrl) {
        this.text = text;
        this.imageUrl = imageUrl;
    }

    public String getText() {
        return text; // Геттер для текста шага
    }

    public String getImageUrl() {
        return imageUrl; // Геттер для URL изображения шага
    }
}