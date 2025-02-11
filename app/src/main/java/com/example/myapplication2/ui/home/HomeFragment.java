 package com.example.myapplication2.ui.home;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication2.R;
import com.example.myapplication2.ui.home.Recipe;
import com.example.myapplication2.ui.home.RecipeAdapter;
import com.example.myapplication2.ui.home.RecipeDetailActivity;
import com.example.myapplication2.ui.home.Step;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecipeAdapter recipeAdapter;
    private List<Recipe> recipeList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Заполнение списка рецептов с URL изображений и шагами
        recipeList = new ArrayList<>();

        // Создание шагов для первого рецепта
        List<Step> steps1 = new ArrayList<>();
        steps1.add(new Step("Шаг 1: Снимите с апельсина цедру мелкой теркой с зубцами, выжмите из мякоти сок. Положите сливочное масло в емкость, подходящую для микроволновой печи. Растопите его за 2-3 приема по 10-15 секунд.", "https://cdn.food.ru/unsigned/fit/640/480/ce/0/czM6Ly9tZWRpYS9waWN0dXJlcy8yMDI0MTIyNy8zUUpDWVkuanBlZw.webp"));
        steps1.add(new Step("Шаг 2: Продолжая размешивать массу миксером, всыпьте к ней муку и разрыхлитель. Замесите однородное густое тесто. Крупно натрите шоколад, аккуратно вмешайте получившуюся стружку в тесто.", "https://cdn.food.ru/unsigned/fit/640/480/ce/0/czM6Ly9tZWRpYS9waWN0dXJlcy8yMDI0MTIyNy80RUVzaFkuanBlZw.webp"));

        // Добавление первого рецепта
        recipeList.add(new Recipe("https://cdn.food.ru/unsigned/fit/640/480/ce/0/czM6Ly9tZWRpYS9waWN0dXJlcy8yMDI0MTIyNy80RzJLcnAuanBlZw.webp",
                "Апельсиновые кексы с шоколадом", "40 минут",
                new String[] {"Пшеничная мука: 1 стакан", "Апельсин: 1 шт.", "Яйца: 1 шт.", "Сливочное масло: 60 г", "Разрыхлитель теста: 1 ч. л", "Сахар: 60 г", "Темный шоколад: 60 г"},
                steps1));

        // Создание шагов для второго рецепта
        List<Step> steps2 = new ArrayList<>();
        steps2.add(new Step("Шаг 1: Помойте овощи. Снимите шелуху с лука, морковь оставьте в мундире", "https://cdn.food.ru/unsigned/fit/640/480/ce/0/czM6Ly9tZWRpYS9waWN0dXJlcy8yMDI0MTIyNi80OGN4ZkcuanBlZw.webp"));
        steps2.add(new Step("Шаг 2: Разомните рыбу вилкой. Проверьте, нет ли косточек. Выложите рыбу первым слоем на дно тарелки для подачи. Промажьте тонкой сеточкой из майонеза и посолите по вкусу.", "hhttps://cdn.food.ru/unsigned/fit/640/480/ce/0/czM6Ly9tZWRpYS9waWN0dXJlcy8yMDI0MTIyNi9SY1NNNXouanBlZw.webp"));
        steps2.add(new Step("Шаг 3: Распределите по рыбному слою грибы с луком и также посолите и покройте майонезной сеточкой.", "https://cdn.food.ru/unsigned/fit/640/480/ce/0/czM6Ly9tZWRpYS9waWN0dXJlcy8yMDI0MTIyNi8zYnh2RXQuanBlZw.webp"));


        // Добавление второго рецепта
        recipeList.add(new Recipe("https://cdn.food.ru/unsigned/fit/640/480/ce/0/czM6Ly9tZWRpYS9waWN0dXJlcy8yMDI0MTIyNi8zbTdmWnYuanBlZw.webp",
                "Салат «Мимоза» с грибами",
                "40 минут",
                new String[] {"Рыбные консервы: 1 банка", "Морковь: 1шт","Куриное яйцо: 4 шт.","Шампиньоны: 200 г", "Майонез"},
                steps2));

        // Добавление третьего рецепта
        recipeList.add(new Recipe("https://cdn.food.ru/unsigned/fit/640/480/ce/0/czM6Ly9tZWRpYS9waWN0dXJlcy8yMDI0MTIyNS8zSnlUN0IuanBlZw.webp",
                "Сырный суп с мидиями",
                "30 минут",
                new String[] {"Мидии в раковинах: 450 г", "Плавленый сыр: 85 г","Картошка: 4 шт.","Морковь: 200 г", "Репчатый лук: 40 г"},
                steps2));

        // Создание шагов для третьего рецепта
        List<Step> steps3 = new ArrayList<>();
        steps3.add(new Step("Шаг 1: Нарежьте картофель кубиками со стороной 1,5-2 см. Мелко натрите морковь, нашинкуйте лук кубиками со стороной 3-4 мм. Отделите от стеблей листья петрушки, мелко их порубите. Пропустите чеснок через пресс. Натрите твердый сыр на средней терке.", "https://cdn.food.ru/unsigned/fit/640/480/ce/0/czM6Ly9tZWRpYS9waWN0dXJlcy8yMDI0MTIyNS80UHJoZGEuanBlZw.webp"));
        steps3.add(new Step("Шаг 2: Разогрейте на среднем огне сковороду с растительным маслом. Пожарьте лук 2-3 минуты до светло-карамельного цвета. Положите морковь и обжарьте овощи вместе, помешивая, еще 2-3 минуты до мягкости. Выложите овощную зажарку в кастрюлю с картофелем.", "https://cdn.food.ru/unsigned/fit/640/480/ce/0/czM6Ly9tZWRpYS9waWN0dXJlcy8yMDI0MTIyNS8zS2NpTGsuanBlZw.webp"));
        steps3.add(new Step("Шаг 3: Дождитесь, когда суп закипит, опустите в него мидии. Всыпьте тертый твердый сыр, соль, черный перец, положите плавленый сыр и чеснок. Хорошо перемешайте и проварите суп в течение 3-4 минут, чтобы сыр полностью расплавился.", "https://cdn.food.ru/unsigned/fit/640/480/ce/0/czM6Ly9tZWRpYS9waWN0dXJlcy8yMDI0MTIyNS81UEVCYmMuanBlZw.webp"));
        steps3.add(new Step("Шаг 4: Выключите огонь под кастрюлей, всыпьте в суп петрушку. Перемешайте суп, накройте его крышкой и дайте настояться около 5 минут. Подайте к сырном супу с мидиями ломтики свежего багета.", "https://cdn.food.ru/unsigned/fit/640/480/ce/0/czM6Ly9tZWRpYS9waWN0dXJlcy8yMDI0MTIyNS9DS0hjRlMuanBlZw.webp"));

        // Добавление четвертого рецепта
        recipeList.add(new Recipe("https://cdn.food.ru/unsigned/fit/640/480/ce/0/czM6Ly9tZWRpYS9waWN0dXJlcy8yMDI0MTIyNy9KNHdNS2YuanBlZw.webp",
                "Сытные котлеты",
                "30 минут",
                new String[] {"Фарш домашний: 450 г", "Грецкие орехи: 85 г","Плавленый сыр: 80 г","МКуриное яйцо: 1 шт", "Репчатый лук: 40 г"},
                steps2));

        // Создание шагов для четвертого рецепта
        List<Step> steps4 = new ArrayList<>();
        steps4.add(new Step("Шаг 1: Вымойте и почистите картофель. Очистите от шелухи лук и чеснок. Подготовьте миску, терку, блендер с чашей и сковороду.Выложите фарш в миску. Положите очищенные грецкие орехи в чашу блендера, перебейте их до мелкой крошки. Пересыпьте орехи к фаршу.", "https://cdn.food.ru/unsigned/fit/640/480/ce/0/czM6Ly9tZWRpYS9waWN0dXJlcy8yMDI0MTIyNy8zTUhkdW0uanBlZw.webp"));
        steps4.add(new Step("Шаг 2: Мелко натрите картофель и добавьте вместе с сыром в миску с фаршем. Разбейте туда же яйцо, всыпьте соль и смесь молотых перцев. Вымесите однородный гладкий фарш, периодически отбивая его об миску.", "https://cdn.food.ru/unsigned/fit/640/480/ce/0/czM6Ly9tZWRpYS9waWN0dXJlcy8yMDI0MTIyNy80UFBhTjguanBlZw.webp"));
        steps4.add(new Step("Шаг 3: Слегка смочите руки водой и сформируйте из фарша продолговатые котлеты длиной 5-6 см.", "https://cdn.food.ru/unsigned/fit/640/480/ce/0/czM6Ly9tZWRpYS9waWN0dXJlcy8yMDI0MTIyNy9SYVdYNDMuanBlZw.webp"));
        steps4.add(new Step("Шаг 4: Налейте в сковороду масло, разогрейте его на среднем огне. Пожарьте котлеты с одной стороны в течение 5-6 минут до плотной коричневой корочки. Переверните их и поджарьте с другой стороны еще 5-6 минут до готовности. Переложите котлеты на тарелку.", "https://cdn.food.ru/unsigned/fit/640/480/ce/0/czM6Ly9tZWRpYS9waWN0dXJlcy8yMDI0MTIyNy8zN0tEeFEuanBlZw.webp"));



        // Настройка адаптера
        recipeAdapter = new RecipeAdapter(getContext(), recipeList);
        recyclerView.setAdapter(recipeAdapter);

        // Установка обработчика клика для элементов списка
        recipeAdapter.setOnItemClickListener(new RecipeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Recipe recipe) {
                Intent intent = new Intent(getContext(), RecipeDetailActivity.class);
                intent.putExtra("imageUrl", recipe.getImageUrl());
                intent.putExtra("title", recipe.getTitle());
                intent.putExtra("description", recipe.getDescription());

                // Передаем ингредиенты по отдельности
                String[] ingredients = recipe.getIngredients();
                for (int i = 0; i < ingredients.length; i++) {
                    intent.putExtra("ingredient" + (i + 1), ingredients[i]);
                }

                // Передаем шаги
                List<Step> steps = recipe.getSteps();
                for (int i = 0; i < steps.size(); i++) {
                    intent.putExtra("stepText" + (i + 1), steps.get(i).getText());
                    intent.putExtra("stepImage" + (i + 1), steps.get(i).getImageUrl());
                }

                // Запускаем RecipeDetailActivity
                startActivity(intent);
            }
        });

        return view;
    }
}