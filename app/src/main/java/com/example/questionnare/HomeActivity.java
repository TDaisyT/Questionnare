package com.example.questionnare;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class HomeActivity extends AppCompatActivity {
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    Qlist mylist = new Qlist();

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        DatabaseManager dbManager = new DatabaseManager(this);
        dbManager.open();
        dbManager.initializeQA();
        dbManager.close();
        fragmentTransaction.replace(R.id.container, mylist);
        fragmentTransaction.commit();
    }


}
