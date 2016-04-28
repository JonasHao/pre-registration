package dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import po.User;

import java.util.List;


public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;


    @Override
    public String addUser(User user) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().save(user);
        sessionFactory.getCurrentSession().close();
        return "ok";
    }

    @Override
    public List<User> findUserByName(String name) {
        sessionFactory.getCurrentSession().beginTransaction();
        Query query = sessionFactory.getCurrentSession().createQuery("from User where username = ?").setParameter(0, name);

        query.list().forEach(System.out::println);
        return query.list();
    }

    @Override
    public List<User> listAll() {
        sessionFactory.getCurrentSession().beginTransaction();
        return (List<User>) sessionFactory.getCurrentSession().createQuery(" from User ");
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}