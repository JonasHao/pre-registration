package service;

import com.opensymphony.xwork2.ActionContext;
import dao.BaseDao;
import org.hibernate.HibernateException;
import po.User;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private BaseDao userDao;

    @Override
    public boolean addUser(User user) {
        try {
            userDao.save(user);
            return true;
        }catch (HibernateException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User findUserByID(String name) {
        return userDao.get(User.class, name);
    }


    @Override
    public String getCurrentUserID() {
        ActionContext context = ActionContext.getContext();
        Map session = context.getSession();
        return (String) session.get("username");
    }

    @Override
    public String generateToken(User user) {
        return "fake token";
    }

    public void setBaseDao(BaseDao baseDao) {
        this.userDao = baseDao;
    }
}