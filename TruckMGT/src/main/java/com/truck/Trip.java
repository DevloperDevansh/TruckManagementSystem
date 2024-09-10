package com.truck;

public class Trip {
    private int tripId;
    private Truck truck;
    private Driver driver;
    private String startingLocation;
    private String endingLocation;
    private int distance;
    private int truckId;
    private int driverId;
    public Trip() {
    }

    public Trip(Truck truck, Driver driver, String startingLocation, String endingLocation, int distance) {
        this.truck = truck;
        this.driver = driver;
        this.startingLocation = startingLocation;
        this.endingLocation = endingLocation;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "tripId=" + tripId +
                ", startingLocation='" + startingLocation + '\'' +
                ", endingLocation='" + endingLocation + '\'' +
                ", distance=" + distance +
                ", truckId=" + truckId +
                ", driverId=" + driverId +
                '}';
    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public int getTruckId() {
        return truckId;
    }

    public void setTruckId(int truckId) {
        this.truckId = truckId;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getStartingLocation() {
        return startingLocation;
    }

    public void setStartingLocation(String startingLocation) {
        this.startingLocation = startingLocation;
    }

    public String getEndingLocation() {
        return endingLocation;
    }

    public void setEndingLocation(String endingLocation) {
        this.endingLocation = endingLocation;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
