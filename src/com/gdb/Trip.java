package com.gdb;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.lang.String;

public class Trip {
    private static int id;
    private String busId;
    private String from;
    private String to;
    private double amount;
    private Date time = new Date();
    private ArrayList<Customer> passenger;
    private boolean isCompleted = false;

    public Trip(String busId, String from, String to, double amount) {
        this.busId = busId;
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public Date viewTime(){
        return this.time;
    }

    public String getBusId() {
        return busId;
    }

    public boolean completeTrip(){
        this.isCompleted = true;
        return this.isCompleted;
    }
}
