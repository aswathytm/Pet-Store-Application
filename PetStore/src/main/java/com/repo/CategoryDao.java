package com.repo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Category;

	public class CategoryDao {
    private static String jdbcURL = "jdbc:mysql://db:3306/petstore?useSSL=false&allowPublicKeyRetrieval=true";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "qburst123";
    private static final String INSERT_CATEGORY_SQL =  "INSERT INTO `category` (`category_name`) VALUES "+ "(?);";
    private static final String SELECT_ALL_CATEGORY =  "SELECT * FROM `category`";
    private static final String DELETE_CATEGORY_SQL =  "DELETE FROM `category` WHERE `id` = ?; ";
   private static final String UPDATE_CATEGORY_SQL =  "update category set category_name = ? where id = ?;";

    public void categoryDao() {}

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

    public List < Category > selectAllCategory() {
        List < Category > category = new ArrayList <Category> ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2: Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
              	Category category1 = new Category();
              	category1.setId(rs.getInt(1));
              	category1.setCategory_name(rs.getString(2));
              	((List<Category>) category1).add(category1);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return category;
    }
    public static void insertCategory(Category category) throws SQLException {
        System.out.println(INSERT_CATEGORY_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CATEGORY_SQL)) {
            preparedStatement.setString(1, category.getCategory_name());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public static void updateCategory(Category category) throws SQLException {
        // boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_CATEGORY_SQL);) {
            statement.setString(1, category.getCategory_name());
            statement.setInt(2, category.getId());
            System.out.println(statement);
            statement.executeUpdate();
            // rowUpdated = statement.executeUpdate() > 0;
        }
        // return rowUpdated;
    }
   
    public static void deleteCategory(int id) throws SQLException {
        // boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_CATEGORY_SQL);) {
            statement.setInt(1, id);
            statement.executeUpdate();
            //rowDeleted = statement.executeUpdate() > 0;
        }
        //return rowDeleted;
    }
    
    
    
  
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


