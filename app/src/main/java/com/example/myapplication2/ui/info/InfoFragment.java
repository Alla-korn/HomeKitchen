package com.example.myapplication2.ui.info;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication2.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class InfoFragment extends Fragment {

    private ListView listView;
    private ArrayAdapter<ArticleItem> articleAdapter;
    private ArrayList<ArticleItem> articleList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);

        listView = view.findViewById(R.id.list_view);

        // Инициализация списка статей
        articleList = new ArrayList<>();
        articleList.add(new ArticleItem("Чем заменить вредные продукты в своем рационе", "Чтобы забыть про фастфуд, чипсы, конфеты, майонез", "Есть много продуктов, которые не соответствуют принципам здорового питания. Конфеты, чипсы, жирные соусы, белый хлеб, майонез — все это приносит удовольствие, но не пользу. Как заменить вредную еду на здоровые аналоги, продолжая питаться вкусно и разнообразно. Нори вместо чипсов\n" +
                "Полезная замена классическим чипсам, пропитанным маслом, — хрустящие морские водоросли, запеченные в духовке. Они богаты йодом, каротиноидами, витаминами A, В, K и другими жизненно важными веществами. Разрежьте листы нори на небольшие полоски, треугольники или квадраты — удобно делать это ножницами. Для смазывания используйте кунжутное масло: оно содержит полиненасыщенные жирные кислоты омега-3 и омега-6, витамин E и аминокислоту тирозин, помогающую бороться со стрессом. Перед запеканием закуску можно посыпать солью, кунжутом, паприкой, сушеным чесноком или перцем чили. Запеченный батат вместо картофеля фри\n" +
                "Батат — вкусный аналог картофеля, богатый витамином А, калием и антиоксидантами — веществами, защищающими клетки организма от повреждений. Его можно приготовить с кожурой, достаточно тщательно почистить ее щеткой, чтобы удалить загрязнения. Запекайте батат с оливковым маслом и пряными травами: он получится хрустящим снаружи и мягким внутри. Посыпьте готовое блюдо пармезаном или подайте его с домашним чесночным соусом из греческого йогурта. ", "https://cdn.food.ru/unsigned/fit/640/480/ce/0/czM6Ly9tZWRpYS9waWN0dXJlcy8yMDI0MDMwMS9HV1Q3UW4uanBlZw.webp"));
        articleList.add(new ArticleItem("Чем полезны полифенолы", "И в каких продуктах содержатся", "Самый простой пример действия полифенолов — потемнение мякоти яблока на срезе. Именно эти элементы, а не железо, как принято считать, вступая в реакцию с кислородом из воздуха, меняют цвет фрукта. Однако дело не в эффектных «превращениях» яблока, а в питательной ценности полифенолов. В статье расскажем, что представляют собой эти вещества, в каких продуктах они содержатся и чем полезны для здоровья человека. Типы полифенолов, полезных для здоровья\n" +
                "Существует множество разновидностей полифенолов, которые содержатся в различных растительных продуктах. Основные группы фитосоединений, необходимых для здоровья:\n" +
                "фенольные кислоты — галловая, кофейная, эллаговая и их производные;\n" +
                "флавоноиды — пигменты антоцианы, антиоксиданты катехины, другие элементы;\n" +
                "лигнаны — вещества с противоопухолевым эффектом;\n" +
                "стильбены — соединения с антиокислительным действием.\n" +
                "Полифенолы одних групп содержатся в большинстве растений в разной концентрации, другие есть в ограниченном количестве продуктов. Например, фенольные кислоты и флавоноиды имеются практически во всех свежих овощах и фруктах. Полифенолов лигнанов много в семенах кунжута, льна, лимонника китайского и в корнях элеутерококка. Стильбены содержатся в чернике, винограде, орехах.", "https://cdn.food.ru/unsigned/fit/640/480/ce/0/czM6Ly9tZWRpYS9waWN0dXJlcy8yMDI1MDExNS8zaWhyU1UuanBlZw.webp"));
        articleList.add(new ArticleItem("Какой напиток выбрать для тренировки", "Изотоник, воду или протеиновый коктейль", "Во время активных физических нагрузок важно поддерживать водно-солевой баланс организма, употребляя достаточно жидкости. Обычная вода утоляет жажду, но не всегда может восполнить потерянные вместе с потом микроэлементы. Для этого необходимы изотоники. В статье разберемся, какие напитки можно пить в течение тренировки и после нее.", "https://cdn.food.ru/unsigned/fit/640/480/ce/0/czM6Ly9tZWRpYS9waWN0dXJlcy8yMDI0MDIwOC8zWWJxcXYuanBlZw.webp"));
        // Добавьте больше статей по вашему желанию

        articleAdapter = new ArrayAdapter<ArticleItem>(getContext(), R.layout.item_article, articleList) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                if (convertView == null) {
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_article, parent, false);
                }

                ArticleItem article = getItem(position);

                TextView titleTextView = convertView.findViewById(R.id.article_title);
                TextView descriptionTextView = convertView.findViewById(R.id.article_description);
                ImageView imageView = convertView.findViewById(R.id.article_image);

                titleTextView.setText(article.getTitle());
                descriptionTextView.setText(article.getDescription());
                Picasso.get().load(article.getImageUrl()).into(imageView); // Загрузка изображения с помощью Picasso

                return convertView;
            }
        };

        listView.setAdapter(articleAdapter);

        // Установка слушателя нажатий на элементы списка
        listView.setOnItemClickListener((parent, view1, position, id) -> {
            ArticleItem article = articleList.get(position);
            Intent intent = new Intent(getActivity(), ArticleDetailActivity.class);
            intent.putExtra("title", article.getTitle());
            intent.putExtra("content", article.getContent());
            intent.putExtra("imageUrl", article.getImageUrl()); // Передаем URL изображения
            startActivity(intent);
        });

        return view;
    }
}
