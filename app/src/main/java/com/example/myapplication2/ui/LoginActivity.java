package com.example.myapplication2.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication2.ui.Database;
import com.example.myapplication2.MainActivity;
import com.example.myapplication2.R;

public class LoginActivity extends AppCompatActivity {

    private Database database;
    private TextView errorTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        database = new Database();

        EditText usernameEditText = findViewById(R.id.usernameEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);
        Button loginButton = findViewById(R.id.loginButton);
        errorTextView = findViewById(R.id.errorTextView);

       // RegisterActivity registerActivity= new RegisterActivity();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String username = usernameEditText.getText().toString().trim();
                    String password = passwordEditText.getText().toString().trim();

                    // Проверка пользователя
                    if (database.isUserExists(username, password)) {
                        // Если пользователь найден, переход на главную активность
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish(); // Закрыть LoginActivity, чтобы вернуться нельзя было
                    } else {
                        // Если пользователь не найден, показать сообщение об ошибке
                        errorTextView.setText("Неверное имя пользователя или пароль");
                        errorTextView.setVisibility(View.VISIBLE);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    //Toast.makeText(LoginActivity.this, "Произошла ошибка. Пожалуйста, попробуйте еще раз.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish(); // Закрыть LoginActivity, чтобы вернуться нельзя было
                }
            }
        });

        TextView registerTextView = findViewById(R.id.registerTextView);
        registerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Здесь добавьте логику для перехода на экран регистрации
                // Например, запустите новую активность:
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                 startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        database.close(); // Закрытие соединения с базой данных при уничтожении активности
    }
}
