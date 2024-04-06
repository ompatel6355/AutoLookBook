package com.example.autolookbook;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.autolookbook.Car;
import com.example.autolookbook.R;
import com.example.autolookbook.CarDetailsActivity;

import java.util.List;


public class CustomCarListAdapter extends BaseAdapter {

    private Context context;
    private List<Car> carList;
    private LayoutInflater inflater;

    public CustomCarListAdapter(Context context, List<Car> carList) {
        this.context = context;
        this.carList = carList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return carList.size();
    }

    @Override
    public Object getItem(int position) {
        return carList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.activity_custom_list_view, parent, false);
            holder = new ViewHolder();
            holder.carIcon = convertView.findViewById(R.id.carIcon);
            holder.carName = convertView.findViewById(R.id.carName);
            holder.moreInfoButton = convertView.findViewById(R.id.moreInfoButton);
            // Set click listener for the More Info button
            holder.moreInfoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Get the car object associated with this position
                    Car selectedCar = carList.get(position);

                    // Start the CarDetailsActivity and pass the selected car details
                    Intent intent = new Intent(context, CarDetailsActivity.class);
                    intent.putExtra("selectedCar", selectedCar);
                    context.startActivity(intent);
                }
            });
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Car car = carList.get(position);

        holder.carIcon.setImageResource(car.getImageResource());
        holder.carName.setText(car.getName());

        return convertView;
    }

    static class ViewHolder {
        ImageView carIcon;
        TextView carName;
        Button moreInfoButton; // Added moreInfoButton
        // Add other views here as needed
        // For example: TextView carYear, carPrice, etc.
    }
}