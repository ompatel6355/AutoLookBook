package com.example.autolookbook;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class CarActivity extends AppCompatActivity {

    private List<Car> carList = new ArrayList<>();
    private androidx.recyclerview.widget.RecyclerView carRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carRecyclerView = findViewById(R.id.carRecyclerView);
        carRecyclerView.setHasFixedSize(true);
        carRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Populate the car list
        carList.add(new Car("Car Name 1", "Description 1", R.drawable.logo));
        carList.add(new Car("Car Name 2", "Description 2", R.drawable.logo));
        // Add more cars as needed

        RecyclerView adapter = new RecyclerView(carList);
        carRecyclerView.setAdapter(adapter);
    }
}
