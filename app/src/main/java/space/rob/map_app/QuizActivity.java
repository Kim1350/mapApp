package space.rob.map_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.richpath.RichPath;
import com.richpath.RichPathView;
import com.richpathanimator.RichPathAnimator;
import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;


public class QuizActivity extends Activity {

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
            "Нюрбинский", "Оймяконский", "Оленекский", "Олекминский", "Среднеколымский",
            "Сунтарский", "Таттинский", "Томпонский", "Усть-Алданский", "Усть-Майский",
            "Усть-Янский", "Хангаласский", "Чурапчинский", "Эвено-Бытантайский"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        TextView textView = findViewById(R.id.txtNextRegion);
        int randomNumber = (int)((Math.random() * (34 - 0)) + 0);
        textView.setText(regions[randomNumber]);

        richPathView = findViewById(R.id.map);
        richPathView.setOnPathClickListener(new RichPath.OnPathClickListener() {
            @Override
            public void onClick(RichPath richPath) {
                if (richPath.getName().equals(regionNumbers[randomNumber])) {
                    if(richPath.getName().equals("Region_6")) {
                        for(int i = 0; i < 15; i++) {
                            RichPath richPathRegion6 = richPathView.findRichPathByIndex(i);
                            RichPathAnimator.animate(richPathRegion6)
                                    .fillColor((255 & 0xff) << 24 | (50 & 0xff) << 16 | (128 & 0xff) << 8 | (50 & 0xff))
                                    .start();
                        }
                    } else {
                        RichPathAnimator.animate(richPath)
                                .fillColor((255 & 0xff) << 24 | (50 & 0xff) << 16 | (128 & 0xff) << 8 | (50 & 0xff))
                                .start();
                    }
                } else if (!richPath.getName().equals(regionNumbers[randomNumber])) {
                    if(richPath.getName().equals("Region_6")) {
                        for(int i = 0; i < 15; i++) {
                            RichPath richPathRegion6 = richPathView.findRichPathByIndex(i);
                            RichPathAnimator.animate(richPathRegion6)
                                    .fillColor((255 & 0xff) << 24 | (128 & 0xff) << 16 | (50 & 0xff) << 8 | (50 & 0xff))
                                    .start();
                        }
                    } else {
                        RichPathAnimator.animate(richPath)
                                .fillColor((255 & 0xff) << 24 | (128 & 0xff) << 16 | (50 & 0xff) << 8 | (50 & 0xff))
                                .start();
                    }
                }
            }
        });
    }
    //системная кнопка назад
    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(QuizActivity.this, Menu.class);
        startActivity(intent);
        finish();
    }
}