package com.truck;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TruckService {


    //add truck method
    public void addTruck(Truck truck) throws SQLException {
        String sql = "INSERT INTO truck (truckName, capacity, truckNumber) VALUES (?, ?, ?)";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, truck.getTruckName());
            preparedStatement.setString(2, truck.getCapacity());
            preparedStatement.setString(3, truck.getTruckNumber());

            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Truck added successfully!");
            } else {
                System.out.println("Failed to add truck.");
            }
        }
    }

    //Show trucks
    public List<Truck> getAllTruck() throws SQLException {
        List<Truck> trucks = new ArrayList<>();
        String sql = "SELECT * FROM truck";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Truck t1 = new Truck();
                t1.setTruckId(resultSet.getInt("truckId"));
                t1.setTruckName(resultSet.getString("truckName"));
                t1.setCapacity(resultSet.getString("capacity"));
                t1.setTruckNumber(resultSet.getString("truckNumber"));
                trucks.add(t1);
            }
        }
        return trucks;
    }

    //get truck by id
    public Truck getTruckById(int id) throws SQLException{
        Truck t1 = new Truck();
        String sql = "select * from truck where truckId = ?";

        Connection connection = DbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
                t1.setTruckId(resultSet.getInt("truckId"));
                t1.setTruckName(resultSet.getString("truckName"));
                t1.setCapacity(resultSet.getString("capacity"));
                t1.setTruckNumber(resultSet.getString("truckNumber"));
        }

        return t1;
    }

    //delete by id
    public  void deleteById(int id) throws SQLException{
        String sql = "delete from truck where truckId = ?";

        Connection connection = DbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);

        int deleteById = preparedStatement.executeUpdate();

        if(deleteById>0){
            System.out.print("----------Your truck detail deleted successfully-------------");
        }else{
            System.out.print("---------------Something Went Wrong----------------------------");
        }

    }

}
