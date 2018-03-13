package eshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Retrieve db connection
 */
public class DBConnection {

    /**
     * get connection to the database
     * and then you need a method for doing the transaction
     * @return Connection
     */
    public static Connection getConnectionToDatabase() {
        Connection connection = null;

        try {

            // load the driver class
            Class.forName("org.h2.Driver");
            System.out.println("H2 JDBC Driver Registered!");

            // get hold of the DriverManager
            String url = "jdbc:h2:tcp://localhost/~/test"; // "jdbc:h2:~/test"
            String username = "sa";
            String password = "";
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your H2 JDBC Driver?");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();

        }

        if (connection != null) {
            System.out.println("Connection made to DB!");
        }
        return connection;
    }

}
