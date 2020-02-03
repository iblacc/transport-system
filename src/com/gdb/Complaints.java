package com.gdb;

import java.util.ArrayList;

public class Complaints {
    private static int complaintCount = 0;
    private int id;
    private User user;
    private Trip trip;
    private String message;
    private boolean isResolved = false;

    public Complaints(User user, Trip trip, String message) {
        this.id = ++complaintCount;
        this.user = user;
        this.trip = trip;
        this.message = message;
    }

    public boolean setResolved(boolean resolved) {
        isResolved = resolved;
        return isResolved;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Trip getTrip() {
        return trip;
    }

    public String getMessage() {
        return message;
    }

    public boolean isResolved() {
        return isResolved;
    }

}