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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        // Define valid username/password combinations
        String[] validEmails = {"test@example.com", "user@example.com"};
        String[] validPasswords = {"password", "password123"};

        // Check if entered credentials match any of the valid combinations
        boolean isValid = false;
        for (int i = 0; i < validEmails.length; i++) {
            if (email.equals(validEmails[i]) && password.equals(validPasswords[i])) {
                isValid = true;
                break;
            }
        }

        if (isValid) {
            // Login successful, navigate to MainActivity
            Intent intent = new Intent(LoginActivity.this, RecyclerView.class);
            startActivity(intent);
            finish(); // Finish LoginActivity so user can't go back to it after logging in
        } else {
            // Invalid credentials, show error message
            Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show();
        }
    }


}
