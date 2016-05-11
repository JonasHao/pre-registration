package dao;

import org.hibernate.SessionFactory;
import po.Registration;


/**
 * Created by Koche on 2016/5/10.
 */
public class RegistrationDaoImpl implements RegistrationDao {
    private SessionFactory mSessionFactory;


    public void setSessionFactory(SessionFactory sessionFactory) {
        mSessionFactory = sessionFactory;
    }

    @Override
    public void create(Registration registration) {
        mSessionFactory.getCurrentSession().beginTransaction();
        mSessionFactory.getCurrentSession().save(registration);
        mSessionFactory.getCurrentSession().close();
    }
}
