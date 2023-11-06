package com.example.questionnare;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    static final String DATABASE_NAME = "Questionnaire";
    static final int DATABASE_VERSION = 4;//át lett írva, hogy a adatbázis fifrsíteni tudja magát

    public static final String TABLE_USERS = "User";
    public static final String TABLE_QA = "QA";
    public static final String TABLE_RESULT = "Result";


    public static final String COL_USER_ID = "user_id";
    public static final String COL_QA_ID = "qa_id";
    public static final String COL_RESULT_ID = "result_id";
    public static final String COL_EMAIL = "email";
    public static final String COL_PASSWORD = "password";
    public static final String COL_QUESTION = "question";
    public static final String COL_ANSWER1 = "answer1";
    public static final String COL_ANSWER2 = "answer2";
    public static final String COL_ANSWER3 = "answer3";
    public static final String COL_ANSWER4 = "answer4";
    public static final String COL_USERS_ID = "UserId";
    public static final String COL_FA1 = "fa1";
    public static final String COL_FA2 = "fa2";
    public static final String COL_FA3 = "fa3";
    public static final String COL_FA4 = "fa4";
    public static final String COL_FA5 = "fa5";
    public static final String COL_FA6 = "fa6";
    public static final String COL_FA7 = "fa7";
    public static final String COL_FA8 = "fa8";
    public static final String COL_FA9 = "fa9";
    public static final String COL_FA10 = "fa10";
    public static final String COL_FA11 = "fa11";
    public static final String COL_FA12 = "fa12";
    public static final String COL_FA13 = "fa13";
    public static final String COL_FA14 = "fa14";
    public static final String COL_FA15 = "fa15";


    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the tables
        String createUsersTable = "CREATE TABLE " + TABLE_USERS + " (" +
                COL_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_EMAIL + " TEXT, " +
                COL_PASSWORD + " TEXT)";
        db.execSQL(createUsersTable);//az adatbázis séma létrehozásáért felelős

        String createQATable = "CREATE TABLE " + TABLE_QA + " (" +
                COL_QA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_QUESTION + " TEXT, " +
                COL_ANSWER1 + " TEXT, " +
                COL_ANSWER2 + " TEXT, " +
                COL_ANSWER3 + " TEXT, " +
                COL_ANSWER4 + " TEXT)";
        db.execSQL(createQATable);

        String createResultsTable = "CREATE TABLE " + TABLE_RESULT + " (" +
                COL_RESULT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_USERS_ID + " INTEGER, " +
                COL_FA1 + " TEXT, " +
                COL_FA2 + " TEXT, " +
                COL_FA3 + " TEXT, " +
                COL_FA4 + " TEXT, " +
                COL_FA5 + " TEXT, " +
                COL_FA6 + " TEXT, " +
                COL_FA7 + " TEXT, " +
                COL_FA8 + " TEXT, " +
                COL_FA9 + " TEXT, " +
                COL_FA10 + " TEXT, " +
                COL_FA11 + " TEXT, " +
                COL_FA12 + " TEXT, " +
                COL_FA13 + " TEXT, " +
                COL_FA14 + " TEXT, " +
                COL_FA15 + " TEXT, " +
                "FOREIGN KEY (" + COL_USERS_ID + ") REFERENCES " + TABLE_USERS + "(" + COL_USER_ID + "))";
        db.execSQL(createResultsTable);


    }


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    //Kezeli az adatbázis verziójának frissítéseit és az esetleges változásokat az adatbázis sémában
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion) {
            // Elmenti az eddigi adatokat ideiglenes táblákban
            db.execSQL("CREATE TABLE backup_users AS SELECT * FROM " + TABLE_USERS);
            db.execSQL("CREATE TABLE backup_qa AS SELECT * FROM " + TABLE_QA);
            db.execSQL("CREATE TABLE backup_result AS SELECT * FROM " + TABLE_RESULT);

            // Törli az eddigi táblákat
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_QA);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESULT);

            // Új táblákat hozz létre a sémákkal
            onCreate(db);

            // Visszamásolja az adatokat az új táblákba az ideiglenes táblákból
            db.execSQL("INSERT INTO " + TABLE_USERS + " SELECT * FROM backup_users");
            db.execSQL("INSERT INTO " + TABLE_QA + " SELECT * FROM backup_qa");
            db.execSQL("INSERT INTO " + TABLE_RESULT + " SELECT * FROM backup_result");

            // Törli az ideiglenes táblákat
            db.execSQL("DROP TABLE IF EXISTS backup_users");
            db.execSQL("DROP TABLE IF EXISTS backup_qa");
            db.execSQL("DROP TABLE IF EXISTS backup_result");
        }
    }
}
