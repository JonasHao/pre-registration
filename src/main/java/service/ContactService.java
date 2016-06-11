package service;

import po.Contact;

import java.util.List;

/**
 * Created by Koche on 2016/5/20.
 */
public interface ContactService {

    Contact get(long contactID);

    void add(Contact contact);

    void update(Contact contact);

    void delete(long contactID);

    Contact getDefault(String userID);
}
