package com.truck;

public class Truck {
    private int truckId;
    private String truckName;
    private String capacity;
    private String truckNumber;

    public Truck() {
        super();
    }
    @Override
    public String toString() {
        return "Truck{" +
                "truckId=" + truckId +
                ", truckName='" + truckName + '\'' +
                ", capacity='" + capacity + '\'' +
                ", truckNumber='" + truckNumber + '\'' +
                '}';
    }

    public int getTruckId() {
        return truckId;
    }

    public void setTruckId(int truckId) {
        this.truckId = truckId;
    }

    public String getTruckName() {
        return truckName;
    }

    public void setTruckName(String truckName) {
        this.truckName = truckName;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getTruckNumber() {
        return truckNumber;
    }

    public void setTruckNumber(String truckNumber) {
        this.truckNumber = truckNumber;
    }

    public Truck(String truckName, String truckNumber,String capacity) {
        this.truckName = truckName;
        this.truckNumber = truckNumber;
        this.capacity = capacity;
    }
}
