package service;

import po.User;

import java.util.List;


public interface UserService {
    void signUp(User user);

    User get(String id);


    String generateToken(User user);
}