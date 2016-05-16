package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import po.Contact;

import java.util.List;

/**
 * Created by Koche on 2016/5/13.
 */
public class ContactDaoImpl implements ContactDao {
    private SessionFactory mSessionFactory;

    @Override
    public List<Contact> allOfUser(String userID) {
        Session session = mSessionFactory.getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<Contact> contacts = session.createQuery("from Contact where ownerId=?").
                setParameter(0, userID).list();

        return contacts;
    }

    @Override
    public void save(Contact contact) {
        Session session = mSessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(contact);
        transaction.commit();
        session.flush();
        session.close();

    }

    @Override
    public void remove(Contact contact) {

    }


    public void setSessionFactory(SessionFactory sessionFactory) {
        mSessionFactory = sessionFactory;
    }
}
