package service;

import po.User;

import java.util.List;


public interface UserService {
    void addUser(User user);

    User findUserByID(String name);

    List<User> listAll();

    User getCurrentUser();
}