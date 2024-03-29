package com.example.questionnare;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.questionnare.Database.DatabaseManager;


public class SignUpActivity  extends AppCompatActivity {

    private EditText emailSignin;
    private EditText passwordSignin;
    private EditText passwordAgain;
    private CheckBox checkBox;
    private DatabaseManager dbManager;
    private boolean validEmail=true;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_screen);
        dbManager = new DatabaseManager(this); // Inicializálás
        dbManager.open();
        emailSignin = findViewById(R.id.emailSignUp);
        passwordSignin = findViewById(R.id.passwordSignUp);
        passwordAgain = findViewById(R.id.passwordAgain);
        checkBox = findViewById(R.id.checkBox);
        Button singUpButton = findViewById(R.id.signUpButton);
        TextView loginRedirect = findViewById(R.id.loginRedirect);




        singUpButton.setOnClickListener(view -> {
            String email =emailSignin.getText().toString();
            String password = passwordSignin.getText().toString();
            String passwordagain = passwordAgain.getText().toString();
            //ha már van az adatbázisban ilyen e-mail címre felhasználó, nem enged regisztrálni
            if(dbManager.checkEmail(email)){
                Toast.makeText(SignUpActivity.this, "This account already exists", Toast.LENGTH_SHORT).show();
                validEmail=false;
            }
            //ha nem egyezik a két jelszó, nem enged regisztrálni
            if(!password.equals(passwordagain)){
                Toast.makeText(SignUpActivity.this, "You entered different passwords", Toast.LENGTH_SHORT).show();
            }
            //ha nincs bepipálva, nem enged regisztrálni
            if(!checkBox.isChecked()){
                Toast.makeText(SignUpActivity.this, "You have to accept the terms of use", Toast.LENGTH_SHORT).show();
            }
            //csak akkor dob vissza a bejelentkező képernyőre ha megfelelőek az adatok
            //rögzíti az adatokat az adatbázisba
            if(validEmail && password.equals(passwordagain) && checkBox.isChecked()){
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                Toast.makeText(SignUpActivity.this, "Account creation was successful", Toast.LENGTH_SHORT).show();
                dbManager.addUser(email,password);
                dbManager.close();
                startActivity(intent);
            }

        });

        // vissza visz a bejelentkezéshez
        loginRedirect.setOnClickListener(view -> {
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
        });
    }



}
