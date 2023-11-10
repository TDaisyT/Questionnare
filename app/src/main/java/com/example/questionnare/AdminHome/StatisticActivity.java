package com.example.questionnare.AdminHome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.questionnare.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class StatisticActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    private PieChartFragment pieChartFragment;
    private BarChartFragment barChartFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);

        bottomNavigationView = findViewById(R.id.bottomNav);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, barChartFragment).commit();

        // todo
        //  megcsinálni h a lent lévő gombokra kattintva jó képernyőt hozzon be
        //  lényegében kimásolni a HomeActivityből a setOnItemSelectedListener
        //  csak az id ket kicserélni 'home' és 'profil' helyet 'barChartButton' re és 'pieCharButton'ra
        //  és átirni a megnyitandó képernyő nevét
    }
}