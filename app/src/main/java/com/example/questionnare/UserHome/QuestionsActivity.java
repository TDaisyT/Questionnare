package com.example.questionnare.UserHome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.questionnare.R;

public class QuestionsActivity extends AppCompatActivity {

    //todo
    // jelenjenek meg a kérdések listviewben
    // adott válaszok elmentése mentés gombra kattintáskor
    // ne engedjen menteni hiányos kitöltésnél
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
    }
}