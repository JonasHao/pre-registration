package action;

import dao.HospitalDao;
import org.apache.struts2.dispatcher.DefaultActionSupport;
import po.Hospital;

import java.util.List;

/**
 * Created by Koche on 2016/5/11.
 * 展现医院、科室、医生，供用户选择，来预约挂号
 */
public class DisplayAction extends DefaultActionSupport {
    private List<Hospital> hospitals;
    private HospitalDao mHospitalDao;


    public String execute() throws Exception {
        hospitals = mHospitalDao.all();
        return SUCCESS;
    }

    public List<Hospital> getHospitals() {
        return hospitals;
    }

    public void setHospitals(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }

    public void setHospitalDao(HospitalDao hospitalDao) {
        mHospitalDao = hospitalDao;
    }
}
