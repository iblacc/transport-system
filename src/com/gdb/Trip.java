package com.gdb;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.lang.String;
import java.util.HashMap;

public class Trip {
    private static int idCounter = 0;
    private int id;
    private Bus bus;
    private String from;
    private String to;
    private double amount;
    private Date time;
    private ArrayList<Customer> passenger;
    private ArrayList<Integer> availableSeats;
    private HashMap<String, ArrayList<Integer>> seatOwners;
    private boolean isCompleted = false;

    public Trip(Bus bus, String from, String to, double amount) {
        this.bus = bus;
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.id = ++idCounter;
        this.passenger = new ArrayList<>();
        this.availableSeats = new ArrayList<Integer>();
        this.seatOwners = new HashMap<>();
        this.time = new Date();
    }

    public Date viewTime(){
        return this.time;
    }


    public double getAmount() {
        return amount;
    }


    public int getId() {
        return id;
    }

    public boolean completeTrip(){
        this.isCompleted = true;
        return this.isCompleted;
    }
    public void addPassenger(Customer customer){
        passenger.add(customer);
    }
    private void setAvailableSeats() {
        int capacity = bus.getCapacity();
        for(int seat = 1; seat <= capacity; seat++){
            availableSeats.add(seat);
        }
    }

    public ArrayList<Integer> getAvailableSeats(){
        return availableSeats;
    }

    public void setSeatOwner(String customerId, int seatNo) {
        ArrayList<Integer> seats = this.seatOwners.get(customerId);
        if(seats != null){
            seats.add(seatNo);
            this.seatOwners.put(customerId, seats);
            return;
        }
        this.seatOwners.put(customerId, new ArrayList<Integer>(seatNo));
    }

    public HashMap<String, ArrayList<Integer>> getSeatOwner() {
        return seatOwners;
    }

    public void allocateSeat(int bookedSeat){
        int seatsAvailable = availableSeats.size();
        for(int seat = 0; seat < seatsAvailable; seat++)
            if (bookedSeat == availableSeats.get(seat)) {
                availableSeats.remove(seat);
                break;
            }
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public Bus getBus() {
        return bus;
    }

    public double totalAmountMade() {
        return passenger.size() * amount;
    }
}
