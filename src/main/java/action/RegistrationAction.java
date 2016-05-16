package action;

import org.apache.struts2.dispatcher.DefaultActionSupport;
import po.Contact;
import po.Doctor;
import po.Registration;
import service.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Koche on 2016/4/27.
 * 这是挂号的Action，不是用户注册的
 */
public class RegistrationAction extends DefaultActionSupport {
    // Properties
    private long contactID;
    private long doctorID;
    private Date createDate;
    private Calendar reserveDate;

    private List<Contact> contacts;


    // Services
    private DoctorService mDoctorService;
    private CapacityService mCapacityService;
    private RegistrationService mRegistrationService;
    private UserService mUserService;


    public String register() throws Exception {
        // 首先查询选中医生在选中时间段的挂号余量
        int leftCapacity = mCapacityService.
                queryCapacityByDateAndDoctorID(reserveDate, doctorID);

        if (leftCapacity > 0) {
            // 获取订单的医院方信息
            Doctor doctor = mDoctorService.findDoctorByID(doctorID);
            String doctorName = doctor.getName();
            String department = doctor.getDepartment().getName();
            String hospital = doctor.getDepartment().getHospital().getName();


            String userID = "koche";
//            // 获取当前登录的用户的用户ID
//            String userID = mUserService.getCurrentUser().getID();

            Registration registration = new Registration(userID, createDate, reserveDate,
                    hospital, department, doctorName);

            mRegistrationService.create(registration);
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Calendar getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(Calendar reserveDate) {
        this.reserveDate = reserveDate;
    }


    //    public List<Contact> getContacts() {
//        contacts = mContactDao.allOfUser(userID);
//        return contacts;
//    }

    public void setDoctorService(DoctorService DoctorService) {
        mDoctorService = DoctorService;
    }

    public void setCapacityService(CapacityService capacityService) {
        mCapacityService = capacityService;
    }

    public void setUserService(UserService userService) {
        mUserService = userService;
    }

    public void setRegistrationService(RegistrationService registrationService) {
        mRegistrationService = registrationService;
    }
}
