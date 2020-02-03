package com.gdb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Customer extends User {
    private static int idCounter = 0;
    private String customerId;
    private double accBalance;
    ArrayList<Complaints> complaints;
    Set<Trip> trips;

    public Customer(String name, String email, String phoneNumber, String address) {
        super(name, email, phoneNumber, address);
        this.customerId = "CUS" + String.format("%03d", ++idCounter);
        this.accBalance = 0;
        this.complaints = new ArrayList<>();
        this.trips = new HashSet<>();

    }


    public static int getIdCounter() {
        return idCounter;
    }


    public String getCustomerId() {
        return customerId;
    }

    public double getAccBalance() {
        return accBalance;
    }

    public ArrayList<Complaints> getComplaints() {
        return complaints;
    }

    public Set<Trip> getTrips() {
        return trips;
    }

    public void addToTrips(Trip trip){
        trips.add(trip);
    }

    public boolean deposit(double amount){
        this.accBalance += amount;
        return true;
    }
    public boolean withdraw(double amount){
        if(accBalance >= amount) {
            this.accBalance -= amount;
            return true;
        }
        return false;
    }

    public void addToComplaints(Complaints complaint){
        complaints.add(complaint);
    }

}