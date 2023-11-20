package com.example.questionnare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.questionnare.Database.DatabaseManager;

public class MainActivity extends AppCompatActivity {

    private EditText userEmailET;
    private EditText userPasswordET;
    private Button LoginButton;
    private TextView signInRedirect;
    private DatabaseManager dbManager; // DatabaseManager példánya


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        userEmailET = findViewById(R.id.emailLogin);
        userPasswordET = findViewById(R.id.passwordLogin);
        LoginButton = findViewById(R.id.loginButton);
        signInRedirect = findViewById(R.id.signinRedirect);
        dbManager = new DatabaseManager(this); // Inicializálás
        dbManager.open();
        dbManager.addAdmin();
        dbManager.addResult(1, "None", "None", "None", "None", "None", "None", "None", "None", "None", "None", "None", "None", "None", "None", "None");
        dbManager.logResultTable();

        //dbManager.printUserTable();


        //ha minden jó akkor megnyitja a home képernyőt
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email =userEmailET.getText().toString();
                String password = userPasswordET.getText().toString();
                // todo mikor engedje a bejelentkezést
                if (dbManager.checkUser(email, password)) {
                    dbManager.close();
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    intent.putExtra("email", email);
                    intent.putExtra("password", password);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Incorrect e-mail/password combination", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //átirányitás a regisztráció képernyőre
        signInRedirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });


    }


}