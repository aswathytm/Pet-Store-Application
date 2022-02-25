package com.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.User;

public class LoginDao {

    //insert another user
    public static void insertUser(User user) throws ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://db:3306/petstore?useSSL=false&allowPublicKeyRetrieval=true", "root", "qburst123");

            // Create a statement using connection object
            PreparedStatement preparedStatement = connection
            .prepareStatement("INSERT INTO `user` (`username`, `password`) VALUES (?, ?);")) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    
    
    //error code
    private static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}

