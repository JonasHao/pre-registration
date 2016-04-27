package service;

import dao.UserDao;
import po.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public User findUserByName(String name) {
        List<User> list = userDao.findUserByName(name);
        if (list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<User> listAll() {
        return userDao.listAll();
    }
}