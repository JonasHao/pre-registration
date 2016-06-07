package dao;

import org.hibernate.*;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Koche on 2016/6/6.
 * encapsulate C(save) R(get) U(update) D(delete) operations
 */
public class BaseDao {
    protected SessionFactory sessionFactory;

    public void save(Object o) throws HibernateException {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(o);
    }

    public void save(List<Object> ts) throws HibernateException {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        ts.forEach(session::save);
    }

    public <T> T get(Class<T> entityType, Serializable id) throws HibernateException {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        return session.get(entityType, id);
    }

    public Query query(String queryString) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        return session.createQuery(queryString);
    }

    public Object update(Object o) throws HibernateException {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(o);
        return o;
    }

    public void delete(Object o) throws HibernateException {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(o);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
