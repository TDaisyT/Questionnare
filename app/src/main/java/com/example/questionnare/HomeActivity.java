package com.example.questionnare;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.questionnare.Database.DatabaseManager;
import com.example.questionnare.UserHome.ProfileActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    private final FragmentManager fragmentManager = getSupportFragmentManager();
    private final Qlist questionnaireList = new Qlist();
    private final ProfileActivity profile = new ProfileActivity();


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        DatabaseManager dbManager = new DatabaseManager(this);
        dbManager.open();
        dbManager.initializeQA();
        dbManager.close();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);

        //a home  képernyő defaultnak beállitja a kérdőivek listáját tartalmazó képernyőt (Qlist az activityje)
        getSupportFragmentManager().beginTransaction().replace(R.id.container, questionnaireList).commit();

        //jó gombhoz jó képernyőt hozzon be
        bottomNavigationView.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.home) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, questionnaireList).commit();
                return true;
            } else if (item.getItemId() == R.id.profile) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, profile).commit();
                return true;
            }
            return false;
        });

    }


}
