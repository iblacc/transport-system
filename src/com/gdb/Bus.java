gpackage com.gdb;

import java.util.ArrayList;

import java.util.ArrayList;

public class Bus {
    private ArrayList<Trip> completedTrips;
    private String brand;
    private int capacity;
    private String plateNumber;
    private boolean onTrip;


    public Bus(String brand, int capacity, String plateNumber) {
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.capacity = capacity;
        this.completedTrips = new ArrayList<>();
    }

    public ArrayList<Trip> getCompletedTrips() {
        return completedTrips;
    }

    public String getBrand() {
        return brand;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isOnTrip() {
        return onTrip;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setOnTrip(boolean onTrip) {
        this.onTrip = onTrip;
    }
}