package com.truck;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

       /* Truck truck1 = new Truck("Volvo", "UP-65-2024", "1300");
        Truck truck2 = new Truck("MHENDRA", "UP-70-2022", "1600");

        Driver driver1 = new Driver("Ayush", "A0123", "8299518935");
        Driver driver2 = new Driver("shuddu", "V0125", "8795104121");*/

        TripService tripService = new TripService();
        TruckService truckService = new TruckService();
        DriverService driverService = new DriverService();


        while (true) {
            Scanner scn = new Scanner(System.in);
            System.out.println();
            System.out.println("1:Add Truck Details:");
            System.out.println("2:Show All truck Details:");
            System.out.println("3:Show Truck details By id:");
            System.out.println("4:Delete truck By id:");
            System.out.println("5:Add Driver Details:");
            System.out.println("6:Show Driver Details:");
            System.out.println("7:Show Driver Details By id:");
            System.out.println("8:Add trip details::");
            System.out.println("9:Show All trips details:");
            System.out.println("10:Exit");



            //get choice by admin
            System.out.print("Enter Your choice::");
            int choice = scn.nextInt();

            try {

                switch (choice) {
                    case 1:
                        System.out.println();
                        System.out.print("Enter Truck Name::");
                        String name = scn.next();

                        scn.nextLine();
                        System.out.print("Enter Truck Capacity::");
                        String capacity = scn.nextLine();

                        //enter truck number
                        System.out.print("Enter Truck Number::");
                        String truckNumber = scn.nextLine();

                        Truck t1 = new Truck(name, capacity, truckNumber);
                        truckService.addTruck(t1);
                        break;
                    case 2:
                        System.out.println();
                        System.out.println("============================================================================");
                        System.out.println("----------------------- Show All Truck Details ----------------------------");
                        System.out.println("============================================================================");
                        System.out.printf("%-10s %-20s %-15s %-15s\n", "Truck ID", "Truck Name", "Capacity", "Truck Number");
                        System.out.println("----------------------------------------------------------------------------");

                        List<Truck> allTruck = truckService.getAllTruck();

                        for (Truck truck : allTruck) {
                            System.out.printf("%-10d %-20s %-15s %-15s\n",
                                    truck.getTruckId(),
                                    truck.getTruckName(),
                                    truck.getCapacity(),
                                    truck.getTruckNumber());
                        }

                        System.out.println("============================================================================");

                        System.out.println("============================================================================");
                        break;
                    case 3:
                        System.out.println();
                        System.out.println("================================================================================");
                        System.out.print("Enter Id ::");
                        int id = scn.nextInt();

                        Truck truckById = truckService.getTruckById(id);
                        System.out.print(truckById);
                        break;
                    case 4:
                        System.out.println();
                        System.out.println("============================================================================");
                        System.out.print("Enter Id ::");
                        int delId = scn.nextInt();
                        truckService.deleteById(delId);
                        break;
                    case 5:
                        System.out.println();
                        scn.nextLine();
                        System.out.print("Enter Driver Name::");
                        String driverName = scn.nextLine();

                        System.out.print("Enter License Number::");
                        String licenseNumber = scn.nextLine();

                        System.out.print("Enter Mobile Number::");
                        String mobileNumber = scn.nextLine();

                        //create object of driver and set data
                        Driver driverDetails  = new Driver(driverName,licenseNumber,mobileNumber);

                        //add into database
                        driverService.addDriver(driverDetails);
                        break;
                    case 6:
                        System.out.println();
                        System.out.println("====================================================================================");
                        System.out.println("----------------------------Show All Driver Details----------------------------------");
                        System.out.println("======================================================================================");
                        System.out.printf("%-10s %-20s %-15s %-15s\n", "DriverID", "Driver Name", "License Number", "Contact Number");
                        System.out.println("-----------------------------------------------------------------------------------------");

                        List<Driver> allDriver = driverService.getAllDriver();

                        for (Driver d : allDriver) {
                            System.out.printf("%-10s %-20s %-15s %-15s\n", d.getDriverId(), d.getDriverName(), d.getLicenceNo(), d.getMobileNo());
                        }

                        System.out.println("======================================================================================================");


                        break;
                    case 7:
                        System.out.println();
                        System.out.println("============================================================================");
                        System.out.print("Enter Id ::");
                        int getById = scn.nextInt();
                        Driver detailById = driverService.getDetailById(getById);

                        System.out.print(detailById);
                        break;
                    case 8:
                        //Add trip details
                        System.out.println();
                        List<Truck> allTrucks = truckService.getAllTruck();
                        List<Driver> allDrivers = driverService.getAllDriver();

                        if (allTrucks.size() >= 2 && allDrivers.size() >= 2) {
                            Truck truck1Inserted = allTrucks.get(allTrucks.size() - 2); // Assuming the last two are the new ones
                            Driver driver1Inserted = allDrivers.get(allDrivers.size() - 2);

                            // Creating Trips
                            Trip trip1 = new Trip();
                            trip1.setTruckId(truck1Inserted.getTruckId());
                            trip1.setDriverId(driver1Inserted.getDriverId());
                            System.out.print("Enter starting Location::");
                            String startLoc = scn.nextLine();
                            trip1.setStartingLocation(startLoc);

                            System.out.print("Enter starting Location::");
                            String endLoc = scn.nextLine();
                            trip1.setEndingLocation(endLoc);

                            System.out.print("Enter Distance::");
                            int dis = scn.nextInt();
                            trip1.setDistance(dis);

                            // Adding Trips
                            tripService.addTrip(trip1, truck1Inserted, driver1Inserted);
                        } else {
                            System.out.println("Not enough trucks or drivers to create trips.");
                        }
                    case 9:
                        //show all trips
                        System.out.println();
                        System.out.println("============================================================================================================================================");
                        System.out.println("--------------------------------------------------Show All Trip Details ----------------------------------------------------------------------");
                        System.out.println("===============================================================================================================================================");
                        System.out.printf("%-10s %-20s %-20s %-10s %-20s %-15s %-20s %-15s\n",
                                "Trip ID", "Starting Location", "Ending Location", "Distance",
                                "Truck Name", "Truck Number", "Driver Name", "Driver Mobile No.");
                        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");

                        List<TripDetails> allTrips = tripService.getAllTripDetails();  // Assuming you have a method to get all trips

                        for (TripDetails trip : allTrips) {
                            System.out.printf("%-10d %-20s %-20s %-10d %-20s %-15s %-20s %-15s\n",
                                    trip.getTripId(),
                                    trip.getStartingLocation(),
                                    trip.getEndingLocation(),
                                    trip.getDistance(),
                                    trip.getTruckName(),
                                    trip.getTruckNumber(),
                                    trip.getDriverName(),
                                    trip.getDriverMobileNo());
                        }

                        System.out.println("========================================================================================================================================================");
                        break;
                    case 10:
                        System.out.print("---------------Thank you for using my Application--------------");
                        return;
                    default:
                        System.out.print("invalid choice");
                        break;

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
