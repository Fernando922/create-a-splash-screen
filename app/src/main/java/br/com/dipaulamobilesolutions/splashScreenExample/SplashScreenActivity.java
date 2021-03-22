package br.com.dipaulamobilesolutions.splashScreenExample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Handler handle = new Handler();
        SharedPreferences preferences = getSharedPreferences("user_preferences", MODE_PRIVATE);
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(preferences.contains("not_a_new_user")){
                    showHomeScreen();
                }else{
                    showLoginScreen();
                }
            }
        },2000);
    }

    private void showHomeScreen() {
        Intent intent = new Intent(SplashScreenActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    private void showLoginScreen() {
        Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}