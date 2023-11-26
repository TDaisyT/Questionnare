package com.example.questionnare;

import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.PrimaryKey;
import androidx.room.Query;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import androidx.test.core.app.ApplicationProvider;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.runner.AndroidJUnit4;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class Databasetest {

    private static MyDatabase myDatabase;

    @Before
    public void initDb() {
        myDatabase = Room.inMemoryDatabaseBuilder(
                        ApplicationProvider.getApplicationContext(),
                        MyDatabase.class)
                .build();
    }

    @After
    public void closeDb() {
        myDatabase.close();
    }

    @Test
    public void insertAndReadData() {
        // Given
        Data testData = new Data("example data");

        // When
        myDatabase.myDao().insertData(testData);

        // Then
        Data retrievedData = myDatabase.myDao().getDataById(testData.getId());
        assertNotNull(retrievedData);
        assertEquals(testData.getId(), retrievedData.getId());
        assertEquals(testData.getContent(), retrievedData.getContent());
    }

    // Az adatbázis definiálása
    private abstract class MyDatabase extends RoomDatabase {
        public abstract MyDao myDao();

        public void close() {
        }
    }

    // Az adatbázis DAO interfésze
    @Dao
    public interface MyDao {
        @Insert
        void insertData(Data data);

        @Query("SELECT * FROM data WHERE id = :id")
        Data getDataById(int id);
    }

    // Az adatbázisban tárolt adatokat reprezentáló osztály
    @Entity(tableName = "data")
    public class Data {
        @PrimaryKey(autoGenerate = true)
        private int id;

        @ColumnInfo(name = "content")
        private final String content;

        public Data(String content) {
            this.content = content;
        }

        public int getId() {
            return id;
        }

        public String getContent() {
            return content;
        }
    }
}
