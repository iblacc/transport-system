package com.gdb;

import java.util.ArrayList;

public class Bus {
    private static int busCount;
    private String id;
    private ArrayList<Trip> completedTrips;
    private String brand;
    private int capacity;
    private ArrayList<Integer> availableSeats= new ArrayList<Integer>();

    public Bus(String brand, int capacity) {
        this.id = String.format("%s%d","Bus-", ++busCount);
        this.brand = brand;
        this.capacity = capacity;
        this.setAvailableSeats();
    }

    public String getId() {
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

    private void setAvailableSeats() {
        for(int seat = 1; seat <= capacity; seat++){
            availableSeats.add(seat);
        }
    }

    public ArrayList<Integer> getAvailableSeats(){
        return availableSeats;
    }

    public int allocateSeat(int bookedSeat){
        int chair = 0;
        for(int seat = 0; seat < availableSeats.size(); seat++){
            if(bookedSeat == availableSeats.get(seat)){
                chair = availableSeats.get(seat);
                availableSeats.remove(seat);
            }
        }
        return chair;
    }
}
