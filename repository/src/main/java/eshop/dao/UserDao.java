package eshop.dao;

import eshop.model.User;

/**
 * DAO for users
 *
 * @author Alexandr Shinkevich on 15/03/2018.
 */
public interface UserDao {
    /**
     * register a user
     * @param user user
     * @return affected rows
     */
    int registerUser(User user);
}
