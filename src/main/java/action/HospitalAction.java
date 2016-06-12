package action;

import po.Department;
import service.HospitalService;
import po.Hospital;
import service.UserService;
import service.UserServiceImpl;

import java.util.ArrayList;
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

    private String hospitalName;
    private String hospitalDes;
    private String hospitalAddress_province;
    private String hospitalAddress_city;
    private String hospitalAddress_area;
    private String hospitalAddress_detail;

    private Hospital hospital;
    private HospitalService hospitalService;

    private List<Hospital> objects;
    private Hospital object;


    /***
     * 根据条件查询医院列表, 默认查询所有医院，截取前10条记录
     *
     * @return 医院的列表
     * @throws Exception
     */
    //增加医院
    public String addHospital() throws Exception {
        hospital = new Hospital();
        hospital.setName(hospitalName);
        hospital.setDescription(hospitalDes);
        hospital.setAddress_province(hospitalAddress_province);
        hospital.setAddress_city(hospitalAddress_city);
        hospital.setAddress_area(hospitalAddress_area);
        hospital.setAddress_detail(hospitalAddress_detail);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(hospitalName + hospitalDes);
        hospitalService.addHospital(hospital);

        //再次显示所有医院列表
        query();

        return result = SUCCESS;
    }

    //删除医院
    public String deleteHospital() throws Exception{
        // todo： 捕捉Hibernate异常
        hospitalService.deleteHospital(hospitalID);

        //再次显示所有医院列表
        query();

        return result = SUCCESS;
    }

    //修改医院
    public String updateHospital() throws Exception{
        hospital = hospitalService.getByID(hospitalID);
        // todo:数据校验。判断是否为空，不为空再set
//        hospital.setName(hospitalName);
//        hospital.setDescription(hospitalDes);
//        hospital.setAddress_province(hospitalAddress_province);
//        hospital.setAddress_city(hospitalAddress_city);
//        hospital.setAddress_area(hospitalAddress_area);
//        hospital.setAddress_detail(hospitalAddress_detail);
//        hospitalService.updateHospital(hospital);
//
        if(hospital != null){
            hospital.setName("嘉璇大好人");
        }

        System.out.println(hospital.getName());
        hospitalService.updateHospital(hospital);

        //再次显示所有医院列表
        query();

        return result = SUCCESS;
    }

    //显示所有医院列表
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



    //通过医院ID来获取医院信息
    public String getHospitalByID() throws Exception {
        hospital = hospitalService.getByID(hospitalID);
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

    //通过医院名称来获取医院信息
    public String getHospitalByName() throws Exception {
        Hospital hospital_list;
        hospitals = hospitalService.getByName(hospitalName);
        if (hospitals != null) {
            // prevent serialize orders
            for (Hospital hospital1 : hospitals) {
                hospital_list = hospital1;
                if (hospital_list != null) {
                    hospital_list.setOrders(null);
                    for (Department department : hospital_list.getDepartments()) {
                        department.setOrders(null);
                        department.setDoctors(null);
                        department.setHospital(null);
                    }
                }
            }
            addData("hospitals",hospitals);
            return result = SUCCESS;
        }
        return result = ERROR;
    }

    //通过医院地址来获得医院信息
    public String getHospitalByAddress() throws Exception{
        Hospital hospital_list;
        hospitals = hospitalService.getByAddress(hospitalAddress_province, hospitalAddress_city, hospitalAddress_area);
        if(hospitals != null){
            for (Hospital hospital1 : hospitals) {
                hospital_list = hospital1;
                if (hospital_list != null) {
                    hospital_list.setOrders(null);
                    for (Department department : hospital_list.getDepartments()) {
                        department.setOrders(null);
                        department.setDoctors(null);
                        department.setHospital(null);
                    }
                }
            }
            addData("hospitals", hospitals);
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

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalDes() {
        return hospitalDes;
    }

    public void setHospitalDes(String hospitalDes) {
        this.hospitalDes = hospitalDes;
    }

    public String getHospitalAddress_province() {
        return hospitalAddress_province;
    }

    public void setHospitalAddress_province(String hospitalAddress_province) {
        this.hospitalAddress_province = hospitalAddress_province;
    }

    public String getHospitalAddress_city() {
        return hospitalAddress_city;
    }

    public void setHospitalAddress_city(String hospitalAddress_city) {
        this.hospitalAddress_city = hospitalAddress_city;
    }

    public String getHospitalAddress_area() {
        return hospitalAddress_area;
    }

    public void setHospitalAddress_area(String hospitalAddress_area) {
        this.hospitalAddress_area = hospitalAddress_area;
    }

    public String getHospitalAddress_detail() {
        return hospitalAddress_detail;
    }

    public void setHospitalAddress_detail(String hospitalAddress_detail) {
        this.hospitalAddress_detail = hospitalAddress_detail;
    }


    public List<Hospital> getObjects() {
        return objects;
    }

    public void setObjects(List<Hospital> objects) {
        this.objects = objects;
    }

    public Hospital getObject() {
        return object;
    }

    public void setObject(Hospital object) {
        this.object = object;
    }

    @Override
    public Map<String, Object> getData() {
        return super.getData();
    }
}
