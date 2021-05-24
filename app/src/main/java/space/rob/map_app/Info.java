package space.rob.map_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;

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

}