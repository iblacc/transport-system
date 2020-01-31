package com.gdb;

import java.util.ArrayList;
import java.util.Date;
import java.lang.String;

public class Trip {
    private int id;
    private int busId;
    private String from;
    private String to;
    private double amount;
    private Date time;
    private ArrayList<Customer> passenger;
    private boolean isCompleted;

    public Trip(int id, int busId, String from, String to, double amount, Date time, ArrayList<Customer> passenger, boolean isCompleted) {
        this.id = id;
        this.busId = busId;
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.time = time;
        this.passenger = passenger;
        this.isCompleted = isCompleted;
    }
}
