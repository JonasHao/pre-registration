package action;

import dao.ContactDao;
import org.apache.struts2.dispatcher.DefaultActionSupport;
import po.Contact;

import java.util.Set;

/**
 * Created by Koche on 2016/4/27.
 * 存储常用病人信息
 */
public class ContactAction extends DefaultActionSupport {
    private Set<Contact> contacts;
    private ContactDao mContactDao;


    public String create() throws Exception {
        return SUCCESS;
    }

    public String modify() throws Exception {
        return SUCCESS;
    }

    public String delete() throws Exception {
        return SUCCESS;
    }

    public String query() throws Exception {
        return SUCCESS;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }
}
