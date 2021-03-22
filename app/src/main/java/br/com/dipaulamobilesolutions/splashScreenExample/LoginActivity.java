package br.com.dipaulamobilesolutions.splashScreenExample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button signIn = findViewById(R.id.signInButton);


        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveLoginState();


                goToHome();
            }
        });
    }

    private void goToHome() {
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    private void saveLoginState() {
        SharedPreferences preferences = getSharedPreferences("user_preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("not_a_new_user", true);
        editor.commit();
    }
}