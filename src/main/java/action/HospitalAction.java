package action;

import dao.HospitalDao;
import org.apache.struts2.dispatcher.DefaultActionSupport;
import po.Hospital;

import java.util.List;

/**
 * Created by Koche on 2016/5/11.
 * 展现医院、科室、医生，供用户选择，来预约挂号
 */
public class HospitalAction extends DefaultActionSupport {
    private List<Hospital> hospitals;
    private long hospitalID;

    private Hospital hospital;
    private HospitalDao mHospitalDao;


    /***
     * 根据条件查询医院列表, 默认查询所有医院，截取前10条记录
     * @return 医院的列表
     * @throws Exception
     */
    public String query() throws Exception {
        hospitals = mHospitalDao.all();
        return SUCCESS;
    }

    public String get() throws Exception{
        hospital = mHospitalDao.get(hospitalID);
        if(hospital!=null) {
            return SUCCESS;
        }
        return ERROR;
    }

    public List<Hospital> getHospitals() {
        return hospitals;
    }

    public void setHospitalID(long hospitalID) {
        this.hospitalID = hospitalID;
    }

    public long getHospitalID() {
        return hospitalID;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospitals(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }

    public void setHospitalDao(HospitalDao hospitalDao) {
        mHospitalDao = hospitalDao;
    }


}
