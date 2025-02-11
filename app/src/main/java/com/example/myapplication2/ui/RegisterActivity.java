package com.example.myapplication2.ui;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication2.R;

public class RegisterActivity extends AppCompatActivity {

    public EditText editTextName;
    public EditText editTextPassword;
    public Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register); // Убедитесь, что имя файла XML соответствует

        // Инициализация полей ввода и кнопки
        editTextName = findViewById(R.id.editTextName);

        editTextPassword = findViewById(R.id.editTextPassword);
        buttonRegister = findViewById(R.id.buttonRegister);

        // Установка обработчика нажатия на кнопку регистрации
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        // Получаем введенные данные
        String name = editTextName.getText().toString().trim();

        String password = editTextPassword.getText().toString().trim();

        // Проверка на пустые поля
        if (name.isEmpty() ||  password.isEmpty()) {
            Toast.makeText(this, "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT).show();
            return;
        }

        // Здесь можно добавить логику для регистрации пользователя,
        // например, отправку данных на сервер или сохранение в локальной базе данных

        // Для примера, просто отображаем сообщение о том, что регистрация прошла успешно
        Toast.makeText(this, "Регистрация прошла успешно", Toast.LENGTH_SHORT).show();

        // После успешной регистрации можно перейти на другой экран, например, на экран входа
         Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
         finish();
    }
}
