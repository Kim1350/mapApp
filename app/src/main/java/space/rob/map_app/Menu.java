package space.rob.map_app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayoutStates;

public class Menu extends Activity {

    private long backPressedTime;
    private Toast backToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }
    public void extClick(View view) {
        ConstraintLayout cont_la = findViewById(R.id.la_2);
        Button btn_yes = findViewById(R.id.bt_yes);
        Button btn_no = findViewById(R.id.bt_no);
        ImageView img_btn = findViewById(R.id.button_exit);
        Animation b_back = AnimationUtils.loadAnimation(this, R.anim.btn_back);
        img_btn.startAnimation(b_back);
        cont_la.setVisibility(View.VISIBLE);
        btn_yes.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
        btn_no.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                cont_la.setVisibility(View.GONE);
            }
        });
    }

    public void gameClick(View view) {
        try {

            Intent intent = new Intent(Menu.this, QuizActivity.class);
            startActivity(intent);
            finish();
        } catch (Exception e){

        }
    }

    public void mapClick(View view) {
        try {

            Intent intent = new Intent(Menu.this, GameLevels.class);
            startActivity(intent);
            finish();
        } catch (Exception e){

        }

    }

    public void infClick(View view) {

        try {

            Intent intent = new Intent(Menu.this,Info.class);
            startActivity(intent);
            finish();
        } catch (Exception e){

        }
    }

    //Систетмная кнопка
    @Override
    public void onBackPressed() {
        if(backPressedTime + 2000 >System.currentTimeMillis())
        {
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(), "Нажмите еще раз чтобы выйти", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}