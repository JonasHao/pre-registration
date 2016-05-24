package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import po.Hospital;

import java.util.List;

/**
 * Created by Koche on 2016/5/11.
 * HospitalDao 的hibernate实现
 */
public class HospitalDaoImpl implements HospitalDao {
    private SessionFactory mSessionFactory;

    @Override
    public List<Hospital> all() {
        Session session = mSessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<Hospital> hospitals = session.createQuery("from Hospital").list();
        transaction.commit();
        session.close();
        return hospitals;
    }

    @Override
    public Hospital get(long id) {
        Session session = mSessionFactory.getCurrentSession();
        session.beginTransaction();
        return session.get(Hospital.class, id);
    }


    public void setSessionFactory(SessionFactory sessionFactory) {
        mSessionFactory = sessionFactory;
    }
}
