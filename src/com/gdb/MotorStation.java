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


    public MotorStation() {
        this.buses = new ArrayList<>();
        this.completedTrips = new ArrayList<>();
        this.availableTrips = new ArrayList<>();
        this.complaints = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public boolean addBus(String brand, int capacity, String plateNumber) {
        Bus bus = checkBus(plateNumber);
        if (bus != null) {
            buses.add(new Bus(brand, capacity, plateNumber));
            return true;
        }
        return false;
    }


    public boolean removeBus(String plateNumber) {
        Bus bus = checkBus(plateNumber);

        if (bus != null) {
            this.buses.remove(bus);
            return true;
        }
        return false;
    }

    private Bus checkBus(String plateNumber) {
        ListIterator<Bus> busListIterator = buses.listIterator();
        Bus bus;
        while (busListIterator.hasNext()) {
            bus = busListIterator.next();
            if (plateNumber.equals(bus.getPlateNumber())) {
                return bus;
            }
        }
        return null;
    }

    public void registerAdmin(String name, String email, String phoneNumber, String address) {
        Admin admin = new Admin(name, email, phoneNumber, address);
        this.users.add(admin);

    }

    public void registerCustomer(String name, String email, String phoneNumber, String address) {
        Customer customer = new Customer(name, email, phoneNumber, address);
        this.users.add(customer);

    }

    public User getUser(String email) {
        ListIterator<User> userListIterator = users.listIterator();
        User user;
        while (userListIterator.hasNext()) {
            user = userListIterator.next();
            if (email.equals(user.getEmail())) {
                return user;
            }
        }
        return null;
    }

    public ArrayList<Trip> getAvailableTrips() {
        return availableTrips;
    }

    public ArrayList<Trip> getCompletedTrips() {
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
    public double totalCashByBus(Bus bus) {
        ArrayList<Trip> completedTrips = bus.getCompletedTrips();
        return getCash(completedTrips);
    }

    public double totalCash() {
        return getCash(completedTrips);
    }

    private double getCash(ArrayList<Trip> trips) {
        ListIterator<Trip> tripListIterator = trips.listIterator();
        Trip trip;
        double totalAmount = 0;

        while (tripListIterator.hasNext()) {
            trip = tripListIterator.next();
            totalAmount += trip.totalAmountMade();
        }
        return totalAmount;
    }

    private Trip checkTrip(int tripId) {
        ListIterator<Trip> tripListIterator = availableTrips.listIterator();
        Trip trip;
        while (tripListIterator.hasNext()) {
            trip = tripListIterator.next();
            if (tripId == trip.getId()) {
                return trip;
            }
        }
        return null;
    }

    public boolean createTrip(String fromLocation, String toLocation, double amount) {
        ListIterator<Bus> busListIterator = buses.listIterator();
        Bus bus;
        while (busListIterator.hasNext()) {
            bus = busListIterator.next();
            if (!bus.isOnTrip()) {
                bus.setOnTrip(true);
                Trip trip = new Trip(bus, fromLocation, toLocation, amount);
                availableTrips.add(trip);
                return true;
            }
        }
        return false;
    }

    public boolean bookTrip(Customer customer, Trip trip, int seatNo) {
//        Trip trip = checkTrip(tripId);
        if (customer.withdraw(trip.getAmount())) {
            trip.addPassenger(customer);
            trip.allocateSeat(seatNo);
            trip.setSeatOwner(customer.getCustomerId(), seatNo);
            customer.addToTrips(trip);
            return true;
        }
        return false;

    }

    public void completeTrip(int tripId) {
        Trip trip = availableTrips.get(tripId);
        trip.setCompleted(true);
        trip.getBus().setOnTrip(false);
        completedTrips.add(trip);
        availableTrips.remove(tripId);
    }


    public void makeComplaints(String message, Customer customer, int tripId) {
        Complaints complaint = new Complaints(message, tripId, customer.getCustomerId());
        complaints.add(complaint);
        customer.addToComplaints(complaint);
    }

    public boolean resolveComplaints(int complaintId) {
        ListIterator<Complaints> resolveComplaints = complaints.listIterator();
        Complaints complaint;
        while (resolveComplaints.hasNext()) {
            complaint = resolveComplaints.next();
            if (!complaint.isResolved()) {
                complaint.setResolved(true);
                return true;
            }
        }
        return false;

    }
}