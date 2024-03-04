package com.example.autolookbook;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;


public class RecyclerView extends androidx.recyclerview.widget.RecyclerView.Adapter<RecyclerView.CarViewHolder> {

    private List<Car> carList;

    public RecyclerView(List<Car> carList) {
        this.carList = carList;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_item, parent, false);
        return new CarViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
        Car car = carList.get(position);
        holder.carName.setText(car.getName());
        holder.carDescription.setText(car.getDescription());
        holder.carImage.setImageResource(car.getImageUrl());
    }

    @Override
    public int getItemCount() {
        return carList.size();
    }

    static class CarViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        ImageView carImage;
        TextView carName, carDescription;

        CarViewHolder(View view) {
            super(view);
            carImage = view.findViewById(R.id.carImage);
            carName = view.findViewById(R.id.carName);
            carDescription = view.findViewById(R.id.carDescription);
        }
    }
}
