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
        System.out.println("get Capacity of " + id);
        Session session = mSessionFactory.getCurrentSession();
        session.beginTransaction();

        try {
            Capacity capacity = session.get(Capacity.class, id);
            System.out.printf("get capacity class of id:%d is:%s", id, capacity);
            return capacity;
        } catch (Exception e) {
            System.out.println("ERROR CAPACITY");
            e.printStackTrace();
        }

        try {
            @SuppressWarnings("unchecked")
            List<Capacity> capacities = session.createQuery("from Capacity where id=?").setParameter(0, id).list();
            if (capacities.size() > 0) {
                System.out.printf("get capacity query of id:%d is:%s", id, capacities.get(0));
                return capacities.get(0);
            }
        } catch (Exception e) {
            System.out.println("ERROR CAPACITY");
            e.printStackTrace();
        }
        return null;
    }


    public void setSessionFactory(SessionFactory sessionFactory) {
        mSessionFactory = sessionFactory;
    }
}
