package com.truck;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TripService {

    // Adding Trip
    public void addTrip(Trip tri, Truck truck, Driver driver) {
        String sql = "INSERT INTO trip (truckId, driverId, startingLocation, endingLocation, distance) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, truck.getTruckId());
            preparedStatement.setInt(2, driver.getDriverId());
            preparedStatement.setString(3, tri.getStartingLocation());
            preparedStatement.setString(4, tri.getEndingLocation());
            preparedStatement.setInt(5, tri.getDistance());

            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Trip added successfully!!");
            } else {
                System.out.println("Failed to add the trip!!");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Improved error handling
            throw new RuntimeException("Error adding trip: " + e.getMessage(), e);
        }
    }

    // Show all Trips
    public List<Trip> getAllTrips() {
        String sql = "SELECT * FROM trip";
        List<Trip> trips = new ArrayList<>();
        try (Connection connection = DbConnection.getConnection();
             Statement statement = connection.createStatement();
             ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Trip trip = new Trip();
                trip.setTripId(resultSet.getInt("tripId"));
                trip.setTruckId(resultSet.getInt("truckId"));
                trip.setDriverId(resultSet.getInt("driverId"));
                trip.setStartingLocation(resultSet.getString("startingLocation"));
                trip.setEndingLocation(resultSet.getString("endingLocation"));
                trip.setDistance(resultSet.getInt("distance"));
                trips.add(trip);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Improved error handling
            throw new RuntimeException("Error retrieving trips: " + e.getMessage(), e);
        }
        return trips;
    }

    //get all trip details
    public List<TripDetails> getAllTripDetails() {
        String sql = "SELECT trip.tripId, trip.startingLocation, trip.endingLocation, trip.distance, " +
                "truck.truckName, truck.truckNumber, driver.driverName, driver.mobileNo " +
                "FROM trip " +
                "INNER JOIN truck ON trip.truckId = truck.truckId " +
                "INNER JOIN driver ON trip.driverId = driver.driverId";
        List<TripDetails> tripDetailsList = new ArrayList<>();
        try (Connection connection = DbConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                TripDetails details = new TripDetails();
                details.setTripId(resultSet.getInt("tripId"));
                details.setStartingLocation(resultSet.getString("startingLocation"));
                details.setEndingLocation(resultSet.getString("endingLocation"));
                details.setDistance(resultSet.getInt("distance"));
                details.setTruckName(resultSet.getString("truckName"));
                details.setTruckNumber(resultSet.getString("truckNumber"));
                details.setDriverName(resultSet.getString("driverName"));
                details.setDriverMobileNo(resultSet.getString("mobileNo"));

                tripDetailsList.add(details);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Improved error handling
            throw new RuntimeException("Error retrieving trip details: " + e.getMessage(), e);
        }
        return tripDetailsList;
    }



}
