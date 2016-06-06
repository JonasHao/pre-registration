package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import po.User;

import java.util.Iterator;
import java.util.List;


public class UserDaoImpl extends BaseDao<User> {

    private SessionFactory sessionFactory;



    public User findUserByID(String ID) {
        sessionFactory.getCurrentSession().beginTransaction();

        List list = sessionFactory.getCurrentSession().
                createQuery("from User where ID = ?").
                setParameter(0, ID).list();

        if (list.size()>0) {
            Object object = list.get(0);
            System.out.println(object);
            return (User) object;
        }

        return null;
    }

    public List<User> listAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<User> list = sessionFactory.getCurrentSession().createQuery(" from User ").list();
        return list;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}