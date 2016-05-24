package service;

import po.Contact;

import java.util.List;

/**
 * Created by Koche on 2016/5/20.
 */
public interface ContactService {
    Contact get(String userID, String IDNo);

    Contact get(long contactID);

    List<Contact> getAll(String userID);

    Contact getDefault(String userID);
}
