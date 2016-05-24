package service;

import com.opensymphony.xwork2.ActionContext;
import dao.UserDao;
import po.User;

import java.util.List;
import java.util.Map;

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
    public String getCurrentUserID() {
        ActionContext context = ActionContext.getContext();
        Map session = context.getSession();
        return (String)session.get("username");
    }
}