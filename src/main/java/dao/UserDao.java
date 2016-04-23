package dao;

import po.User;

import java.util.List;

public interface UserDao {
    String addUser(User user);

    List<User> findUserByName(String name);

    List<User> listAll();
}