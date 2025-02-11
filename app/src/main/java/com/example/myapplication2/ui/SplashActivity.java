package com.example.myapplication2.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication2.MainActivity;
import com.example.myapplication2.R;
import com.example.myapplication2.ui.LoginActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash); // Замените на ваш XML-файл для экрана загрузки

        // Задержка перед переходом на главную активность
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, LoginActivity.class); // Переход к LoginActivity
            startActivity(intent);
            finish(); // Закрываем SplashActivity, чтобы не вернуться обратно
        }, 3000); // 3000 миллисекунд = 3 секунды
    }
}
