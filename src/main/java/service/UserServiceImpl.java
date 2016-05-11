package service;

import dao.UserDao;
import po.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public User findUserByID(String name) {
        return userDao.findUserByID(name);
    }

    @Override
    public List<User> listAll() {
        return userDao.listAll();
    }

    @Override
    public User getCurrentUser() {
        return null;
    }
}