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

public class QuizActivity extends Activity {

    RichPathView richPathView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
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
    //системная кнопка назад
    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(QuizActivity.this, Menu.class);
        startActivity(intent);
        finish();
    }
}