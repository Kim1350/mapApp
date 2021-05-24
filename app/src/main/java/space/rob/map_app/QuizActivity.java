package space.rob.map_app;

import android.content.Intent;
import android.os.Bundle;

import com.richpath.RichPath;
import com.richpath.RichPathView;
import com.richpathanimator.RichPathAnimator;
import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import org.w3c.dom.Text;


public class QuizActivity extends Activity {

    boolean canClick = true;

    RichPathView richPathView;

    String[] regionNumbers = {"Region_1", "Region_2", "Region_3", "Region_4",
            "Region_5", "Region_6", "Region_7", "Region_8", "Region_9",
            "Region_10", "Region_11", "Region_12", "Region_13", "Region_14",
            "Region_15", "Region_16", "Region_17", "Region_18", "Region_19",
            "Region_20", "Region_21", "Region_22", "Region_23", "Region_24",
            "Region_25", "Region_26", "Region_27", "Region_28", "Region_29",
            "Region_30", "Region_31", "Region_32", "Region_32", "Region_33",
            "Region_34", "Region_35"};

    String[] regions = {"Абыйский улус", "Алданский улус", "Аллаиховский улус", "Амгинский улус", "Анабарский национальный (долгано-эвенкийский) улус",
            "Булунский улус", "Верхневилюйский улус", "Верхнеколымский улус", "Верхоянский улус", "Вилюйский улус",
            "Горный улус", "Жиганский национальный эвенкийский улус", "Кобяйский улус", "Ленский улус", "Мегино-Кангаласский улус",
            "Мирнинский район", "Момский национальный эвенский улус", "Намский улус", "Нерюнгринский улус", "Нижеколымский улус",
            "Нюрбинский улус", "Оймяконский улус", "Оленекский эвенкийский национальный улус", "Олекминский улус", "Среднеколымский улус",
            "Сунтарский улус", "Таттинский улус", "Томпонский улус", "Усть-Алданский улус", "Усть-Майский улус",
            "Усть-Янский улус", "Хангаласский улус", "Чурапчинский улус", "Эвено-Бытантайский национальный улус", "город Якутск"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        TextView textView = findViewById(R.id.txtNextRegion);
        int randomNumber = (int)((Math.random() * (34 - 0)) + 0);
        textView.setText("Найдите " + regions[randomNumber]);

        ConstraintLayout constraintLayout = findViewById(R.id.playAgain);
        TextView txtPlayAgain = findViewById(R.id.txtPlayAgain);

        richPathView = findViewById(R.id.map);
        richPathView.setOnPathClickListener(new RichPath.OnPathClickListener() {
            @Override
            public void onClick(RichPath richPath) {
                if (richPath.getName().equals(regionNumbers[randomNumber]) && canClick) {
                    canClick = false;
                    txtPlayAgain.setText("Поздравляем! Вы нашли " + regions[randomNumber] +"! Хотите сыграть еще раз?");
                    constraintLayout.setVisibility(View.VISIBLE);


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
                } else if (!richPath.getName().equals(regionNumbers[randomNumber]) && canClick) {
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

    public void PlayAgain(View view) {
        finish();
        startActivity(getIntent());
    }

    public void EndGame(View view) {
        Intent intent = new Intent(QuizActivity.this, Menu.class);
        startActivity(intent);
        finish();
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