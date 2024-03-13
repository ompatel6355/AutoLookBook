package com.example.autolookbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonLogin;

    @Override
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
        if ("test@example.com".equals(email) && "password".equals(password) || "user@example.com".equals(email) && "password123".equals(password)) {
            // Login successful, navigate to MainActivity which should host the RecyclerView
            Intent intent = new Intent(LoginActivity.this, MainActivity.class); // Assuming MainActivity hosts the RecyclerView
            startActivity(intent);
            finish(); // Finish LoginActivity so user can't go back to it after logging in
        } else {
            // Invalid credentials, show error message
            Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show();
        }
    }
}
