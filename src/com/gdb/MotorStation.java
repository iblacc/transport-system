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

    public boolean removeBus(String id){
        Bus bus = checkBus(id);

        if(bus != null){
            this.buses.remove(bus);
            return true;
        } else {
            return false;
        }
    }

    private Bus checkBus(String id){
        ListIterator<Bus> busListIterator = buses.listIterator();
        Bus bus;
        while (busListIterator.hasNext()){
            bus = busListIterator.next();
            if(id.equals(bus.getId())){
                return bus;
            }
        }
        return null;
    }

    public void registerAdmin(String name, String email, String phoneNumber, String address){
        Admin admin = new Admin(name, email, phoneNumber, address);
        this.users.add(admin);

    }

    public void registerCustomer(String name, String email, String phoneNumber, String address){
        Customer customer = new Customer(name, email, phoneNumber, address);
        this.users.add(customer);

    }