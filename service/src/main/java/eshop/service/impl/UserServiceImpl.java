package eshop.service.impl;

import eshop.dao.UserDao;
import eshop.dao.impl.UserDaoImpl;
import eshop.model.User;
import eshop.service.UserService;

/**
 * Service for users
 *
 * @author Alexandr Shinkevich on 15/03/2018.
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public int registerUser(User user) {
        return userDao.registerUser(user);
    }
}
