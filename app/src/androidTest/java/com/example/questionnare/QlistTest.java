package com.example.questionnare;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.action.ViewActions.click;


@RunWith(AndroidJUnit4.class)
public class QlistTest {

    @Test
    public void testListItemClick() {
        // Start the Qlist fragment in an Activity
        ActivityScenario.launch(MainActivity.class);

        // Perform a click on the first item in the list
        Espresso.onView(ViewMatchers.withId(R.id.list_items))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

    }
}
