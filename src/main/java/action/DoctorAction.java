package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.dispatcher.DefaultActionSupport;
import po.Doctor;
import service.DoctorService;


public class DoctorAction extends DefaultActionSupport {
    private long id;
    private Doctor doctor;
    private DoctorService doctorService;


    public String get() throws Exception {
        doctor = doctorService.get(id);
        if (doctor != null) {
            return SUCCESS;
        }
        return ERROR;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }


    public void setDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
}
