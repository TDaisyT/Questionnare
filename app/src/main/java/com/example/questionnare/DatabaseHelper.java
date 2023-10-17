package com.example.questionnare;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Questionnaire";
    private static final int DATABASE_VERSION = 1;

    //SQL parancsok, hogy létrehozzam a három táblát az adatbázishoz:
    //Felhasználó adatokkal foglalkozó tábla (users a neve):
    private static final String CREATE_USERS_TABLE =  "CREATE TABLE users (" +
            "Id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "Email TEXT NOT NULL," +
            "Password TEXT NOT NULL)";

    //A kérdésekkel és válaszokkal foglalkozó tábla (qa a neve):
    private static final String CREATE_QA_TABLE = "CREATE TABLE qa (" +
            "Id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "Question TEXT NOT NULL," +
            "Answer1 TEXT NOT NULL," +
            "Answer2 TEXT NOT NULL," +
            "Answer3 TEXT NOT NULL," +
            "Answer4 TEXT NOT NULL)";

    //A felhasználó által kiválasztott választ tárolja, összeköti a másik két táblát(result a neve):
    private static final String CREATE_RESULT_TABLE = "CREATE TABLE result (" +
            "Id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "UserId INTEGER," +
            "QAId INTEGER," +
            "SelectedAnswer TEXT," +
            "FOREIGN KEY (UserId) REFERENCES users (Id)," +
            "FOREIGN KEY (QAId) REFERENCES qa (Id))";

    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
