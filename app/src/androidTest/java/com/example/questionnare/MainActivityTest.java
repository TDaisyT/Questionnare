package com.example.questionnare;

import com.example.questionnare.HomeActivity;
import com.example.questionnare.MainActivity;
import com.example.questionnare.R;

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

    private static final String TEST_EMAIL = "user@example.com";
    private static final String TEST_PASSWORD = "securepassword";

    @Before
    public void launchActivity() {
        ActivityScenario.launch(MainActivity.class);
        Intents.init();
    }

    @After
    public void releaseIntents() {
        Intents.release();
    }

    @Test
    public void testSuccessfulLogin() {

        onView(withId(R.id.emailLogin)).perform(replaceText(TEST_EMAIL));
        onView(withId(R.id.passwordLogin)).perform(replaceText(TEST_PASSWORD));
        onView(withId(R.id.loginButton)).perform(click());

        intended(hasComponent(HomeActivity.class.getName()));
        intended(hasExtra("email", TEST_EMAIL));
        intended(hasExtra("password", TEST_PASSWORD));
    }
}