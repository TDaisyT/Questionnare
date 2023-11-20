package com.example.questionnare.AdminHome;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.questionnare.R;
import com.github.mikephil.charting.charts.PieChart;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

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
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                if (item.getItemId() == R.id.barChartButton) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, barChartFragment).commit();
                    return true;
                } else if (item.getItemId() == R.id.pieChartButton) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, pieChartFragment).commit();
                    return true;
                }
                return false;
            }
        });
    }
}