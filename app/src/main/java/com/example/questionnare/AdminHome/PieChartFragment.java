package com.example.questionnare.AdminHome;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.questionnare.R;


public class PieChartFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pie_chart, container, false);

        // todo oda adni a chart-nak az adatbázisból kiszedet adatokat
    }
}