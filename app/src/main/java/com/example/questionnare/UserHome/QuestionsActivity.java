package com.example.questionnare.UserHome;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.questionnare.Database.DatabaseHelper;
import com.example.questionnare.Database.DatabaseManager;
import com.example.questionnare.MainActivity;
import com.example.questionnare.R;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class QuestionsActivity extends AppCompatActivity {
    private DatabaseManager dbManager; // DatabaseManager példánya
    private ListView listView;
    private Button SubmitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        listView = findViewById(R.id.list_questions);

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

        // Set a click listener for the "Save" button
        Button submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (areAllRadioButtonsChecked()) {
                    saveAnswers();
                    Toast.makeText(QuestionsActivity.this, "Answers submitted successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(QuestionsActivity.this, "Please answer all questions", Toast.LENGTH_SHORT).show();
                }
            }
        });

        dbManager.close();

    }
    //Ellenőrzi, hogy kitöltötte-e az összes kérdést
    private boolean areAllRadioButtonsChecked() {
        for (int i = 0; i < listView.getCount(); i++) {
            View listItem = listView.getChildAt(i);
            RadioGroup radioGroup = listItem.findViewById(R.id.optionsRadioGroup);
            if (radioGroup.getCheckedRadioButtonId() == -1) {
                return false;
            }
        }
        return true;
    }

    //Elmenti a válaszokat az adatbázisba
    private void saveAnswers() {
        dbManager.open();
        /*
        to do- idk if it works tbh so ill just leave it here
        String email = getIntent().getStringExtra("email");
        int id = dbManager.getUserId(email);
        System.out.println(id);
        String answers [] = new String [listView.getCount()];
        for (int i = 0; i < listView.getCount(); i++) {
            View listItem = listView.getChildAt(i);
            RadioGroup radioGroup = listItem.findViewById(R.id.optionsRadioGroup);
            int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();

            if (selectedRadioButtonId != -1) {
                RadioButton selectedRadioButton = listItem.findViewById(selectedRadioButtonId);

                // Get question ID and selected answer text
                //String question = ((TextView) listItem.findViewById(R.id.questionTextView)).getText().toString();
                String selectedAnswer = selectedRadioButton.getText().toString();
                answers[i]=selectedAnswer;
            }
        }
        dbManager.addResult(id,answers[0],answers[1],answers[2],answers[3],answers[3],answers[4],answers[5],answers[6],answers[7],answers[8],answers[9],answers[10],answers[11],answers[12],answers[13]);
        */
        dbManager.close();
    }
}