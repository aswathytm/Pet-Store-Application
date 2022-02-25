package com.repo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Pet;

	public class PetDao {
    private static String jdbcURL = "jdbc:mysql://db:3306/petstore?useSSL=false&allowPublicKeyRetrieval=true";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "qburst123";
    private static final String INSERT_PETS_SQL =  "INSERT INTO `pet`(`name`, `photo`, `categoryid`, `tagid`, `status`) VALUES "+ "(?, ?, ?, ?, ?) ;";
    private static final String SELECT_PET_BY_ID = "SELECT * FROM `pet` WHERE `id` = ?;";
    private static final String SELECT_ALL_PETS =  "SELECT * FROM `pet`;";
    private static final String DELETE_PETS_SQL =  "DELETE FROM `pet` WHERE `id` = ?; ";
    private static final String UPDATE_PETS_SQL =  "update pet set name = ?,photo= ?, categoryid =? , tagid =?, status=? where id = ?;";
   
    public PetDao() {}

    protected static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public List < Pet > selectAllPets() {
        List < Pet > pets = new ArrayList <Pet> ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2: Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PETS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
              	Pet pet = new Pet();
              	pet.setId(rs.getInt(1));
              	pet.setName(rs.getString(2));
              	pet.setPhoto(rs.getString(3));	
              	pet.setCategory(rs.getInt(4));
              	pet.setTag(rs.getInt(5));
              	pet.setStatus(rs.getString(6));
              	pets.add(pet);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return pets;
    }
    public static void insertPet(Pet pet) throws SQLException {
        System.out.println(INSERT_PETS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PETS_SQL)) {
            preparedStatement.setString(1, pet.getName());
            preparedStatement.setString(2, pet.getPhoto());
            preparedStatement.setInt(3, pet.getCategory());
          	preparedStatement.setInt(4, pet.getTag());
          	preparedStatement.setString(5, pet.getStatus());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public static void updatePet(Pet pet) throws SQLException {
        // boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_PETS_SQL);) {
            statement.setString(1, pet.getName());
            statement.setString(2, pet.getPhoto());
            statement.setInt(3, pet.getCategory());
          	statement.setInt(4, pet.getTag());
          	statement.setString(5, pet.getStatus());
            statement.setInt(6, pet.getId());
            System.out.println(statement);
            statement.executeUpdate();
            // rowUpdated = statement.executeUpdate() > 0;
        }
        // return rowUpdated;
    }
    
    public static void deletePet(int id) throws SQLException {
        // boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_PETS_SQL);) {
            statement.setInt(1, id);
            statement.executeUpdate();
            //rowDeleted = statement.executeUpdate() > 0;
        }
        //return rowDeleted;
    }
    //select by id
    public List < Pet > selectPet(int id) {
    	List < Pet > pets = new ArrayList <Pet> ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PET_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
              	Pet pet = new Pet();
              	pet.setId(rs.getInt(1));
              	pet.setName(rs.getString(2));
              	pet.setPhoto(rs.getString(3));
              	pet.setCategory(rs.getInt(4));
              	pet.setTag(rs.getInt(5));
              	pet.setStatus(rs.getString(6));
              	pets.add(pet);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return pets;
    }
    //

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
	
	