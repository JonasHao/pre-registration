package action;
import po.Contact;
import po.User;
import service.ContactService;
import service.PrivilegeService;

import java.util.Map;

/**
 * Created by Koche on 2016/4/27.
 * 存储常用病人信息
 */
public class ContactAction extends BaseAction {
    private ContactService contactService;
    private PrivilegeService privilegeService;
    private String name;
    private String idNo;
    private String phone;
    private long contactID;

    public String create() throws Exception {
        try {
            Contact contact = new Contact(name, idNo, phone);
            User user= privilegeService.getCurrentUser();
            if(user == null){
                addFieldError("username","未登录","000");
                return result=ERROR;
            }
            contact.setOwner(privilegeService.getCurrentUser());
            contactService.add(contact);
            return result = SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return result = ERROR;
        }
    }

    public String modify() throws Exception {
        try {
            Contact contact = contactService.get(contactID);
            contact.setIdNo(idNo);
            contact.setName(name);
            contact.setPhone(phone);
            contactService.update(contact);
            return result = SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return result = ERROR;
        }
    }

    public String delete() throws Exception {
        try{
            contactService.delete(contactID);
            return result=SUCCESS;
        }catch (Exception e){
            return result=ERROR;
        }
    }

    public String query() throws Exception {
        try {
            User user = privilegeService.getCurrentUser();
            addData("contacts", user.getContacts());
            return result = SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return result = ERROR;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getContactID() {
        return contactID;
    }

    public void setContactID(long contactID) {
        this.contactID = contactID;
    }

    public void setContactService(ContactService contactService) {
        this.contactService = contactService;
    }


    @Override
    public Map<String, Object> getData() {
        return super.getData();
    }

    public void setPrivilegeService(PrivilegeService privilegeService) {
        this.privilegeService = privilegeService;
    }
}
