package com.example.autolookbook;

import android.os.Parcel;
import android.os.Parcelable;

public class Car implements Parcelable {
    private String name;
    private String description;
    private int year;
    private double price;
    private int mileage;
    private String transmission;
    private String fuelType;
    private String color;
    private String engineType;
    private String features;
    private String sellerName;
    private String sellerContact;
    private String sellerLocation;
    private int imageResource; // Image resource ID for the car
    private double engineDisplacement;
    private int horsepower;
    private int torque;
    private double accelerationTime;
    private int topSpeed;
    private String dimensions;
    private double weight;
    private String wheelSize;
    private String tireSize;
    private double sellerRating;
    private String additionalContactInfo;

    public Car(String name, String description, int year, double price, int mileage, String transmission, String fuelType, String color, String engineType, String features, String sellerName, String sellerContact, String sellerLocation, int imageResource, double engineDisplacement, int horsepower, int torque, double accelerationTime, int topSpeed, String dimensions, double weight, String wheelSize, String tireSize, double sellerRating, String additionalContactInfo) {
        this.name = name;
        this.description = description;
        this.year = year;
        this.price = price;
        this.mileage = mileage;
        this.transmission = transmission;
        this.fuelType = fuelType;
        this.color = color;
        this.engineType = engineType;
        this.features = features;
        this.sellerName = sellerName;
        this.sellerContact = sellerContact;
        this.sellerLocation = sellerLocation;
        this.imageResource = imageResource;
        this.engineDisplacement = engineDisplacement;
        this.horsepower = horsepower;
        this.torque = torque;
        this.accelerationTime = accelerationTime;
        this.topSpeed = topSpeed;
        this.dimensions = dimensions;
        this.weight = weight;
        this.wheelSize = wheelSize;
        this.tireSize = tireSize;
        this.sellerRating = sellerRating;
        this.additionalContactInfo = additionalContactInfo;
    }

    public Car(String name, String description, int year, double price, int mileage, String transmission, String fuelType, String color, String engineType, String features, String sellerName, String sellerContact, String sellerLocation, int imageResource) {
        this.name = name;
        this.description = description;
        this.year = year;
        this.price = price;
        this.mileage = mileage;
        this.transmission = transmission;
        this.fuelType = fuelType;
        this.color = color;
        this.engineType = engineType;
        this.features = features;
        this.sellerName = sellerName;
        this.sellerContact = sellerContact;
        this.sellerLocation = sellerLocation;
        this.imageResource = imageResource;
    }

    protected Car(Parcel in) {
        name = in.readString();
        description = in.readString();
        year = in.readInt();
        price = in.readDouble();
        mileage = in.readInt();
        transmission = in.readString();
        fuelType = in.readString();
        color = in.readString();
        engineType = in.readString();
        features = in.readString();
        sellerName = in.readString();
        sellerContact = in.readString();
        sellerLocation = in.readString();
        imageResource = in.readInt();
        engineDisplacement = in.readDouble();
        horsepower = in.readInt();
        torque = in.readInt();
        accelerationTime = in.readDouble();
        topSpeed = in.readInt();
        dimensions = in.readString();
        weight = in.readDouble();
        wheelSize = in.readString();
        tireSize = in.readString();
        sellerRating = in.readDouble();
        additionalContactInfo = in.readString();
    }

    public static final Creator<Car> CREATOR = new Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel in) {
            return new Car(in);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerContact() {
        return sellerContact;
    }

    public void setSellerContact(String sellerContact) {
        this.sellerContact = sellerContact;
    }

    public String getSellerLocation() {
        return sellerLocation;
    }

    public void setSellerLocation(String sellerLocation) {
        this.sellerLocation = sellerLocation;
    }

    public double getEngineDisplacement() {
        return engineDisplacement;
    }

    public void setEngineDisplacement(double engineDisplacement) {
        this.engineDisplacement = engineDisplacement;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public int getTorque() {
        return torque;
    }

    public void setTorque(int torque) {
        this.torque = torque;
    }

    public double getAccelerationTime() {
        return accelerationTime;
    }

    public void setAccelerationTime(double accelerationTime) {
        this.accelerationTime = accelerationTime;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(String wheelSize) {
        this.wheelSize = wheelSize;
    }

    public String getTireSize() {
        return tireSize;
    }

    public void setTireSize(String tireSize) {
        this.tireSize = tireSize;
    }

    public double getSellerRating() {
        return sellerRating;
    }

    public void setSellerRating(double sellerRating) {
        this.sellerRating = sellerRating;
    }

    public String getAdditionalContactInfo() {
        return additionalContactInfo;
    }

    public void setAdditionalContactInfo(String additionalContactInfo) {
        this.additionalContactInfo = additionalContactInfo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeInt(year);
        dest.writeDouble(price);
        dest.writeInt(mileage);
        dest.writeString(transmission);
        dest.writeString(fuelType);
        dest.writeString(color);
        dest.writeString(engineType);
        dest.writeString(features);
        dest.writeString(sellerName);
        dest.writeString(sellerContact);
        dest.writeString(sellerLocation);
        dest.writeInt(imageResource);
        dest.writeDouble(engineDisplacement);
        dest.writeInt(horsepower);
        dest.writeInt(torque);
        dest.writeDouble(accelerationTime);
        dest.writeInt(topSpeed);
        dest.writeString(dimensions);
        dest.writeDouble(weight);
        dest.writeString(wheelSize);
        dest.writeString(tireSize);
        dest.writeDouble(sellerRating);
        dest.writeString(additionalContactInfo);
    }
}