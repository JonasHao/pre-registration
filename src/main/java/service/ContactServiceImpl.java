package service;

import dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import po.Contact;

import java.util.List;


public class ContactServiceImpl implements ContactService {
    private BaseDao dao;


    @Override
    public Contact get(long contactID) {
        return dao.get(Contact.class, contactID);

    }

    @Override
    public void add(Contact contact) {
        dao.save(contact);
    }

    @Override
    public void update(Contact contact) {
        dao.update(contact);

    }

    @Override
    public void delete(long contactID) {
        dao.delete(dao.get(Contact.class, contactID));
    }

    public void setDao(BaseDao dao) {
        this.dao = dao;
    }

    @Override
    public Contact getDefault(String userID) {
        return null;
    }


}
