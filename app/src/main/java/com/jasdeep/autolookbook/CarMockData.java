package com.jasdeep.autolookbook;

import java.util.ArrayList;
import java.util.List;

public class CarMockData {

    public static List<Car> generateMockCars() {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car(
                "Kia Seltos",
                "Compact SUV with advanced features",
                2020,
                25000,
                30000,
                "Automatic",
                "Petrol",
                "Red",
                "4-Cylinder",
                "GPS, Bluetooth, Rearview Camera",
                "John Doe",
                "+1234567890",
                "New York", R.drawable.kia_seltos,
                2.0, 180, 200, 6.5, 130,
                "4500mm x 1850mm x 1620mm", 1500, "18-inch", "235/65 R18",
                4.5, "john.doe@example.com"
        ));

        cars.add(new Car(
                "Mahindra Thar",
                "Off-road SUV with rugged design",
                2019,
                20000,
                40000,
                "Manual",
                "Diesel",
                "Black",
                "6-Cylinder",
                "4x4 Drive, LED Lights",
                "Jane Smith",
                "+1987654321",
                "Los Angeles", R.drawable.mahindra_thar,
                3.0, 200, 250, 8.0, 110,
                "4000mm x 1800mm x 1900mm", 1800, "16-inch", "245/70 R16",
                4.2, "jane.smith@example.com"
        ));

        cars.add(new Car(
                "Lexus IS",
                "Luxury sedan with premium features",
                2021,
                45000,
                20000,
                "Automatic",
                "Hybrid",
                "Silver",
                "V6 Engine",
                "Leather Seats, Sunroof",
                "Mike Johnson",
                "+1122334455",
                "Chicago", R.drawable.lexus_is,
                3.5, 250, 300, 5.5, 155,
                "4800mm x 1800mm x 1450mm", 1600, "17-inch", "225/55 R17",
                4.7, "mike.johnson@example.com"
        ));

        cars.add(new Car(
                "Tesla Model X",
                "Electric SUV with futuristic design",
                2022,
                80000,
                10000,
                "Automatic",
                "Electric",
                "White",
                "Dual Motor",
                "Autopilot, Falcon Wing Doors",
                "Emily Williams",
                "+1567890123",
                "San Francisco", R.drawable.tesla_model_x,
                5.0, 400, 500, 4.5, 160,
                "5000mm x 2000mm x 1700mm", 2000, "20-inch", "255/45 R20",
                4.9, "emily.williams@example.com"
        ));

        cars.add(new Car(
                "Honda Civic",
                "Compact car with sporty design",
                2020,
                22000,
                35000,
                "CVT",
                "Petrol",
                "Blue",
                "Inline-4",
                "Apple CarPlay, Android Auto",
                "Chris Taylor",
                "+1456789012",
                "Houston", R.drawable.honda_civic,
                1.8, 160, 170, 8.0, 120,
                "4500mm x 1750mm x 1450mm", 1400, "16-inch", "205/55 R16",
                4.0, "chris.taylor@example.com"
        ));

        cars.add(new Car(
                "Hyundai Elantra",
                "Sleek sedan with modern features",
                2021,
                24000,
                30000,
                "Automatic",
                "Petrol",
                "Gray",
                "Inline-4",
                "Wireless Charging, Blind-Spot Detection",
                "Sarah Brown",
                "+1678901234",
                "Miami", R.drawable.hyundai_elantra,
                2.0, 170, 190, 7.0, 140,
                "4600mm x 1750mm x 1500mm", 1450, "17-inch", "215/60 R17",
                4.3, "sarah.brown@example.com"
        ));

        return cars;
    }
}