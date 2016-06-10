package service;

import po.User;

import java.util.List;


public interface UserService {
    void addUser(User user);

    User get(String id);


    String generateToken(User user);
}