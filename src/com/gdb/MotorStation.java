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

    public User getUser(String email){
        ListIterator<User> userListIterator = users.listIterator();
        User user;
        while (userListIterator.hasNext()){
            user = userListIterator.next();
            if(email.equals(user.getEmail())){
                return user;
            }
        }
        return null;
    }
    public ArrayList<Trip> getAvailableTrips() {
        return availableTrips;
    }

    public ArrayList<Trip> getCompletedTrips(){
        return completedTrips;
    }
//    public static Customer deleteUser(String customerId) {
//        if (!customers.contains(customerId)) {
//            System.out.println("User does not exist");
//        } else {
//            customers.remove(customerId);
//            System.out.println("User successfully deleted");
//        }
//        return null;
//    }
//private Customer searchCustomer (String id) {
//    ListIterator<User> customerListIterator = users.listIterator();
//    User customer;
//    while (customerListIterator.hasNext()) {
//        customer = customerListIterator.next();
//        if(id.equals(customer.getCustomerId())) {
//            return customer;
//        }
//    }
//    return null;
//}

    private Trip checkTrip(int tripId){
        ListIterator<Trip> tripListIterator = availableTrips.listIterator();
        Trip trip;
        while (tripListIterator.hasNext()){
            trip = tripListIterator.next();
            if(tripId == trip.getId()){
                return trip;
            }
        }
        return null;
    }