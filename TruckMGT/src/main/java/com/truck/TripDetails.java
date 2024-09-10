package com.truck;

public class TripDetails {
    private int tripId;
    private String startingLocation;
    private String endingLocation;
    private int distance;
    private String truckName;
    private String truckNumber;
    private String driverName;
    private String driverMobileNo;

    // Getters and Setters
    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
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

    public String getTruckName() {
        return truckName;
    }

    public void setTruckName(String truckName) {
        this.truckName = truckName;
    }

    public String getTruckNumber() {
        return truckNumber;
    }

    public void setTruckNumber(String truckNumber) {
        this.truckNumber = truckNumber;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverMobileNo() {
        return driverMobileNo;
    }

    public void setDriverMobileNo(String driverMobileNo) {
        this.driverMobileNo = driverMobileNo;
    }

    @Override
    public String toString() {
        return "TripDetails{" +
                "tripId=" + tripId +
                ", startingLocation='" + startingLocation + '\'' +
                ", endingLocation='" + endingLocation + '\'' +
                ", distance=" + distance +
                ", truckName='" + truckName + '\'' +
                ", truckNumber='" + truckNumber + '\'' +
                ", driverName='" + driverName + '\'' +
                ", driverMobileNo='" + driverMobileNo + '\'' +
                '}';
    }
}
