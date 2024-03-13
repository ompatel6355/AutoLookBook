package com.example.autolookbook;

import android.content.Intent;
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
    TextView carName, carDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        carImage = findViewById(R.id.carImage); // Ensure these IDs exist in your layout
        carName = findViewById(R.id.carName);
        carDescription = findViewById(R.id.carDescription);

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

                Toast.makeText(MainActivity.this, "About Us Selected", Toast.LENGTH_SHORT).show();

            } else if (itemId == R.id.navigation_notifications) {
                Toast.makeText(MainActivity.this, "No New Notifications", Toast.LENGTH_SHORT).show();
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });

        // Assuming MockDatabase.getFeaturedCar() exists and returns a Car object
        Car featuredCar = MockDatabase.getFeaturedCar();
        carName.setText(featuredCar.getName());
        carDescription.setText(featuredCar.getDescription());
        carImage.setImageResource(featuredCar.getImageResource());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return drawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
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
