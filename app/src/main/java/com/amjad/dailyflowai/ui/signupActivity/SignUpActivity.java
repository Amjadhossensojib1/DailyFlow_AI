package com.amjad.dailyflowai.ui.signupActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.amjad.dailyflowai.DashboardActivity;
import com.amjad.dailyflowai.R;
import com.amjad.dailyflowai.ui.loginAcivity.LoginActivity;

public class SignUpActivity extends AppCompatActivity {
    private TextView tvLogin;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        tvLogin = findViewById(R.id.tv_login);
        btnSignUp = findViewById(R.id.btn_sign_up);

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));

            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, DashboardActivity.class));
            }
        });

    }
}