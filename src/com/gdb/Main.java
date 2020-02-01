package com.gdb;

import java.util.*;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        homePageInstruction();
        Complaints complaint = new Complaints(1, 3, "The driver spent too long at the filling station");
        Complaints complaint2 = new Complaints(1, 3, "The driver spent too long at the filling station");
        Bus bus1 = new Bus("Toyota", 12);
        Bus bus2 = new Bus("Toyota", 12);
        Trip trip1 = new Trip(bus1.getId(), "Obalende", "cms", 10000.00);
        Trip trip2 = new Trip(bus2.getId(), "Obalende", "cms", 10000.00);
        System.out.println(bus1.getBrand());
//        System.out.println(bus1.setAvailableSeats());
        System.out.println(bus1.allocateSeat(12));
        System.out.println(bus1.allocateSeat(11));
        System.out.println(bus1.allocateSeat(6));
        System.out.println(bus1.allocateSeat(8));
        System.out.println(bus1.allocateSeat(4));
        System.out.println(bus1.getAvailableSeats());
        System.out.println(complaint.getId());
        System.out.println(complaint.getMessage());
        System.out.println(complaint2.getId());
        System.out.println(trip1.viewTime());
        System.out.println(trip1.getBusId());
        System.out.println(trip2.getBusId());
        System.out.println(trip2.viewTime());


    }

//    private static void homePageInstruction(){
//        boolean quit = false;
//        System.out.println("welcome to the bus station");
//        while(!quit){
//            System.out.println("Press :::\n" +
//                    "1 - Login\n" +
//                    "2 - Register\n" +
//                    "3 - Login as Admin" +
//                    "0 - Quit");
//
//            nextInt();
//            int number = scanner.nextInt();
//            scanner.nextLine();
//
//            switch(number){
//                case 1:
//                    login();
//                    break;
//                case 2:
//                    register();
//                    break;
//                case 3:
//                    AdminLogin();
//                    break;
//                case 0:
//                    quit = true;
//                    System.out.println("You terminated the application");
//            }
//        }
//    }
//
//    private static void AdminLogin(){
//        System.out.println("Admin Login: ");
//        String email = scanner.nextLine();
//        MotorStation station = user.loginAdmin(email);
//        if(user == null){
//            System.out.println("\n Incorrect Admin login");
//            backButton();
//            return;
//        }
//
//        System.out.println("\n Welcome Admin \n");
//
//        boolean quit = false;
//        while(!quit){
//            System.out.println("Press \n" +
//                    "1 - to add a bus" +
//                    "2 - to remove a bus " +
//                    "3 to resolve complaints" +
//                    "4 - view total cash by bus" +
//                    "5 - view total cash by users" +
//                    "6 - view total cash made" +
//                    "0 - to quit");
//            nextInt();
//            int number = scanner.nextInt();
//            scanner.nextLine();
//
//            switch(number){
//                case 1:
//
//            }
//        }
//    }
//
////    private static void
//
//    private static void backButton() {
//        boolean quit = false;
//
//        while (!quit) {
//            System.out.println("___________________________");
//            System.out.println("0 - to go back");
//            nextInt();
//            int number = scanner.nextInt();
//            scanner.nextLine();
//
//            if(number == 0) {
//                quit = true;
//            }
//        }
//    }
//
//    private static void nextInt() {
//        while(!scanner.hasNextInt()) {
//            scanner.nextLine();
//        }
//    }
}
