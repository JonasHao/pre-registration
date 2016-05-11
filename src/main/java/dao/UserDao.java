package dao;

import po.User;

import java.util.List;

public interface UserDao {
    String addUser(User user);

    User findUserByID(String name);

    List<User> listAll();
}