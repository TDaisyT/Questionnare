package com.example.questionnare.UserHome;

import android.content.Intent;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.test.core.app.ActivityScenario;
import androidx.test.runner.AndroidJUnit4;

import com.example.questionnare.MainActivity;
import com.example.questionnare.R;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Objects;

@RunWith(AndroidJUnit4.class)
public class ProfileActivityTest {

    @Test
    public void testProfileFragment() {
        // Arrange
        Intent intent = new Intent();
        intent.putExtra("email", "test@example.com");
        intent.putExtra("password", "testpassword");

        try (ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class)) {
            scenario.onActivity(activity -> {
                Fragment profileFragment = new ProfileActivity();

                // Act
                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, profileFragment)
                        .commitNow();

                // Assert
                TextView emailTextView = Objects.requireNonNull(profileFragment.getView()).findViewById(R.id.emailProfile);
                TextView passwordTextView = profileFragment.getView().findViewById(R.id.passwordProfile);

                assertNotNull(emailTextView);
                assertNotNull(passwordTextView);
                assertEquals("Email: test@example.com", emailTextView.getText().toString());
                assertEquals("Password: testpassword", passwordTextView.getText().toString());
            });
        }
    }
}

