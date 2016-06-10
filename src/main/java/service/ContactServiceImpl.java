package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import po.Contact;

import java.util.List;


public class ContactServiceImpl implements ContactService {
    private SessionFactory sessionFactory;

    @Override
    public Contact get(String userID, String IDNo) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<Contact> contacts = session.createQuery("from Contact where owner.id=? and idNo=?")
                .setParameter(0, userID).setParameter(1, IDNo).list();
        if (contacts.size() == 1) {
            return contacts.get(0);
        }
        return null;
    }

    @Override
    public Contact get(long contactID) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        return session.get(Contact.class,contactID);
    }

    @Override
    public List<Contact> getAll(String userID) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<Contact> contacts = session.createQuery("from Contact where owner.id=?")
                .setParameter(0, userID).list();
        return contacts;
    }

    @Override
    public Contact getDefault(String userID) {
        return null;
    }


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
