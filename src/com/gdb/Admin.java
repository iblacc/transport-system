package com.gdb;

public class Admin extends User {
    private static int idCounter = 0;
    String adminId;


    public Admin(String name, String email, String phoneNumber, String address) {
        super(name, email, phoneNumber, address);
        this.adminId = "AD" + String.format("%03d", ++idCounter);
    }

    public String getId() {
        return adminId;
    }

}
