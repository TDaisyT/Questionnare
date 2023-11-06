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
        String[] columns = { DatabaseHelper.COL_USER_ID };
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

    //Hozzáadja a Result táblához a felhasználó válaszait
    public void addResult(int userId, String fa1, String fa2, String fa3, String fa4, String fa5, String fa6, String fa7, String fa8, String fa9, String fa10, String fa11, String fa12, String fa13, String fa14, String fa15) {
        if (!isUserInResultTable(userId)) {
            ContentValues values = new ContentValues();
            values.put(DatabaseHelper.COL_USERS_ID, userId);
            for(int i=1;+i<=15;i++){
                String column = "DatabaseHelper.COL_FA"+i;
                String value = "fa"+i;
                values.put(column, value);
            }
            long insertedResult = database.insert(DatabaseHelper.TABLE_RESULT, null, values);
            if (insertedResult == -1) {
                Log.d("DatabaseManager", "Error: The results weren't inserted into the database");
            }
        }
    }
    //Megnézi hogy a felhasználó szerepel-e a result táblába (hogy véletelen se tegye bele kétszer)
    private boolean isUserInResultTable(int userId) {
        String[] columns = { DatabaseHelper.COL_RESULT_ID };
        String selection = DatabaseHelper.COL_USERS_ID + " = ?";
        String[] selectionArgs = { String.valueOf(userId) };

        Cursor cursor = database.query(DatabaseHelper.TABLE_RESULT, columns, selection, selectionArgs, null, null, null);
        boolean userExistsInResultTable = (cursor.getCount() > 0);
        cursor.close();

        return userExistsInResultTable;
    }

    //Megnézi hogy benne van a QA tábla már az adatbázisban
    public boolean isQAInDatabase(String question) {
        String[] columns = { DatabaseHelper.COL_QA_ID };
        String selection = DatabaseHelper.COL_QUESTION + " = ?";
        String[] selectionArgs = { question };
        Cursor cursor = database.query(DatabaseHelper.TABLE_QA, columns, selection, selectionArgs, null, null, null);
        boolean qaExists = (cursor.getCount() > 0);
        cursor.close();
        return qaExists;
    }
    //Csak berakja az adatbázisba a QA tábla adatait, ha még nem tette meg
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
    //Hozzáadtam az admint
    public void addAdmin() {
        String email = "admin@gmail.com";
        String password = "admin";
        if(!checkUser(email,password)) {
            addUser(email, password);
            Log.d("DatabaseManager", "Admin user added to the database");
        }
        else {
            Log.d("DatabaseManager", "Admin user already exists in the database");
        }


    }



    //---------CHECKING TABLES:--------------------


    //JUST TO CHECK THE USERS TABLE:
    public void printUserTable() {
        Cursor cursor = database.query(DatabaseHelper.TABLE_USERS, null, null, null, null, null, null);

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    int userId = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_USER_ID));
                    String userEmail = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_EMAIL));
                    String userPassword = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_PASSWORD));
                    Log.d("DatabaseContent", "User ID: " + userId + ", Email: " + userEmail + ", Password: " + userPassword);
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
    }
    //JUST TO CHECK RESULT TABLE:
   public void logResultTable() {
        Cursor cursor = database.query(DatabaseHelper.TABLE_RESULT, null, null, null, null, null, null);

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    int resultId = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_RESULT_ID));
                    int userId = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_USERS_ID));
                    String logMessage = "Result ID: " + resultId+ " User ID: " + userId;

                    // Oszlopok sorszámaival való iterálás
                    for (int i = 1; i <= 15; i++) {
                        String columnName = "fa" + i;
                        String columnValue = cursor.getString(cursor.getColumnIndex(columnName));
                        logMessage += ", " + columnName + ": " + columnValue;
                    }

                    Log.d("ResultTableContent", logMessage);
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
    }



    /*Home activitybőll lett kiszedve, kiíratja a qa táblát->Függvénnyé tenni futattáshoz
        Cursor cursor = dbManager.queryDatabase("SELECT * FROM " + DatabaseHelper.TABLE_QA);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_QA_ID));
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


    /* Probléma megoldásához készült csak, a legvégén törlésre kerül:
    public Cursor queryDatabase(String query) {
        return database.rawQuery(query, null);
    }

    public void deleteAllQA() {
        database.delete(DatabaseHelper.TABLE_QA, null, null);
    }
*/
}
