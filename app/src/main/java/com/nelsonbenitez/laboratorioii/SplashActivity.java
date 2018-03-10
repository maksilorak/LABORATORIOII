package com.nelsonbenitez.laboratorioii;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {
    private static  final long SPLASH_DELAY=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); //establece el modo de la pantalla
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE); // no app bar
        setContentView(R.layout.activity_splash);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent uno =new Intent().setClass(SplashActivity.this,LogginActivity.class);
                uno.putExtra("usuario","");
                uno.putExtra("contrasena","");
                uno.putExtra("email","");
                startActivity(uno);
                finish();
            }
        };

        Timer tiempo = new Timer();
        tiempo.schedule(task,SPLASH_DELAY);
    }
}
