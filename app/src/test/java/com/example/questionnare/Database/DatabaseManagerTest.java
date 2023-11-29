package com.example.questionnare.Database;

import static androidx.test.InstrumentationRegistry.getContext;
import static org.junit.Assert.*;

import android.content.Context;
import android.database.Cursor;
import android.os.Build;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;

import java.util.ArrayList;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = {Build.VERSION_CODES.O_MR1}) // Uses a specific SDK version
public class DatabaseManagerTest {
    private DatabaseManager databaseManager;

    @Before
    public void setUp() throws Exception {
        Context context = ApplicationProvider.getApplicationContext();
        databaseManager = new DatabaseManager(context);
        databaseManager.open();
    }


    @After
    public void tearDown() throws Exception {
        databaseManager.close();
        ShadowApplication.getInstance().getForegroundThreadScheduler().advanceToLastPostedRunnable();
    }

    @Test
    public void addUserTest() {
        // Tesztadatok
        String testEmail = "test@example.com";
        String testPassword = "testpassword";

        // Hozzáadás
        databaseManager.open();
        databaseManager.addUser(testEmail, testPassword);

        assertTrue(databaseManager.checkUser(testEmail, testPassword));

    }

    @Test
    public void checkUserTest() {
        // Tesztadatok
        String testEmail = "test@example.com";
        String testPassword = "testpassword";

        assertFalse(databaseManager.checkUser(testEmail, testPassword));
    }

    @Test
    public void checkEmailTest() {
        // Tesztadat
        String testEmail = "test@example.com";

        assertFalse(databaseManager.checkEmail(testEmail));

        // Tesztadat
        String testPassword = "testpassword";

        // Hozzáadás
        databaseManager.open();
        databaseManager.addUser(testEmail, testPassword);

        assertTrue(databaseManager.checkEmail(testEmail));

    }

    @Test
    public void getUserIdTest() {
        // Tesztadatok
        String testEmail = "test@example.com";
        int expectedUserId = 1; // Példa felhasználói azonosító

        // Hozzáadás
        databaseManager.addUser(testEmail, "testpassword");

        int actualUserId = databaseManager.getUserId(testEmail);
        assertEquals(expectedUserId, actualUserId);

    }

    @Test
    public void addQATest() {
        // Tesztadatok
        String testQuestion = "What is your major?";
        String testAnswer1 = "IT Programs";
        String testAnswer2 = "Agriculture Programs";
        String testAnswer3 = "Health Sciences Programs";
        String testAnswer4 = "Humanities & Education Programs";

        // Hozzáadás
        databaseManager.addQA(testQuestion, testAnswer1, testAnswer2, testAnswer3, testAnswer4);

        assertTrue(databaseManager.isQAInDatabase(testQuestion));
    }

    @Test
    public void addResultTest() {
        // Ebben a tesztben feltételezzük, hogy az adatbázis inicializálása és a szükséges adatok betöltése megtörtént

        int testUserId = 1; // Példa felhasználói azonosító
        String[] testAnswers = new String[]{"Answer1", "Answer2", "Answer3", "Answer4", "Answer5", "Answer6", "Answer7", "Answer8", "Answer9", "Answer10", "Answer11", "Answer12", "Answer13", "Answer14", "Answer15"};

        databaseManager.addResult(testUserId, testAnswers);

        // Ellenőrizzük az eredményt
        Cursor cursor = databaseManager.getQAData();

        if (cursor != null) {
            while (cursor.moveToNext()) {
                int userId = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_USERS_ID));

                if (userId == testUserId) {
                    for (int i = 0; i < testAnswers.length; i++) {
                        String columnName = "fa" + (i + 1);
                        String answer = cursor.getString(cursor.getColumnIndex(columnName));

                        // Ellenőrizzük, hogy a válasz megegyezik-e a teszt válaszával
                        assertEquals("Answer" + (i + 1), answer);
                    }

                    break;
                }
            }
            cursor.close();
        }
    }


    @Test
    public void initializeQAAndisQAInDatabaseTest() {
        // Hozzáad egy kérdést és válaszokat, majd ellenőrzi, hogy azok benne vannak-e az adatbázisban
        databaseManager.initializeQA();

        assertTrue(databaseManager.isQAInDatabase("What is your major?"));
    }


    @Test
    public void getAnswersByQuestionTest() {
        // Tesztadatok
        int testQNumber = 1;
        String testAnswer1 = "Answer1";
        String testAnswer2 = "Answer2";
        String testAnswer3 = "Answer3";
        String testAnswer4 = "Answer4";

        // Hozzáadunk egy teszt felhasználót és válaszokat
        int testUserId = 1;
        String[] testAnswers = {testAnswer1, testAnswer2, testAnswer3, testAnswer4};
        databaseManager.addResult(testUserId, testAnswers);

        // Lehívjuk a getAnswersByQuestion metódust
        ArrayList<String> retrievedAnswers = databaseManager.getAnswersByQuestion(testQNumber);

        // Ellenőrizzük, hogy a visszaadott válaszok megegyeznek-e a várt válaszokkal
        assertEquals(testAnswers[testQNumber - 1], retrievedAnswers.get(0));

    }

    @Test
    public void getQADataTest() {
        // Tesztadatok
        String testQuestion1 = "What is your major?";
        String[] testAnswers1 = {"IT Programs", "Agriculture Programs", "Health Sciences Programs", "Humanities & Education Programs"};

        String testQuestion2 = "How do you like to spend your weekends?";
        String[] testAnswers2 = {"Reading", "Outdoor activities", "Watching movies", "Socializing with friends"};

        // Hozzáadunk két kérdést és válaszokat
        databaseManager.addQA(testQuestion1, testAnswers1[0], testAnswers1[1], testAnswers1[2], testAnswers1[3]);
        databaseManager.addQA(testQuestion2, testAnswers2[0], testAnswers2[1], testAnswers2[2], testAnswers2[3]);

        Cursor cursor = databaseManager.getQAData();

        // Ellenőrizzük, hogy a cursor nem üres és a várt adatokat tartalmazza-e
        assertNotNull(cursor);

        // Ellenőrzés az első kérdésre és válaszokra
        assertTrue(cursor.moveToFirst());
        assertEquals(testQuestion1, cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_QUESTION)));
        assertEquals(testAnswers1[0], cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_ANSWER1)));
        assertEquals(testAnswers1[1], cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_ANSWER2)));
        assertEquals(testAnswers1[2], cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_ANSWER3)));
        assertEquals(testAnswers1[3], cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_ANSWER4)));

        // Ellenőrzés a második kérdésre és válaszokra
        assertTrue(cursor.moveToNext());
        assertEquals(testQuestion2, cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_QUESTION)));
        assertEquals(testAnswers2[0], cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_ANSWER1)));
        assertEquals(testAnswers2[1], cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_ANSWER2)));
        assertEquals(testAnswers2[2], cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_ANSWER3)));
        assertEquals(testAnswers2[3], cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_ANSWER4)));

        cursor.close();
    }
}