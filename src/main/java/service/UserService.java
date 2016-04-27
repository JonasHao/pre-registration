package service;

import po.User;

import java.util.List;
/**
 * Created by zl on 1/21/2015.
 */
public interface UserService {
     String addUser(User user);
     User findUserByName(String name);
     List<User> listAll();
}