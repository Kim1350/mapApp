package space.rob.map_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class GameLevels extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelevels);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button btn_back = (Button)findViewById(R.id.btn_back);
        
    }
    //Системная кнопка
    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(GameLevels.this, Menu.class);
        startActivity(intent);
        finish();
    }

    public void back_click(View view) {
        Intent intent = new Intent(GameLevels.this, Menu.class);
        startActivity(intent);
        finish();
    }
}