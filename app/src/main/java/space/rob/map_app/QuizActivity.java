package space.rob.map_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.richpath.RichPath;
import com.richpath.RichPathView;
import com.richpathanimator.RichPathAnimator;

public class QuizActivity extends AppCompatActivity {

    RichPathView richPathView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        richPathView = findViewById(R.id.map);
        richPathView.setOnPathClickListener(new RichPath.OnPathClickListener() {
            @Override
            public void onClick(RichPath richPath) {
                if (richPath.getName().equals("Mirny")) {
                    RichPathAnimator.animate(richPath)
                            .fillColor((255 & 0xff) << 24 | (255 & 0xff) << 16 | (0 & 0xff) << 8 | (0 & 0xff))
                            .start();
                }
            }
        });
    }
}