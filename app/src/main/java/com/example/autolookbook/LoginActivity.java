package com.example.autolookbook;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;
    public Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize UI components
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        // Check if the user is already logged in
        if (userIsLoggedIn()) {
            navigateToMainActivity();
        }

        // Set click listener for the login button
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performLogin();
            }
        });
    }

    private void performLogin() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        // Here, you should add your logic to verify login credentials, possibly against a server
        // For this example, let's assume any non-empty credentials are "valid"
        if (!email.isEmpty() && !password.isEmpty()) {
            // Login successful, save login state and navigate to MainActivity
            saveLoginState();
            navigateToMainActivity();
        } else {
            // Login failed, show a message to the user
            Toast.makeText(LoginActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveLoginState() {
        // Save login state (for simplicity, using SharedPreferences here)
        SharedPreferences sharedPreferences = getSharedPreferences("AppPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("LoggedIn", true);
        editor.apply();
    }

    private boolean userIsLoggedIn() {
        // Check login state (using SharedPreferences)
        SharedPreferences sharedPreferences = getSharedPreferences("AppPrefs", MODE_PRIVATE);
        return sharedPreferences.getBoolean("LoggedIn", false);
    }

    private void navigateToMainActivity() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish(); // Finish LoginActivity so the user can't go back to it
    }
}
