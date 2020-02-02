package com.gdb;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.lang.String;

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

    public String getBusId(){
        return bus.getId();
    }

    public int getId() {
        return id;
    }

    public boolean completeTrip(){
        this.isCompleted = true;
        return this.isCompleted;
    }