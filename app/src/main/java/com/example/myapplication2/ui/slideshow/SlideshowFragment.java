package com.example.myapplication2.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.myapplication2.R;
import java.util.ArrayList;

public class SlideshowFragment extends Fragment {

    private EditText foodNameInput, caloriesInput;
    private Button addButton;
    private TextView totalCaloriesText;
    private ListView listView;
    private ArrayAdapter<String> foodAdapter;
    private ArrayList<String> foodList; // Список строк для ListView
    private int totalCalories = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_slideshow, container, false);

        foodNameInput = view.findViewById(R.id.food_name_input);
        caloriesInput = view.findViewById(R.id.calories_input);
        addButton = view.findViewById(R.id.add_button);
        totalCaloriesText = view.findViewById(R.id.total_calories_text);
        listView = view.findViewById(R.id.list_view); // Замените recyclerView на listView

        // Инициализация списка и адаптера
        foodList = new ArrayList<>();
        foodAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, foodList);
        listView.setAdapter(foodAdapter);

        // Обработчик нажатия на кнопку "Добавить"
        addButton.setOnClickListener(v -> addFoodItem());

        return view;
    }

    private void addFoodItem() {
        String foodName = foodNameInput.getText().toString();
        String caloriesString = caloriesInput.getText().toString();

        if (foodName.isEmpty() || caloriesString.isEmpty()) {
            return; // Не добавлять, если поля пустые
        }

        int calories = Integer.parseInt(caloriesString);
        foodList.add(foodName + " - " + calories + " калорий"); // Добавление строки в список
        totalCalories += calories;
        totalCaloriesText.setText("Общее количество калорий: " + totalCalories);

        foodAdapter.notifyDataSetChanged(); // Обновить адаптер
        foodNameInput.setText(""); // Очистить поле
        caloriesInput.setText(""); // Очистить поле
    }
}