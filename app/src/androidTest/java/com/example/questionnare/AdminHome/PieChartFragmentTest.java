package com.example.questionnare.AdminHome;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.test.core.app.ActivityScenario;
import androidx.test.runner.AndroidJUnit4;

import com.example.questionnare.MainActivity;
import com.example.questionnare.R;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class PieChartFragmentTest {

    @Test
    public void onCreateView_inflatesLayout() {
        // Arrange
        ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class);

        scenario.onActivity(activity -> {
            PieChartFragment pieChartFragment = new PieChartFragment();

            // Act
            View view = pieChartFragment.onCreateView(LayoutInflater.from(activity), null, null);

            // Assert
            assertNotNull(view);
            assertNotNull(view.findViewById(R.id.pieChart)); // Ellenőrizd az adott nézet elemet
        });
    }
}

