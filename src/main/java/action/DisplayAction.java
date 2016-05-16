package action;

import dao.ContactDao;
import dao.ContactDaoImpl;
import dao.HospitalDao;
import org.apache.struts2.dispatcher.DefaultActionSupport;
import po.Contact;
import po.Hospital;
import service.UserService;

import java.util.List;

/**
 * Created by Koche on 2016/5/11.
 * 展现医院、科室、医生，供用户选择，来预约挂号
 */
public class DisplayAction extends DefaultActionSupport {
    private List<Hospital> hospitals;
    private List<Contact> contacts;
    private HospitalDao mHospitalDao;
    private ContactDao mContactDao;
    private UserService mUserService;

    private Hospital selectedHospital;


    public String execute() throws Exception {
        hospitals = mHospitalDao.all();
        String userID = mUserService.getCurrentUser().getID();
        contacts = mContactDao.allOfUser(userID);
        return SUCCESS;
    }

    public List<Hospital> getHospitals() {
        return hospitals;
    }

    public List<Contact> getContacts() {
        return contacts;
    }


    public void setHospitals(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }

    public void setHospitalDao(HospitalDao hospitalDao) {
        mHospitalDao = hospitalDao;
    }


    public void setUserService(UserService userService) {
        mUserService = userService;
    }

    public Hospital getSelectedHospital() {
        return selectedHospital;
    }

    public void setSelectedHospital(Hospital selectedHospital) {
        this.selectedHospital = selectedHospital;
    }


    public void setContactDao(ContactDao contactDao) {
        mContactDao = contactDao;
    }
}
