package com.example.questionnare;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        DatabaseManager dbManager = new DatabaseManager(this);
        dbManager.open();
        dbManager.initializeQA();
/*JUST FOR CHECKING:
        Cursor cursor = dbManager.queryDatabase("SELECT * FROM " + DatabaseHelper.TABLE_QA);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_ID));
                String question = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_QUESTION));
                String answer1 = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_ANSWER1));
                String answer2 = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_ANSWER2));
                String answer3 = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_ANSWER3));
                String answer4 = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_ANSWER4));
                Log.d("DatabaseContent", "ID: " + id + ", Question: " + question);
                Log.d("DatabaseContent", "Answer 1: " + answer1);
                Log.d("DatabaseContent", "Answer 2: " + answer2);
                Log.d("DatabaseContent", "Answer 3: " + answer3);
                Log.d("DatabaseContent", "Answer 4: " + answer4);
            }
            cursor.close();
        }*/
        dbManager.close();
    }


}
