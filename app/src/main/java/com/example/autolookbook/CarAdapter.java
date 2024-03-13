package com.example.autolookbook;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarViewHolder> {
    private Context context;
    private List<Car> carList;

    public CarAdapter(Context context, List<Car> carList) {
        this.context = context;
        this.carList = carList;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.car_item_layout, parent, false); // Ensure you have a layout file 'car_item_layout.xml' for individual car items
        return new CarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
        Car car = carList.get(position);
        holder.carName.setText(car.getName());
        holder.carDescription.setText(car.getDescription());
        holder.carImage.setImageResource(car.getImageResource()); // Ensure your Car class has an appropriate method to get the image resource
        holder.moreInfoButton.setOnClickListener(view -> {
            Intent intent = new Intent(context, CarDetailActivity.class); // Ensure you have a CarDetailActivity defined
            intent.putExtra("CAR_NAME", car.getName());
            intent.putExtra("CAR_DESCRIPTION", car.getDescription());
            context.startActivity(intent);

        });
    }

    @Override
    public int getItemCount() {
        return carList.size();
    }

    public static class CarViewHolder extends RecyclerView.ViewHolder {
        ImageView carImage;
        TextView carName, carDescription;
        Button moreInfoButton; // Ensure your car_item_layout has a Button with the appropriate ID

        public CarViewHolder(@NonNull View itemView) {
            super(itemView);
            carImage = itemView.findViewById(R.id.carImage); // Adjust IDs based on your car_item_layout
            carName = itemView.findViewById(R.id.carName);
            carDescription = itemView.findViewById(R.id.carDescription);
            moreInfoButton = itemView.findViewById(R.id.moreInfoButton);
        }
    }
}
