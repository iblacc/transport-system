package com.gdb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

public class MotorStation {
    ArrayList<Bus> buses;
    ArrayList<Trip> completedTrips;
    ArrayList<Trip> availableTrips;
    ArrayList<User> users;
    ArrayList<Complaints> complaints;


    public MotorStation(){
        this.buses = new ArrayList<>();
        this.completedTrips = new ArrayList<>();
        this.availableTrips = new ArrayList<>();
        this.complaints = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public boolean addBus(String brand, int capacity){

        buses.add(new Bus( brand, capacity));
        return true;
    }