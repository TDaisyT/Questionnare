package com.example.questionnare;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLDataException;

public class DatabaseManager {
    private DatabaseHelper dbHelper;//Adatbázis sémát kezelő segédosztály
    private Context context;//Alkalmazás kontexusa
    private SQLiteDatabase database;//Aktuális adatbázis
    private static DatabaseManager instance;//Singleton példány


    // Privát konstruktor a Singleton tervezési minta számára
    public DatabaseManager(Context c){
        context = c;
        dbHelper = new DatabaseHelper(context);
    }

    //Singleton példány inicializálása az alkalmazás kezdetén
    public static void init(Context c) {
        if (instance == null) {
            instance = new DatabaseManager(c);
        }
    }

    //Singleton példány lekérése
    public static DatabaseManager getInstance() {
        if (instance == null) {
            throw new IllegalStateException(DatabaseManager.class.getSimpleName() +
                    " is not initialized. You must call init(Context) function before using getInstance().");
        }
        return instance;
    }

    //Adatbázis kapcsolat megnyitása
    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    //Adatbázis kapsolat lezárása
    public void close() {
        dbHelper.close();
    }

    //Az aktuális adatbázis lekérése
    public SQLiteDatabase getDatabase() {
        return database;
    }
}
