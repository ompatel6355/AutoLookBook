package com.example.autolookbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CarDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_detail);

        // Initialize views
        ImageView carImage = findViewById(R.id.detail_car_image);
        TextView carNameText = findViewById(R.id.detail_car_name);
        TextView carDescriptionText = findViewById(R.id.detail_car_description);
        Button moreInfoButton = findViewById(R.id.moreInfoButton);
        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);

        // Retrieve data from the intent
        String carName = getIntent().getStringExtra("CAR_NAME");
        String carDescription = getIntent().getStringExtra("CAR_DESCRIPTION");
        int carImageResId = getIntent().getIntExtra("CAR_IMAGE_RES_ID", -1); // Using -1 as the default value to indicate 'not set'

        // Set the retrieved data to the views
        carNameText.setText(carName);
        carDescriptionText.setText(carDescription);

        // Check if a valid image resource ID was provided, then set the image
        if (carImageResId != -1) {
            carImage.setImageResource(carImageResId);
        } else {
            // Handle the case where no image is provided, for example, by setting a default image
            // carImage.setImageResource(R.drawable.default_image); // Uncomment and replace 'default_image' with your actual default image resource
            carImage.setVisibility(ImageView.GONE); // Or hide the ImageView if no default image is desired
        }

        // Check if the user is an admin, then show FloatingActionButton
        boolean isAdmin = getIntent().getBooleanExtra("isAdmin", false);
        if (isAdmin) {
            floatingActionButton.setVisibility(View.VISIBLE);
            floatingActionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Add your action here when the FloatingActionButton is clicked
                    // For example, you can open a dialog to add a new car
                    // Or start a new activity to add a new car
                    // For demonstration, let's just show a toast message
                    Toast.makeText(CarDetailActivity.this, "FloatingActionButton clicked!", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            floatingActionButton.setVisibility(View.GONE);
        }

        // Set OnClickListener for the More Info button
        moreInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(CarDetailActivity.this, "More Info button clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
