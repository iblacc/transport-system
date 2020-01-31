package com.gdb;

import java.util.ArrayList;

public class Bus {
    private int id;
    private ArrayList<Trip> completedTrips;
    private String brand;
    private int capacity;
    private ArrayList<Integer> availableSeats;

    public Bus(int id, ArrayList<Trip> completedTrips, String brand, int capacity, ArrayList<Integer> availableSeats) {
        this.id = id;
        this.completedTrips = completedTrips;
        this.brand = brand;
        this.capacity = capacity;
        this.availableSeats = availableSeats;
    }

    public int getId() {
        return id;
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

    public ArrayList<Integer> getAvailableSeats() {
        return availableSeats;
    }
}
