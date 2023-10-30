package com.example.questionnare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText userEmailET;
    private EditText userPasswordET;
    private Button LoginButton;

    private TextView signInRedirect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        userEmailET = findViewById(R.id.emailLogin);
        userPasswordET = findViewById(R.id.passwordLogin);
        LoginButton = findViewById(R.id.loginButton);
        signInRedirect = findViewById(R.id.signinRedirect);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email =userEmailET.getText().toString();
                String password = userPasswordET.getText().toString();

                setContentView(R.layout.home_screen);
            }
        });

        signInRedirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.signup_screen);
            }
        });


    }


}