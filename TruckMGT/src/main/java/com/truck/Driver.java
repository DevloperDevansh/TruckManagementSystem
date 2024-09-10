package com.truck;

public class Driver {
    private int driverId;
    private String driverName;
    private String licenceNo;
    private String mobileNo;

    public Driver() {
    }

    public Driver(String driverName, String licenceNo, String mobileNo) {

        this.driverName = driverName;
        this.licenceNo = licenceNo;
        this.mobileNo = mobileNo;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverId=" + driverId +
                ", driverName='" + driverName + '\'' +
                ", licenceNo='" + licenceNo + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                '}';
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getLicenceNo() {
        return licenceNo;
    }

    public void setLicenceNo(String licenceNo) {
        this.licenceNo = licenceNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
