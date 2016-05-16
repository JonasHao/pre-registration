package dao;

import po.Contact;

import java.util.List;


/**
 * Created by Koche on 2016/5/13.
 */
public interface ContactDao {
    List<Contact> allOfUser(String userID);

    void save(Contact contact);

    void remove(Contact contact);

}
