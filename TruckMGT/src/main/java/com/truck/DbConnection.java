package com.truck;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String URL="jdbc:mysql://localhost:3306/TruckManagement";
    private static final String USERNAME="root";
    private static final String PASS="Ayush@321";

    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASS);
        return connection;
    }
}
