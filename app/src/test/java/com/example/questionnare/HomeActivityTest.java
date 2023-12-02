package com.example.questionnare;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.rule.IntentsTestRule;

import com.example.questionnare.Database.DatabaseManager;
import com.example.questionnare.UserHome.ProfileActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class HomeActivityTest {
    @Rule
    public IntentsTestRule<HomeActivity> activityRule = new IntentsTestRule<>(HomeActivity.class);

    @Before
    public void setUp() {
        // Initialize and open the database for testing
        DatabaseManager dbManager = new DatabaseManager(activityRule.getActivity());
        dbManager.open();
        dbManager.initializeQA();
        dbManager.close();
    }

    @After
    public void tearDown() {
        // Perform cleanup if needed
    }

    @Test
    public void testNavigationToProfileActivity() {
        // Click on the profile icon in the bottom navigation
        Espresso.onView(withId(R.id.profile)).perform(click());

        // Check if the ProfileActivity is launched
        Intents.intended(hasComponent(ProfileActivity.class.getName()));
    }

    @Test
    public void testDefaultFragmentIsDisplayed() {
        // Check if the Qlist fragment is displayed by default
        Espresso.onView(withId(R.id.container)).check(matches(isDisplayed()));
    }
}