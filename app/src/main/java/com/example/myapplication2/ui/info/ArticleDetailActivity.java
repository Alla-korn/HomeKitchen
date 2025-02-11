package com.example.myapplication2.ui.info;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication2.R;
import com.squareup.picasso.Picasso;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

public class ArticleDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);

        TextView titleTextView = findViewById(R.id.article_title_detail);
        TextView contentTextView = findViewById(R.id.article_content);
        ImageView imageView = findViewById(R.id.article_image_detail); // Инициализация ImageView

        String title = getIntent().getStringExtra("title");
        String content = getIntent().getStringExtra("content");
        String imageUrl = getIntent().getStringExtra("imageUrl"); // Получаем URL изображения

        titleTextView.setText(title);
        contentTextView.setText(content);

        // Проверяем, что imageUrl не пустой перед загрузкой
        if (imageUrl != null && !imageUrl.isEmpty()) {
            Picasso.get().load(imageUrl).into(imageView); // Загрузка изображения с помощью Picasso
        } else {
            // Обработка случая, когда URL изображения отсутствует
            imageView.setImageResource(R.drawable.ic_menu_gallery); // Установите изображение-заполнитель, если нужно
        }
    }
}