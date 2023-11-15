package com.example.questionnare;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.questionnare.Database.DatabaseManager;
import com.example.questionnare.UserHome.ProfileActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    private Qlist questionnaireList = new Qlist();
    private ProfileActivity profile = new ProfileActivity();

    private BottomNavigationView bottomNavigationView;



    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        DatabaseManager dbManager = new DatabaseManager(this);
        dbManager.open();
        dbManager.initializeQA();
        dbManager.close();

        bottomNavigationView = findViewById(R.id.bottomNav);

        //a home  képernyő defaultnak beállitja a kérdőivek listáját tartalmazó képernyőt (Qlist az activityje)
        getSupportFragmentManager().beginTransaction().replace(R.id.container, questionnaireList).commit();

        //jó gombhoz jó képernyőt hozzon be
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                if (item.getItemId() == R.id.home) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, questionnaireList).commit();
                    return true;
                } else if (item.getItemId() == R.id.profile) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, profile).commit();
                    return true;
                }
                return false;
            }
        });

    }


}
