package com.example.questionnare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.sql.SQLDataException;

public class DatabaseManager {
    private DatabaseHelper dbHelper;//Adatbázis sémát kezelő segédosztály
    private Context context;//Alkalmazás kontexusa
    private SQLiteDatabase database;//Aktuális adatbázis

    public DatabaseManager(Context c) {
        context = c;
    }

    public DatabaseManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();//initialiazed the database instance by accessing the database->Az adatbázis írásra való megnyitása
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    // Felhasználók kezelése

    // Új felhasználó hozzáadása az "users" táblához
    public void addUser(String email, String password) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COL_EMAIL, email);
        values.put(DatabaseHelper.COL_PASSWORD, password);
        long insertedUsers = database.insert(DatabaseHelper.TABLE_USERS, null, values);//(melyik tálba,
        // null mert használunk spec feltételeket agy null értéket, paraméter/ContentValues objektum ami beszúrásra kerül)
        //egy adatbázisban történő beszúrást hajt végre, és visszaadja a beszúrt sor azonosítóját, amely egy long érték
        if(insertedUsers==-1){
            Log.d("DatabaseManager","Error: The user wasn't inserted into the database");
        }
    }

    // Felhasználó ellenőrzése az email és jelszó alapján (azaz benne van már-e az adatbázisban)
    public boolean checkUser(String email, String password) {
        String[] columns = { DatabaseHelper.COL_ID };
        String selection = DatabaseHelper.COL_EMAIL + " = ? AND " + DatabaseHelper.COL_PASSWORD + " = ?";//leellenőrzi hogy a ?, vagyis ami selectionArgs-ba
        //lesz, az megegyezik-e.
        String[] selectionArgs = { email, password };
        Cursor cursor = database.query(DatabaseHelper.TABLE_USERS, columns, selection, selectionArgs, null, null, null);
        //a database.query lényegében egy adatbázis lekérdezés, ahol a user táblát a megadott oszlopokkal, szűrési feltétellel és argumentumokkal kéri le.
        //Cursor objektumba van tárolva, hogy be tudjuk járni az eredményhalmazt
        boolean userExists = (cursor.getCount() > 0);
        cursor.close();
        return userExists;
    }

    // Kérdések és válaszok kezelése

    // Új kérdés és válaszok hozzáadása a "qa" táblához
    public void addQA(String question, String answer1, String answer2, String answer3, String answer4) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COL_QUESTION, question);
        values.put(DatabaseHelper.COL_ANSWER1, answer1);
        values.put(DatabaseHelper.COL_ANSWER2, answer2);
        values.put(DatabaseHelper.COL_ANSWER3, answer3);
        values.put(DatabaseHelper.COL_ANSWER4, answer4);
        long insertedQA = database.insert(DatabaseHelper.TABLE_QA, null, values);
        if(insertedQA==-1){
            Log.d("DatabaseManager","Error: The question and answers weren't inserted into the database");
        }
    }

    //ezen majd valószínűleg változtatni kell majd, hogy ellenőrizze hogy minden kérdésre válaszol a felhasználó, nem csak egyre->TODO
    public void addResult(int userId, int qaId, String finalAnswer) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COL_USERS_ID, userId);
        values.put(DatabaseHelper.COL_QA_ID, qaId);
        values.put(DatabaseHelper.COL_FINAL_ANSWER, finalAnswer);
        long insertedResult = database.insert(DatabaseHelper.TABLE_RESULT, null, values);
        if(insertedResult==-1){
            Log.d("DatabaseManager","Error: The results weren't inserted into the database");
        }
    }


    public Cursor queryDatabase(String query) {
        return database.rawQuery(query, null);
    }


    public void deleteAllQA() {
        database.delete(DatabaseHelper.TABLE_QA, null, null);
    }

    public boolean isQAInDatabase(String question) {
        String[] columns = { DatabaseHelper.COL_ID };
        String selection = DatabaseHelper.COL_QUESTION + " = ?";
        String[] selectionArgs = { question };
        Cursor cursor = database.query(DatabaseHelper.TABLE_QA, columns, selection, selectionArgs, null, null, null);
        boolean qaExists = (cursor.getCount() > 0);
        cursor.close();
        return qaExists;
    }
    public void initializeQA() {
        String[] questions = {
                "What is your major?",
                "Are you satisfied with the teaching staff and their teaching methods?",
                "Are you satisfied with the equipment the university offers?",
                "How likely are you to continue attending this college next year?",
                "How likely are you to continue your studies with a master's degree?",
                "How likely are you to complete a different major in our university?",
                "How many hours a week do you work your part-time job?",
                "Do you plan to work in a similiar field as your major?",
                "How likely are you to recommend this college to your friends and family?",
                "Do you think that your university created a safe environment for your studies?",
                "What are your views on the extracurricular activities carried out in this college?",
                "Where do you live during your university studies",
                "What is your overall experience with your major in our university?",
                "What is your overall experience with the university?",
                "What do you think we should work on more to create a better university experience?"
        };

        String[][] answers = {
                { "IT Programs", "Agriculture Programs", "Health Sciences Programs", "Humanities & Education Programs" },
                { "Dissatisfied", "Neutral", "Satisfied", "Unsure" },
                { "Dissatisfied", "Neutral", "Satisfied", "Unsure" },
                { "Not at all likely", "Somewhat likely", "Extremely likely", "Unsure" },
                { "Not at all likely", "Somewhat likely", "Extremely likely", "Unsure" },
                { "Not at all likely", "Somewhat likely", "Extremely likely", "Unsure" },
                { "I don’t have a job", "1-10 hours a week", "10-20 hours a week", "More than 20 hours a week" },
                { "Definitely no", "Definitely yes", "Already working in a similiar field", "Unsure" },
                { "Not at all likely", "Somewhat likely", "Extremely likely", "Unsure" },
                { "Definitely no", "It could be more safe", "Definitely yes", "Unsure" },
                { "They are too few", "They are just right", "They are too many", "Unsure" },
                { "Dormitories", "Apartments", "Local to your university's city", "Prefer not to say" },
                { "Dissatisfied", "Neutral", "Satisfied", "Unsure" },
                { "Dissatisfied", "Neutral", "Satisfied", "Unsure" },
                { "Teaching staff and their methods", "Dormitories' prices, locations and spaces", "University's buildings and equipments", "Extracurricular activities, out of school programs" },
        };

        for (int i = 0; i < questions.length; i++) {
            if (!isQAInDatabase(questions[i])) {
                addQA(questions[i], answers[i][0], answers[i][1], answers[i][2], answers[i][3]);
            }
        }


    }
}
