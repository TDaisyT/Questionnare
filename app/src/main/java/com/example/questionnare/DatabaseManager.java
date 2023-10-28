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
}
