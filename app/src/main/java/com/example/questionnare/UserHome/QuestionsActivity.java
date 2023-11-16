package com.example.questionnare.UserHome;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;

import com.example.questionnare.Database.DatabaseHelper;
import com.example.questionnare.Database.DatabaseManager;
import com.example.questionnare.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class QuestionsActivity extends AppCompatActivity {
    private DatabaseManager dbManager; // DatabaseManager példánya



    //todo
    // adott válaszok elmentése mentés gombra kattintáskor
    // ne engedjen menteni hiányos kitöltésnél
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        ListView listView = findViewById(R.id.list_questions);

        // Kérjük le a kérdéseket és válaszokat a DatabaseManager-ből
        dbManager = new DatabaseManager(this);
        dbManager.open();
        Cursor cursor = dbManager.getQAData();



        // Ellenőrizzük, hogy a cursor nem üres és van adat a táblában
        if (cursor != null && cursor.moveToFirst()) {
            // Létrehozunk egy listát az adatok tárolására
            List<Map<String, String>> questionList = new ArrayList<>();

            // A cursor bejárása és az adatok hozzáadása a listához
            do {
                Map<String, String> questionData = new HashMap<>();
                questionData.put("question", cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_QUESTION)));
                questionData.put("answer1", cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_ANSWER1)));
                questionData.put("answer2", cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_ANSWER2)));
                questionData.put("answer3", cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_ANSWER3)));
                questionData.put("answer4", cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_ANSWER4)));

                // a kérdés és a válaszok hozzáadása a listához
                questionList.add(questionData);
            } while (cursor.moveToNext());
            // Létrehozok egy SimpleAdapter-t, hogy az adatokat hozzárendeljük a ListView-hoz
            SimpleAdapter adapter = new SimpleAdapter(this, questionList, R.layout.question_list,
                    new String[]{"question", "answer1", "answer2", "answer3", "answer4"},
                    new int[]{R.id.questionTextView, R.id.option1RadioButton, R.id.option2RadioButton, R.id.option3RadioButton, R.id.option4RadioButton});

            // Összekapcsolja SimpleAdapter-t a ListView-val
            listView.setAdapter(adapter);
        }

        // Cursor lezárása
        if (cursor != null) {
            cursor.close();
        }




        dbManager.close();
    }
}