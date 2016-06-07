package action;

import po.Department;
import service.HospitalService;
import po.Hospital;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Koche on 2016/5/11.
 * 展现医院、科室、医生，供用户选择，来预约挂号
 */
public class HospitalAction extends BaseAction {
    private List<Hospital> hospitals;
    private long hospitalID;

    private Hospital hospital;
    private HospitalService hospitalService;


    /***
     * 根据条件查询医院列表, 默认查询所有医院，截取前10条记录
     *
     * @return 医院的列表
     * @throws Exception
     */
    public String query() throws Exception {
        hospitals = hospitalService.all();
        // prevent serialize departments and orders
        for(Hospital hospital :hospitals){
            hospital.setOrders(null);
            hospital.setDepartments(null);
        }
        addData("hospitals", hospitals);
        return result = SUCCESS;
    }

    public String get() throws Exception {
        hospital = hospitalService.get(hospitalID);
        if (hospital != null) {
            // prevent serialize orders
            hospital.setOrders(null);
            for(Department department :hospital.getDepartments()){
                department.setOrders(null);
                department.setDoctors(null);
                department.setHospital(null);
            }
            addData("hospital",hospital);
            return result = SUCCESS;
        }
        return result = ERROR;
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

    public void setHospitalDao(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }


    @Override
    public Map<String, Object> getData() {
        return super.getData();
    }
}
