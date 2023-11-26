package com.example.questionnare.UserHome;

import android.content.Intent;
import android.view.View;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.questionnare.HomeActivity;
import com.example.questionnare.R;
import com.example.questionnare.SignUpActivity;

import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class QuestionsActivityTest {

    @Test
    public void testQuestionsActivity() {
        // Arrange
        Intent intent = new Intent(getApplicationContext(), QuestionsActivity.class);
        ActivityScenario<QuestionsActivity> scenario = ActivityScenario.launch(intent);

        // Act
        scenario.onActivity(activity -> {
            // Assert
            assertNotNull(activity);

            // Check if questions are displayed
            ListView listView = activity.findViewById(R.id.list_questions);
            assertNotNull(listView);
            assertEquals(14, listView.getCount()); // Assuming there are 14 questions, adjust accordingly

            // Check if all radio buttons are checked
            assertTrue(areAllRadioButtonsChecked(listView));

            // Check if submit button click works
            View submitButton = activity.findViewById(R.id.submitButton);
            assertNotNull(submitButton);
            submitButton.performClick();

            // Check if answers are submitted successfully
            Intent expectedIntent = new Intent(activity, HomeActivity.class);
            assertTrue(activity.isFinishing()); // Assuming the activity finishes after submitting answers
        });

        // Clean up
        scenario.close();
    }

    // Helper method to check if all radio buttons in the ListView are checked
    private boolean areAllRadioButtonsChecked(ListView listView) {
        for (int i = 0; i < listView.getCount(); i++) {
            View listItem = listView.getChildAt(i);

            // Check if listItem is not null
            if (listItem != null) {
                RadioGroup radioGroup = listItem.findViewById(R.id.optionsRadioGroup);

                // Check if radioGroup is not null
                if (radioGroup != null && radioGroup.getCheckedRadioButtonId() == -1) {
                    return false;
                }
            }
        }
        return true;
    }
}


