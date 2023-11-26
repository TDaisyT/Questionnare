package com.example.questionnare;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class HomeActivityTest {

    @Test
    public void testDefaultFragment() {
        // Arrange
        ActivityScenario<HomeActivity> scenario = ActivityScenario.launch(HomeActivity.class);

        // Act
        scenario.onActivity(activity -> {
            // Assert
            assertNotNull(activity);

            // Check if default fragment is Qlist
            FragmentManager fragmentManager = activity.getSupportFragmentManager();
            Fragment defaultFragment = fragmentManager.findFragmentById(R.id.container);
            assertNotNull(defaultFragment);
            assertEquals(Qlist.class, defaultFragment.getClass());
        });

        // Clean up
        scenario.close();
    }
}

