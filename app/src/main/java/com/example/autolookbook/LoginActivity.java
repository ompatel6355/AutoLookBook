package com.example.autolookbook;




import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
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
                // Here you would handle the login logic, possibly validating input
                // and then logging in the user by checking with your backend server.
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                if(validateLogin(email, password)) {
                    // Proceed with login process
                    Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                } else {
                    // Show error message
                    Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set up create account text click listener if needed
    }

    private boolean validateLogin(String email, String password) {
        // Add validation logic here (e.g., check if fields are not empty, etc.)
        return !email.isEmpty() && !password.isEmpty();
    }
}
