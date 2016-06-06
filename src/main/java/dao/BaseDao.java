package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Koche on 2016/6/6.
 * encapsulate C(save) R(get) U(update) D(delete) operations
 */
public class BaseDao<T> {
    private SessionFactory sessionFactory;

    public void save(T t) throws HibernateException {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(t);
    }

    public void save(List<T> ts) throws HibernateException {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        ts.forEach(session::save);
    }

    public T get(Class<T> entityType, Serializable id) throws HibernateException {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        return session.get(entityType, id);
    }

    public T update(T t) throws HibernateException {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(t);
        return t;
    }

    public void delete(T t) throws HibernateException {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(t);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
