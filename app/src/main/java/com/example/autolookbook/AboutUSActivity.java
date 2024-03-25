package com.example.autolookbook;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;


public class AboutUSActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // Enable the back button in the toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Initialize TextView
        TextView aboutUsTextView = findViewById(R.id.about_us_text_view);

        // Set the text programmatically
        String aboutUsText = "AutoLookBook Creators.\n\n" +
                "We are AutoLookBook, a passionate team dedicated to providing car enthusiasts with the best experience when it comes to exploring and discovering new cars.\n\n" +
                "Our mission is to create a platform that offers comprehensive information about a wide range of vehicles, from classic cars to the latest models. Whether you're a seasoned car collector or a casual enthusiast, we aim to be your go-to resource for all things automotive.\n\n" +
                "At AutoLookBook, we believe in the power of technology to enhance the way people interact with cars. Through our innovative platform, users can browse through detailed car profiles, access expert reviews, compare specifications, and even visualize vehicles in stunning 3D.\n\n" +
                "We're committed to delivering accurate and up-to-date information to help you make informed decisions when buying, selling, or simply admiring cars. With our user-friendly interface and rich content, we strive to make your car browsing experience as enjoyable and informative as possible.\n\n" +
                "Thank you for choosing AutoLookBook. Join us on this exciting journey as we continue to redefine the way people connect with cars.\n\n" +
                "Contact Us:\n" +
                "Email: info@autolookbook.com\n" +
                "Phone: +1 (123) 456-7890\n" +
                "Address: 123 Auto Drive, City, State, ZIP Code";

      aboutUsTextView.setText(aboutUsText);
    }
    public boolean onSupportNavigateUp() {
        // Handle the back button press
        onBackPressed();
        return true;
    }
}
