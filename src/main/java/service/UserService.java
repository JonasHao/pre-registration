package service;

import po.User;

import java.util.List;


public interface UserService {
    boolean addUser(User user);

    User findUserByID(String name);

    String getCurrentUserID();

    String generateToken(User user);
}