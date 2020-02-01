package com.gdb;

import java.util.ArrayList;

public class Complaints {
    private static int complaintCount;
    private String id;
    private int userId;
    private int busId;
    private String message;
    private boolean isResolved = false;

    public Complaints(int userId, int busId, String message) {
        this.id = String.format("%s%d","Comp-", ++complaintCount);
        this.userId = userId;
        this.busId = busId;
        this.message = message;
    }

    public boolean setResolved(boolean resolved) {
        isResolved = resolved;
        return isResolved;
    }

    public String getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getBusId() {
        return busId;
    }

    public String getMessage() {
        return message;
    }

    public boolean isResolved() {
        return isResolved;
    }
}
