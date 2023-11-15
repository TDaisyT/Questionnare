package com.example.questionnare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class SignUpActivity  extends AppCompatActivity {

    private EditText emailSignin;
    private EditText passwordSignin;
    private EditText passwordAgain;

    private CheckBox checkBox;
    private Button singUpButton;
    private TextView loginRedirect;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_screen);

        emailSignin = findViewById(R.id.emailSignUp);
        passwordSignin = findViewById(R.id.passwordSignUp);
        passwordAgain = findViewById(R.id.passwordAgain);
        checkBox = findViewById(R.id.checkBox);
        singUpButton = findViewById(R.id.signUpButton);
        loginRedirect = findViewById(R.id.loginRedirect);


        singUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // todo
                //   elmentse az adatokat az adatbázisba
                //   esetleges hibaüzenetek (jelszó nem jó, van már ilyen felhasználó, checkbox hiány)
                //   sikeres regisztrációkor dob át a bejelentkezésre
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // vissza visz a bejelentkezéshez
        loginRedirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }



}
