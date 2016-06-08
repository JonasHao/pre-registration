package service;

import com.opensymphony.xwork2.ActionContext;
import dao.BaseDao;
import org.hibernate.HibernateException;
import po.User;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private BaseDao userDao;

    @Override
    public void addUser(User user) {
        userDao.save(user);
    }

    @Override
    public User get(String name) {
        return userDao.get(User.class, name);
    }


    @Override
    public String generateToken(User user) {
        return "fake token";
    }

    public void setBaseDao(BaseDao baseDao) {
        this.userDao = baseDao;
    }
}