package com.amjad.dailyflowai.ui.loginAcivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.amjad.dailyflowai.DashboardActivity;
import com.amjad.dailyflowai.R;
import com.amjad.dailyflowai.ui.signupActivity.SignUpActivity;

public class LoginActivity extends AppCompatActivity {
    private TextView tvcreateAccount;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvcreateAccount = findViewById(R.id.tv_creaate_account);
        btnLogin = findViewById(R.id.btn_sign_in);

        tvcreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
            }
        });

    }
}