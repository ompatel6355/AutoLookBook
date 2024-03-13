package com.example.autolookbook;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CarDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_detail);

        // Initialize views
        ImageView carImage = findViewById(R.id.detail_car_image);
        TextView carNameText = findViewById(R.id.detail_car_name);
        TextView carDescriptionText = findViewById(R.id.detail_car_description);

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
    }
}
