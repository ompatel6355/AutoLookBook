package com.jasdeep.autolookbook;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FirebaseAnalytics mFirebaseAnalytics;
    private FirebaseAuth mAuth;
    private SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "AutoLookBookPrefs";
    private static final String KEY_REMEMBER_ME = "remember_me";

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize Firebase
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        mAuth = FirebaseAuth.getInstance();
        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        // Check if the user is already logged in
        FirebaseUser currentUser = mAuth.getCurrentUser();
        boolean isRemembered = sharedPreferences.getBoolean(KEY_REMEMBER_ME, false);

        if (currentUser == null && !isRemembered) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
            return;
        }

        {
            // Generate mock data for the list of cars
            List<Car> carDetailList = CarMockData.generateMockCars();

            listView = (ListView) findViewById(R.id.carListView);
            CustomCarListAdapter carListAdapter = new CustomCarListAdapter(this, carDetailList);
            listView.setAdapter(carListAdapter);
        }

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        navigationView.setNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.navigation_home) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            } else if (itemId == R.id.navigation_about_us) {

//                Toast.makeText(MainActivity.this, "About Us Selected", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, AboutUSActivity.class);
                startActivity(intent);

            } else if (itemId == R.id.nav_profile) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
            } else if (itemId == R.id.navigation_notifications) {
                // Display no new notifications message
                Toast.makeText(MainActivity.this, "No new notifications", Toast.LENGTH_SHORT).show();
            }
            else if (itemId == R.id.Test_Drive) {
//                Toast.makeText(MainActivity.this, "Test drive is not available", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, TestDrive.class);
                startActivity(intent);
            }
            else if (itemId == R.id.finance) {
                Intent intent = new Intent(MainActivity.this, FinancingOptionsActivity.class);
                startActivity(intent);
                // Toast.makeText(MainActivity.this, "Loan options Available", Toast.LENGTH_SHORT).show();
            }
            else if (itemId == R.id.nav_logout) {
                // Handle logout
                logout();
            }

            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return drawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    private void logout() {
        mAuth.signOut();

        // Clear the "Remember Me" state
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(KEY_REMEMBER_ME);
        editor.apply();

        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish(); // Close the MainActivity
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
