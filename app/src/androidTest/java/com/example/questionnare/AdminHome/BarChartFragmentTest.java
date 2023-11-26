package com.example.questionnare.AdminHome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.questionnare.R;

public class BarChartFragmentTest extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bar_chart, container, false);

        // TODO: Adatbázisból való adatok kinyerése és a nézet feltöltése
        fetchDataAndPopulateChart(view);

        return view;
    }

    private void fetchDataAndPopulateChart(View view) {
        // TODO: Adatok kinyerése az adatbázisból vagy más forrásból
        String dataFromDatabase = "Ez egy példa adat adatbázisból";

        // TODO: A példa adatokat beállítani a nézeten található elemre (például TextView)
        TextView chartDataTextView = view.findViewById(R.id.barChart);
        chartDataTextView.setText(dataFromDatabase);
    }
}

