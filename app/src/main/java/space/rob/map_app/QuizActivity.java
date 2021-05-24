package space.rob.map_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.richpath.RichPath;
import com.richpath.RichPathView;
import com.richpathanimator.RichPathAnimator;

public class QuizActivity extends AppCompatActivity {

    RichPathView richPathView;

    String[] regionNumbers = {"Region_1", "Region_2", "Region_3", "Region_4",
            "Region_5", "Region_6", "Region_7", "Region_8", "Region_9",
            "Region_10", "Region_11", "Region_12", "Region_13", "Region_14",
            "Region_15", "Region_16", "Region_17", "Region_18", "Region_19",
            "Region_20", "Region_21", "Region_22", "Region_23", "Region_24",
            "Region_25", "Region_26", "Region_27", "Region_28", "Region_29",
            "Region_30", "Region_31", "Region_32", "Region_32", "Region_33",
            "Region_34"};

    String[] regions = {"Абыйский", "Алданский", "Аллаиховский", "Амгинский", "Анабарский",
            "Булунский", "Верхневилюйский", "Верхнеколымский", "Верхоянский", "Вилюйский",
            "Горный", "Жиганский", "Кобяйский", "Ленский", "Мегино-Кангаласский",
            "Мирный", "Момский", "Намский", "Нерюнгринский", "Нижеколымский",
            "Нюрбинский", "Оймяконский", "Олененский", "", "",
            "", "", "", "", "",
            "", "", "", "", "",
            "", "", "", "", ""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        richPathView = findViewById(R.id.map);
        richPathView.setOnPathClickListener(new RichPath.OnPathClickListener() {
            @Override
            public void onClick(RichPath richPath) {
                if (richPath.getName().equals("Region_16")) {
                    RichPathAnimator.animate(richPath)
                            .fillColor((255 & 0xff) << 24 | (128 & 0xff) << 16 | (50 & 0xff) << 8 | (50 & 0xff))
                            .start();
                }
            }
        });
    }
}