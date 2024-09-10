package com.truck;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DriverService {

    //adding Driver
    public void addDriver(Driver d1) throws SQLException {
            String sql = "INSERT INTO driver (driverName, licenceNo, mobileNo) VALUES (?, ?, ?)";

            Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("Driver Name: " + d1.getDriverName());
        System.out.println("Licence No: " + d1.getLicenceNo());
        System.out.println("Mobile No: " + d1.getMobileNo());

            preparedStatement.setString(1, d1.getDriverName());
            preparedStatement.setString(2, d1.getLicenceNo());
            preparedStatement.setString(3, d1.getMobileNo());

            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("--------------Driver added successfully!!--------------------");
            } else {
                System.out.println("--------------Failed to add driver---------------------------");
            }
    }

    public List<Driver> getAllDriver() throws SQLException {
        List<Driver> drivers = new ArrayList<>();
        String sql = "SELECT * FROM driver";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Driver d1 = new Driver();
                d1.setDriverId(resultSet.getInt("driverId"));
                d1.setDriverName(resultSet.getString("driverName"));
                d1.setLicenceNo(resultSet.getString("licenceNo"));
                d1.setMobileNo(resultSet.getString("mobileNo"));
                drivers.add(d1);
            }
        }
        return drivers;
    }

    //show driver detail by id
    public Driver getDetailById(int id) throws SQLException{
        Driver driver = new Driver();
        String sql = "select * from driver where driverId = ?";

        Connection connection = DbConnection.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);

        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
           driver.setDriverId(resultSet.getInt("driverId"));
           driver.setDriverName(resultSet.getString("driverName"));
           driver.setLicenceNo(resultSet.getString("licenceNo"));
           driver.setMobileNo(resultSet.getString("mobileNo"));
        }

        return driver;
    }

}
