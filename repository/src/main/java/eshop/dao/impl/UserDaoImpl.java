package eshop.dao.impl;

import eshop.dao.DBConnection;
import eshop.dao.UserDao;
import eshop.model.User;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * DAO for users
 *
 * @author Alexandr Shinkevich on 15/03/2018.
 */
public class UserDaoImpl implements UserDao {
    @Override
    public int registerUser(User user) {
        int rowsAffected = 0;

        // get the connection for the database
        try (Connection connection = DBConnection.getConnectionToDatabase()) {

            // write the insert query
            String insertQuery = "insert into (username, password, first_name, last_name, age, activity) users values(?,?,?,?,?,?)";

            // set parameters with PreparedStatement
            try (java.sql.PreparedStatement statement = connection.prepareStatement(insertQuery)) {
                statement.setString(1, user.getUsername());
                statement.setString(2, user.getPassword());
                statement.setString(3, user.getFirstName());
                statement.setString(4, user.getLastName());
                statement.setInt(5, user.getAge());
                statement.setString(6, user.getActivity());

                // execute the statement
                rowsAffected = statement.executeUpdate();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowsAffected;

    }
}
