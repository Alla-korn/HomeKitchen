package com.example.myapplication2.ui.gallery;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.cardview.widget.CardView; // Импортируйте CardView

import com.example.myapplication2.R;

public class GalleryFragment extends Fragment {

    private EditText ageInput, heightInput, weightInput;
    private Spinner activitySpinner, goalSpinner;
    private Button calculateButton;
    private TextView resultText;
    private CardView resultCard; // Объявляем переменную для CardView

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        ageInput = view.findViewById(R.id.age_input);
        heightInput = view.findViewById(R.id.height_input);
        weightInput = view.findViewById(R.id.weight_input);
        activitySpinner = view.findViewById(R.id.activity_spinner);
        goalSpinner = view.findViewById(R.id.goal_spinner);
        calculateButton = view.findViewById(R.id.calculate_button);
        resultText = view.findViewById(R.id.result_text);
        resultCard = view.findViewById(R.id.result_card); // Инициализация переменной

        // Установка адаптеров для спиннеров
        ArrayAdapter<CharSequence> activityAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.activity_levels, android.R.layout.simple_spinner_item);
        activityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        activitySpinner.setAdapter(activityAdapter);

        ArrayAdapter<CharSequence> goalAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.goals, android.R.layout.simple_spinner_item);
        goalAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        goalSpinner.setAdapter(goalAdapter);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateCalories();
            }
        });

        return view;
    }

    private void calculateCalories() {
        try {
            int age = Integer.parseInt(ageInput.getText().toString());
            int height = Integer.parseInt(heightInput.getText().toString());
            int weight = Integer.parseInt(weightInput.getText().toString());
            String activityLevel = activitySpinner.getSelectedItem().toString();
            String goal = goalSpinner.getSelectedItem().toString();

            // Формула расчета BMR (Basal Metabolic Rate) по Mifflin-St Jeor
            double bmr;

            bmr = 10 * weight + 6.25 * height - 5 * age + 5;

            // Уровень активности
            double activityMultiplier;
            switch (activityLevel) {
                case "Низкая":
                    activityMultiplier = 1.2;
                    break;
                case "Умеренная":
                    activityMultiplier = 1.55;
                    break;
                case "Высокая":
                    activityMultiplier = 1.9;
                    break;
                default:
                    activityMultiplier = 1.2;
                    break;
            }

            // Ккал в день
            double maintenanceCalories = bmr * activityMultiplier;

            // Коррекция в зависимости от цели
            if (goal.equals("Похудение")) {
                maintenanceCalories -= 500; // Уменьшение на 500 ккал для похудения
            } else if (goal.equals("Набор массы")) {
                maintenanceCalories += 500; // Увеличение на 500 ккал для набора массы
            }

            // Пример распределения макронутриентов (по умолчанию 50% углеводов, 30% белков, 20% жиров)
            double proteinCalories = maintenanceCalories * 0.3;
            double fatCalories = maintenanceCalories * 0.2;
            double carbCalories = maintenanceCalories * 0.5;

            // Переводим калории в граммы
            double proteinGrams = proteinCalories / 4;
            double fatGrams = fatCalories / 9;
            double carbGrams = carbCalories / 4;

            // Отображение результата
            String result = String.format("Калории: %.0f\nБелки: %.1f г\nЖиры: %.1f г\nУглеводы: %.1f г",
                    maintenanceCalories, proteinGrams, fatGrams, carbGrams);
            resultText.setText(result);
            resultCard.setVisibility(View.VISIBLE); // Показываем карточку результата

        } catch (NumberFormatException e) {
            Toast.makeText(getContext(), "Пожалуйста, введите корректные данные", Toast.LENGTH_SHORT).show();
        }
    }
}