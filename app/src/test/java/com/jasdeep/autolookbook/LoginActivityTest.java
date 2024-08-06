package com.jasdeep.autolookbook;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import android.content.SharedPreferences;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class LoginActivityTest {

    private LoginActivity loginActivity;

    @Mock
    private FirebaseAuth mockAuth;
    @Mock
    private FirebaseUser mockUser;
    @Mock
    private SharedPreferences mockSharedPreferences;
    @Mock
    private SharedPreferences.Editor mockEditor;
    @Mock
    private CheckBox mockRememberMeCheckbox;
    @Mock
    private EditText mockEditTextEmail;
    @Mock
    private EditText mockEditTextPassword;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Initialize LoginActivity and mock dependencies
        loginActivity = new LoginActivity();
        loginActivity.mAuth = mockAuth;
        loginActivity.sharedPreferences = mockSharedPreferences;

        when(mockSharedPreferences.edit()).thenReturn(mockEditor);
    }

    @Test
    public void login_withValidCredentials_shouldSaveRememberMeState() {
        // Arrange
        String email = "valid@example.com";
        String password = "password123";

        when(mockEditTextEmail.getText().toString().trim()).thenReturn(email);
        when(mockEditTextPassword.getText().toString().trim()).thenReturn(password);

        // Mock successful Firebase authentication
        // when(mockAuth.signInWithEmailAndPassword(anyString(), anyString()))
                // .thenReturn(mock(AuthTask.class));
        when(mockUser.isEmailVerified()).thenReturn(true);

        // Act
        // loginActivity.login();

        // Assert
        verify(mockEditor).putBoolean(LoginActivity.KEY_REMEMBER_ME, mockRememberMeCheckbox.isChecked());
        verify(mockEditor).apply();
    }

    @Test
    public void login_withInvalidCredentials_shouldShowErrorMessage() {
        // Arrange
        String email = "invalid@example.com";
        String password = "wrongpassword";

        when(mockEditTextEmail.getText().toString().trim()).thenReturn(email);
        when(mockEditTextPassword.getText().toString().trim()).thenReturn(password);

        // Mock failed Firebase authentication
       //  when(mockAuth.signInWithEmailAndPassword(anyString(), anyString()))
          //       .thenReturn(mock(AuthTask.class));
        when(mockAuth.getCurrentUser()).thenReturn(null);

        // Act
        // loginActivity.login();

        // Assert
        verify(mockAuth).signInWithEmailAndPassword(email, password);
        // Check Toast message
        // Note: Toasts are not directly testable; consider using Robolectric for this
    }
}
