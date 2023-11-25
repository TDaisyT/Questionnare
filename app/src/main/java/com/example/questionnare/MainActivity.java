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
        String[] answers = {"None", "None", "None", "None", "None", "None", "None", "None", "None", "None", "None", "None", "None", "None", "None"};
        dbManager.addResult(1, answers);
        dbManager.logResultTable();



        //dbManager.printUserTable();S


        //ha minden jó akkor megnyitja a home képernyőt
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email =userEmailET.getText().toString();
                String password = userPasswordET.getText().toString();
                if (dbManager.checkUser(email, password)) {
                    dbManager.close();
                    if(email.equals("admin@gmail.com")){
                        Toast.makeText(MainActivity.this, "Successfully logged in as the admin", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this, "Successfully logged in as "+email, Toast.LENGTH_SHORT).show();
                    }
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    intent.putExtra("email", email);
                    intent.putExtra("password", password);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Invalid e-mail/password combination", Toast.LENGTH_SHORT).show();
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