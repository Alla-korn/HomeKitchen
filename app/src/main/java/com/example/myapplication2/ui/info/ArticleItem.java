package com.example.myapplication2.ui.info;

public class ArticleItem {
    private String title;
    private String description;
    private String content;
    private String imageUrl; // Поле для ссылки на изображение

    public ArticleItem(String title, String description, String content, String imageUrl) {
        this.title = title;
        this.description = description;
        this.content = content;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getContent() {
        return content;
    }

    public String getImageUrl() {
        return imageUrl; // Метод для получения ссылки на изображение
    }
}
