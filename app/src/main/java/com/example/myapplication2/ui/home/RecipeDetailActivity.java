package com.example.myapplication2.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;
import com.example.myapplication2.R;

public class RecipeDetailActivity extends AppCompatActivity {

    private TextView ingredient1TextView;
    private TextView ingredient2TextView;
    private TextView ingredient3TextView;
    private TextView ingredient4TextView;
    private TextView ingredient5TextView;
    private TextView ingredient6TextView;

    private LinearLayout stepContainer; // Контейнер для шагов

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        // Инициализация элементов интерфейса
        ImageView imageView = findViewById(R.id.detail_image);
        TextView titleTextView = findViewById(R.id.detail_title);
        TextView descriptionTextView = findViewById(R.id.detail_description);
        TextView ingredientsTitleTextView = findViewById(R.id.ingredients_title); // Заголовок для ингредиентов
        CardView ingredientsCardView = findViewById(R.id.ingredients_card); // CardView для ингредиентов
        ingredient1TextView = findViewById(R.id.detail_ingredient_1); // Для первого ингредиента
        ingredient2TextView = findViewById(R.id.detail_ingredient_2); // Для второго ингредиента
        ingredient3TextView = findViewById(R.id.detail_ingredient_3);
        ingredient4TextView = findViewById(R.id.detail_ingredient_4);
        ingredient5TextView = findViewById(R.id.detail_ingredient_5);
        ingredient6TextView = findViewById(R.id.detail_ingredient_6);

        // Инициализация контейнера для шагов
        stepContainer = findViewById(R.id.step_container);

        // Получаем данные из интента
        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra("imageUrl");
        String title = intent.getStringExtra("title");
        String description = intent.getStringExtra("description");
        String ingredient1 = intent.getStringExtra("ingredient1"); // Получаем первый ингредиент
        String ingredient2 = intent.getStringExtra("ingredient2"); // Получаем второй ингредиент
        String ingredient3 = intent.getStringExtra("ingredient3");
        String ingredient4 = intent.getStringExtra("ingredient4");
        String ingredient5 = intent.getStringExtra("ingredient5");
        String ingredient6 = intent.getStringExtra("ingredient6");

        // Настраиваем элементы
        Glide.with(this)
                .load(imageUrl)
                .placeholder(R.drawable.ic_menu_gallery) // Заглушка во время загрузки
                .error(R.drawable.ic_menu_gallery) // Изображение при ошибке загрузки
                .into(imageView);

        titleTextView.setText(title);
        descriptionTextView.setText(description);
        ingredientsTitleTextView.setText("Ингредиенты"); // Заголовок для ингредиентов
        ingredient1TextView.setText(ingredient1); // Устанавливаем текст для первого ингредиента
        ingredient2TextView.setText(ingredient2); // Устанавливаем текст для второго ингредиента
        ingredient3TextView.setText(ingredient3);
        ingredient4TextView.setText(ingredient4);
        ingredient5TextView.setText(ingredient5);
        ingredient6TextView.setText(ingredient6);

        // Вывод шагов
        int i = 1;
        while (intent.hasExtra("stepText" + i)) {
            String stepText = intent.getStringExtra("stepText" + i);
            String stepImageUrl = intent.getStringExtra("stepImage" + i);

            Log.d("StepDetail", "Step " + i + ": " + stepText); // Логгируем шаг

            // Создаем новый LinearLayout для текущего шага
            LinearLayout stepLayout = new LinearLayout(this);
            stepLayout.setOrientation(LinearLayout.VERTICAL);
            stepLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            stepLayout.setPadding(0, 0, 0, 16); // Отступ снизу

            // Создаем новый TextView для текста шага
            TextView stepTextView = new TextView(this);
            stepTextView.setText(stepText);
            stepTextView.setTextSize(16); // Установка размера шрифта
            stepLayout.addView(stepTextView); // Добавляем TextView в текущий LinearLayout

            // Создаем новый ImageView для изображения шага
            // Создаем новый ImageView для изображения шага
            ImageView stepImageView = new ImageView(this);
            LinearLayout.LayoutParams imageLayoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    400 // Устанавливаем высоту на 300dp или больше
            );
            stepImageView.setLayoutParams(imageLayoutParams); // Применяем параметры
            Glide.with(this)
                    .load(stepImageUrl)
                    .placeholder(R.drawable.ic_menu_gallery) // Заглушка
                    .error(R.drawable.ic_menu_gallery) // Изображение при ошибке загрузки
                    .into(stepImageView); // Загружаем изображение
            stepLayout.addView(stepImageView); // Добавляем ImageView в текущий LinearLayout

            // Добавляем текущий LinearLayout с шагом в контейнер шагов
            stepContainer.addView(stepLayout);

            i++;
        }
    }
}
