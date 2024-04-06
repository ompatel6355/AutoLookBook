package com.example.autolookbook;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profile);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // Enable the back button in the toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Initialize TextView

        // Retrieve user information (replace with actual user data)
        String userName = "John Doe";
        String userEmail = "john.doe@example.com";

        // Find views
        ImageView profileImage = findViewById(R.id.profileImage);
        TextView profileName = findViewById(R.id.profileName);
        TextView profileEmail = findViewById(R.id.profileEmail);

        // Set user information
        // Replace default values with actual user data
        profileName.setText(userName);
        profileEmail.setText(userEmail);
    }

    public boolean onSupportNavigateUp() {
        // Handle the back button press
        onBackPressed();
        return true;
    }
}