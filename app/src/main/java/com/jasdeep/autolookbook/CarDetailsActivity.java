package com.jasdeep.autolookbook;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CarDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_detail);

        // Retrieve the selected car's details from the intent
        Car selectedCar = getIntent().getParcelableExtra("selectedCar");

        // Populate views with car details
        ImageView imageView = findViewById(R.id.carImageView);
        imageView.setImageResource(selectedCar.getImageResource());

        TextView carNameTextView = findViewById(R.id.carNameTextView);
        carNameTextView.setText(selectedCar.getName());

        TextView carDescriptionTextView = findViewById(R.id.carDescriptionTextView);
        carDescriptionTextView.setText(selectedCar.getDescription());

        // Populate other TextViews with car details
        TextView yearTextView = findViewById(R.id.yearTextView);
        yearTextView.setText("Year: " + selectedCar.getYear());

        TextView priceTextView = findViewById(R.id.priceTextView);
        priceTextView.setText("Price: $" + selectedCar.getPrice());

        TextView mileageTextView = findViewById(R.id.mileageTextView);
        mileageTextView.setText("Mileage: " + selectedCar.getMileage() + " miles");

        TextView transmissionTextView = findViewById(R.id.transmissionTextView);
        transmissionTextView.setText("Transmission: " + selectedCar.getTransmission());

        TextView fuelTypeTextView = findViewById(R.id.fuelTypeTextView);
        fuelTypeTextView.setText("Fuel Type: " + selectedCar.getFuelType());

        TextView colorTextView = findViewById(R.id.colorTextView);
        colorTextView.setText("Color: " + selectedCar.getColor());

        TextView engineTypeTextView = findViewById(R.id.engineTypeTextView);
        engineTypeTextView.setText("Engine Type: " + selectedCar.getEngineType());

        // New performance details
        TextView engineDisplacementTextView = findViewById(R.id.engineDisplacementTextView);
        engineDisplacementTextView.setText("Engine Displacement: " + selectedCar.getEngineDisplacement() + "L");

        TextView horsepowerTextView = findViewById(R.id.horsepowerTextView);
        horsepowerTextView.setText("Horsepower: " + selectedCar.getHorsepower());

        TextView torqueTextView = findViewById(R.id.torqueTextView);
        torqueTextView.setText("Torque: " + selectedCar.getTorque() + " lb-ft");

        TextView accelerationTimeTextView = findViewById(R.id.accelerationTimeTextView);
        accelerationTimeTextView.setText("0-60 MPH Acceleration Time: " + selectedCar.getAccelerationTime() + " seconds");

        TextView topSpeedTextView = findViewById(R.id.topSpeedTextView);
        topSpeedTextView.setText("Top Speed: " + selectedCar.getTopSpeed() + " MPH");

        // New specifications details
        TextView dimensionsTextView = findViewById(R.id.dimensionsTextView);
        dimensionsTextView.setText("Dimensions: " + selectedCar.getDimensions());

        TextView weightTextView = findViewById(R.id.weightTextView);
        weightTextView.setText("Weight: " + selectedCar.getWeight() + " lbs");

        TextView wheelSizeTextView = findViewById(R.id.wheelSizeTextView);
        wheelSizeTextView.setText("Wheel Size: " + selectedCar.getWheelSize());

        TextView tireSizeTextView = findViewById(R.id.tireSizeTextView);
        tireSizeTextView.setText("Tire Size: " + selectedCar.getTireSize());

        // New seller information details
        TextView sellerNameTextView = findViewById(R.id.sellerNameTextView);
        sellerNameTextView.setText("Seller Name: " + selectedCar.getSellerName());

        TextView contactNumberTextView = findViewById(R.id.contactNumberTextView);
        contactNumberTextView.setText("Contact Number: " + selectedCar.getSellerContact());

        TextView locationTextView = findViewById(R.id.locationTextView);
        locationTextView.setText("Location: " + selectedCar.getSellerLocation());

        TextView sellerRatingTextView = findViewById(R.id.sellerRatingTextView);
        sellerRatingTextView.setText("Seller Rating: " + selectedCar.getSellerRating());

        TextView additionalContactTextView = findViewById(R.id.additionalContactTextView);
        additionalContactTextView.setText("Additional Contact Information: " + selectedCar.getAdditionalContactInfo());
    }
}