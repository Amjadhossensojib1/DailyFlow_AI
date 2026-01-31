package com.amjad.dailyflowai.ui.onboardActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.amjad.dailyflowai.ui.loginAcivity.LoginActivity;
import com.amjad.dailyflowai.R;
import com.amjad.dailyflowai.ui.signupActivity.SignUpActivity;

public class OnboardActivity extends AppCompatActivity {
    private Button btnSignIn,btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboard);

        btnSignIn = findViewById(R.id.signInButton);
        btnSignUp = findViewById(R.id.signUpButton);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OnboardActivity.this, LoginActivity.class));
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OnboardActivity.this, SignUpActivity.class));
            }
        });


    }
}