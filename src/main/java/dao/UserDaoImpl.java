package dao;

import org.springframework.dao.DataAccessException;
import po.User;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

//@SuppressWarnings("ALL")
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
    @Override
    public String addUser(User user) {
        String success = "";
        String name = user.getName();
        if (findUserByName(name).size() == 0) {
            try {
                getHibernateTemplate().save(user);
                success = "User saved ok!";
            } catch (DataAccessException e) {
                success = "Sorry, user can't be added.";
            }
        } else {
            success = "The username was existed!";
        }
        return success;
    }

    @Override
    public List<User> findUserByName(String name) {
        return (List<User>) getHibernateTemplate().find("from User where name = ?", name);
    }

    @Override
    public List<User> listAll() {
        return (List<User>) getHibernateTemplate().find(" from User ");
    }
}