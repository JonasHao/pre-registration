package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import po.Doctor;

import java.util.List;

/**
 * Created by Koche on 2016/5/10.
 */
public class DoctorServiceImpl implements DoctorService {
    private SessionFactory sessionFactory;


    @Override
    public void save(Doctor doctor) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(doctor);
    }

    @Override
    public Doctor get(long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        return session.get(Doctor.class, id);
    }


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
