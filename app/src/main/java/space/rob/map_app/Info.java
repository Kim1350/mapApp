package space.rob.map_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;

public class Info extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        WebView webView = findViewById(R.id.webView);
        webView.loadUrl("file:///android_asset/info.html");
        

    }
    //Системная кнопка
    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(Info.this, Menu.class);
        startActivity(intent);
        finish();
    }

    public void info_back(View view) {
        ImageView img_btn = findViewById(R.id.btn_info_back);
        Animation b_back = AnimationUtils.loadAnimation(this, R.anim.btn_back);
        img_btn.startAnimation(b_back);
        Intent intent = new Intent(Info.this, Menu.class);
        startActivity(intent);
        finish();
    }
}