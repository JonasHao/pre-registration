package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import po.Capacity;

import java.util.List;


public class CapacityServiceImpl implements CapacityService {
    private SessionFactory mSessionFactory;

    @Override
    public void refresh(Capacity capacity) {
        Session session = mSessionFactory.getCurrentSession();
        session.beginTransaction();
        session.refresh(capacity);
    }

    @Override
    public Capacity get(long id) {

        return null;
    }


    public void setSessionFactory(SessionFactory sessionFactory) {
        mSessionFactory = sessionFactory;
    }
}
