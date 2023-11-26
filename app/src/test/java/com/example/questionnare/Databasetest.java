package com.example.questionnare;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Databasetest {

    private Connection connection;

    @Before
    public void setUp() throws SQLException {
        // Adatbázis kapcsolat létrehozása
        connection = DriverManager.getConnection("jdbc:sqlite::memory:");

        // Példa tábla létrehozása
        try (PreparedStatement createTable = connection.prepareStatement(
                "CREATE TABLE users (id INTEGER PRIMARY KEY, username TEXT, email TEXT)")) {
            createTable.execute();
        }
    }

    @After
    public void tearDown() throws SQLException {
        // Adatbázis kapcsolat lezárása
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    @Test
    public void testInsertUser() throws SQLException {
        // Felhasználó beszúrása az adatbázisba
        try (PreparedStatement insertUser = connection.prepareStatement(
                "INSERT INTO users (username, email) VALUES (?, ?)")) {
            insertUser.setString(1, "john_doe");
            insertUser.setString(2, "john@example.com");
            insertUser.executeUpdate();
        }

        // Beszúrt felhasználó lekérdezése és ellenőrzése
        try (PreparedStatement selectUser = connection.prepareStatement(
                "SELECT * FROM users WHERE username=?")) {
            selectUser.setString(1, "john_doe");
            try (ResultSet resultSet = selectUser.executeQuery()) {
                assertTrue(resultSet.next());
                assertEquals("john_doe", resultSet.getString("username"));
                assertEquals("john@example.com", resultSet.getString("email"));
            }
        }
    }

    @Test
    public void testDeleteUser() throws SQLException {
        // Felhasználó beszúrása az adatbázisba
        try (PreparedStatement insertUser = connection.prepareStatement(
                "INSERT INTO users (username, email) VALUES (?, ?)")) {
            insertUser.setString(1, "jane_doe");
            insertUser.setString(2, "jane@example.com");
            insertUser.executeUpdate();
        }

        // Felhasználó törlése az adatbázisból
        try (PreparedStatement deleteUser = connection.prepareStatement(
                "DELETE FROM users WHERE username=?")) {
            deleteUser.setString(1, "jane_doe");
            deleteUser.executeUpdate();
        }

        // Törölt felhasználó lekérdezése és ellenőrzése
        try (PreparedStatement selectUser = connection.prepareStatement(
                "SELECT * FROM users WHERE username=?")) {
            selectUser.setString(1, "jane_doe");
            try (ResultSet resultSet = selectUser.executeQuery()) {
                assertFalse(resultSet.next()); // Nincs eredmény, mert a felhasználó törölve lett
            }
        }
    }
}
