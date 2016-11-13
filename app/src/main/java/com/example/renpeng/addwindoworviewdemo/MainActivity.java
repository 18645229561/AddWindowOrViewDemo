package com.example.renpeng.addwindoworviewdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    View view;

    TextView textView;
    WindowManager windowManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = findViewById(android.R.id.content);
        textView = (TextView) findViewById(R.id.test);
        windowManager = getWindowManager();
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initShowView();
            }
        });
    }

    public void initShowView(){
        final TextView textView = new TextView(this);
        textView.setBackgroundColor(Color.BLUE);
        textView.setText("FDFDFDFDF");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"fdsfadsf",Toast.LENGTH_SHORT).show();
            }
        });
        textView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == KeyEvent.KEYCODE_BACK){
                    windowManager.removeView(textView);
                }
                return false;
            }
        });

        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        IBinder iBinder = view.getWindowToken();
        params.type = WindowManager.LayoutParams.TYPE_APPLICATION_PANEL;
        params.token = iBinder;
        params.width = 200;
        params.height = 50;
        params.gravity = Gravity.CENTER;
        windowManager.addView(textView,params);

    }
}
