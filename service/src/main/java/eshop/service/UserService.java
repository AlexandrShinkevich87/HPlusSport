package eshop.service;

import eshop.model.User;

/**
 * Service for users
 *
 * @author Alexandr Shinkevich on 15/03/2018.
 */
public interface UserService {
    /**
     * register a user
     * @param user user
     * @return affected rows
     */
    int registerUser(User user);
}
