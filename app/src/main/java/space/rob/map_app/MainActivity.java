package space.rob.map_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
public class MainActivity extends Activity {

    MediaPlayer mpl;
    ImageView ea;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mpl = MediaPlayer.create(this, R.raw.musc_bckg);
        mpl.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopPlay();
            }
        });
        mpl.start();
        mpl.setVolume(0.2f,0.2f);
        ea = (ImageView) findViewById(R.id.earth);
        Animation an;
        an = AnimationUtils.loadAnimation(this, R.anim.earth_anim);
        ea.startAnimation(an);
        Button buttonStart = (Button) findViewById(R.id.button_start);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    stopPlay();
                    Intent intent = new Intent(MainActivity.this, Menu.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e){

                }
            }
        });
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }
    private void stopPlay() {
        mpl.stop();
        try {
            mpl.prepare();
            mpl.seekTo(0);
        } catch (Throwable t) {
        }
    }
    public void stop(View view){
        stopPlay();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mpl.isPlaying())
        {
            stopPlay();
        }
    }
}