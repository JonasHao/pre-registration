package action;

import org.hibernate.Session;
import org.hibernate.Transaction;
import po.*;
import service.CapacityService;
import service.ContactService;
import org.apache.struts2.dispatcher.DefaultActionSupport;
import service.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Koche on 2016/4/27.
 * 这是挂号的Action，不是用户注册的
 */
public class RegistrationAction extends DefaultActionSupport {
    private long contactID;
    private long doctorID;
    private long capacityID;
    private Date createDate;

    private Capacity capacity;
    private Contact contact;
    private List<Contact> contacts;

    private String doctorName;
    private String department;
    private String hospital;
    private String slot;

    private DoctorService mDoctorService;
    private RegistrationService mRegistrationService;
    private UserService mUserService;
    private CapacityService capacityService;


    public String fillOrder() throws Exception {
        Doctor doctor = mDoctorService.get(doctorID);
        doctorName = doctor.getName();
        department = doctor.getDepartment().getName();
        hospital = doctor.getDepartment().getHospital().getName();

        capacity = capacityService.get(capacityID);
        if (capacity == null) {
            return "out";
        }

        slot = capacity.getSlotString();

        String userID = mUserService.getCurrentUserID();

        if (userID == null) {
            return INPUT;
        }

        contacts = mUserService.findUserByID(userID).getContacts();
        if (contacts.size() > 0) {
            for (Contact c : contacts) {
                if (c.isDefault()) {
                    contact = c;
                    break;
                }
            }
            if (contact == null) {
                contact = contacts.get(0);
            }
        }

        return SUCCESS;
    }


    /**
     * 需要的参数：capacityID, contactID
     *
     * @return "out"表示用户过期，需重新登陆。
     * @throws Exception
     */
    public String order() throws Exception {
        String userID = mUserService.getCurrentUserID();
        if (userID == null) {
            return "out";
        }

        if (mRegistrationService.create(userID, capacityID, contactID)) {
            return SUCCESS;
        }

        return INPUT;
    }

    public String unRegister() throws Exception {
        return SUCCESS;
    }


    // getters and setters
    public long getContactID() {
        return contactID;
    }

    public void setContactID(long contactID) {
        this.contactID = contactID;
    }

    public long getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(long doctorID) {
        this.doctorID = doctorID;
    }

    public long getCapacityID() {
        return capacityID;
    }

    public void setCapacityID(long capacityID) {
        this.capacityID = capacityID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public Capacity getCapacity() {
        return capacity;
    }

    public void setCapacity(Capacity capacity) {
        this.capacity = capacity;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public void setDoctorService(DoctorService DoctorService) {
        mDoctorService = DoctorService;
    }

    public void setUserService(UserService userService) {
        mUserService = userService;
    }

    public void setRegistrationService(RegistrationService registrationService) {
        mRegistrationService = registrationService;
    }


    public void setCapacityService(CapacityService capacityService) {
        this.capacityService = capacityService;
    }

}
