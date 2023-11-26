package com.example.questionnare;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Before
    public void setUp() {
        ActivityScenario.launch(MainActivity.class);
    }

    @After
    public void tearDown() {
        Intents.release();
    }

    @Test
    public void testSuccessfulLogin() {
        // Arrange
        Intents.init();
        String email = "user@example.com";
        String password = "securepassword";

        // Act
        onView(withId(R.id.emailLogin)).perform(replaceText(email));
        onView(withId(R.id.passwordLogin)).perform(replaceText(password));
        onView(withId(R.id.loginButton)).perform(click());

        // Assert
        intended(hasComponent(HomeActivity.class.getName()));
        intended(hasExtra("email", email));
        intended(hasExtra("password", password));

    }
}
