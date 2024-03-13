package com.example.autolookbook;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    ImageView carImage;
    TextView carName, carDescription; // Assuming you have a TextView for the car description

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        carImage = findViewById(R.id.carImage);
        carName = findViewById(R.id.carName);
        carDescription = findViewById(R.id.carDescription); // Initialize the TextView for car description
        carDescription.setText("This is an example car description.");
        // Setup ActionBarDrawerToggle
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Navigation item selection handling
        navigationView.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Toast.makeText(MainActivity.this, "Home Selected", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.navigation_about_us:
                    Toast.makeText(MainActivity.this, "About Us Info", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.navigation_notifications:
                    Toast.makeText(MainActivity.this, "No New Notifications", Toast.LENGTH_SHORT).show();
                    break;
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });

        // Fetch featured car from the mock database and display it
        Car featuredCar = MockDatabase.getFeaturedCar();
        carName.setText(featuredCar.getName());
        carDescription.setText(featuredCar.getDescription());
        carImage.setImageResource(featuredCar.getImageResource()); // Make sure your Car class has a method to get the image resource
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
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
