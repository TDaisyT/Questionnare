package com.example.questionnare;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test for validating the application's package name.
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Test
    public void validatePackageName() {
        // Arrange
        Context appContext = ApplicationProvider.getApplicationContext();
        String expectedPackageName = "com.example.questionnare";

        // Act
        String actualPackageName = appContext.getPackageName();

        // Assert
        assertEquals("The package name matches the expected value", expectedPackageName, actualPackageName);
    }
}
