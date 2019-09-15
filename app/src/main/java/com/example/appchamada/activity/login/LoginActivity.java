package com.example.appchamada.activity.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appchamada.R;
import com.example.appchamada.activity.home.HomeActivity;

public class LoginActivity extends Activity {

    private LinearLayout logo;
    private EditText etUser, etPassword;
    private Button btLogin;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        logo = findViewById(R.id.linear_image_logo);

        etUser = findViewById(R.id.et_usuer);
        etPassword = findViewById(R.id.et_login);
        btLogin = findViewById(R.id.bt_login);
        progressBar = findViewById(R.id.progressBar);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressBar.setVisibility(View.VISIBLE);
                btLogin.setVisibility(View.GONE);

                if (!etUser.getEditableText().toString().isEmpty() && !etPassword.getEditableText().toString().isEmpty()) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                            startActivity(intent);
                            progressBar.setVisibility(View.GONE);
                            btLogin.setVisibility(View.VISIBLE);
                            finish();

                        }
                    },2000);


                } else {
                    Toast.makeText(LoginActivity.this, "É necessario informar os dados.", Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                    btLogin.setVisibility(View.VISIBLE);
                }
            }
        });


        logo.animate().translationY(-200).setDuration(1000);
        logo.animate().alpha(1).setDuration(400).setInterpolator(new AccelerateInterpolator()).start();
    }
}
