package com.example.autolookbook;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText editTextEmail;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        Button buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(v -> login());
    }

    private void login() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            // Email or password is empty, show error message
            Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean isAdmin = false;

        // Define valid username/password combinations
        if (("test@example.com".equals(email) && "password".equals(password)) ||
                ("user@example.com".equals(email) && "password123".equals(password)) ||
                ("admin@example.com".equals(email) && "admin".equals(password))) {
            // Login successful
            if ("admin@example.com".equals(email)) {
                isAdmin = true; // Mark user as admin
            }
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra("isAdmin", isAdmin); // Pass isAdmin status to MainActivity
            startActivity(intent);
            finish();
        } else {
            // Invalid credentials, show error message
            Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show();
        }
    }
}
