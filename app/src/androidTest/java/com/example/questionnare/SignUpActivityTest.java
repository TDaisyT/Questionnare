package com.example.questionnare;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class SignUpActivityTest {

    @Before
    public void setUp() {
        // Elindítjuk a SignUpActivity-t
        ActivityScenario.launch(SignUpActivity.class);
    }

    @Test
    public void testRegistrationSuccess() {
        // Ellenőrizzük, hogy a helyes nézetek megjelennek-e
        Espresso.onView(withId(R.id.emailSignUp)).perform(typeText("test@example.com"));
        Espresso.onView(withId(R.id.passwordSignUp)).perform(typeText("password"));
        Espresso.onView(withId(R.id.passwordAgain)).perform(typeText("password"));
        Espresso.onView(withId(R.id.checkBox)).perform(click());
        Espresso.onView(withId(R.id.signUpButton)).perform(click());

    }

}
