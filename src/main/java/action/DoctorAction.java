package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.dispatcher.DefaultActionSupport;
import po.Department;
import po.Doctor;
import po.Hospital;
import service.DepartmentService;
import service.DoctorService;
import service.PrivilegeService;

import javax.print.Doc;
import java.util.List;
import java.util.Map;


public class DoctorAction extends BaseAction {
    private long id;
    private String name;
    private String introduction;
    private String title;
    private String image;
    private Doctor doctor;

    private List<Long> doctorList;

    private long departmentId;

    private DoctorService doctorService;
    private DepartmentService departmentService;
    private PrivilegeService privilegeService;



    public String add() throws Exception
    {
        if (privilegeService.getAdminHospital() == null)
        {
            addFieldError("user", "用户权限不足", "110");
            return result = ERROR;
        }
        if (name == null) {
            addFieldError("name", "没有输入名字", "101");
            return result = ERROR;
        }
        Department department = departmentService.get(departmentId);
        if (department == null)
        {
            addFieldError("departmentId", "部门不存在", "102");
            return result = ERROR;
        }

        Doctor doctor = new Doctor(name, introduction, department, title, image);
        if (doctor != null) {
            doctorService.add(doctor);
            return result = SUCCESS;
        }
        addFieldError("doctor", "医生不合法");
        return result = ERROR;
    }

    public String delete() throws Exception
    {
        if (privilegeService.getAdminHospital() == null)
        {
            addFieldError("user", "用户权限不足", "110");
            return result = ERROR;
        }
        doctorService.delete(id);
        return result = SUCCESS;
    }

    public String update() throws  Exception
    {
        if (privilegeService.getAdminHospital() == null)
        {
            addFieldError("user", "用户权限不足", "110");
            return result = ERROR;
        }
        Doctor doctor = doctorService.get(id);
        Department department = departmentService.get(departmentId);
        if (department == null)
        {
            addFieldError("department", "部门不存在", "102");
            return result = ERROR;
        }
        doctor.setDepartment(department);
        doctorService.update(doctor);
        return result = SUCCESS;
    }

    public String getDoctors() throws Exception {
        List<Doctor> doctorList = doctorService.getDoctorByNmae(name);
        if (doctorList.size() != 0){
            for(Doctor doctor : doctorList)
            {
                doctor.getDepartment().setHospital(null);
                doctor.getDepartment().setDoctors(null);
                doctor.getDepartment().setOrders(null);
                doctor.setCapacities(null);
                doctor.setOrders(null);
            }
            addData("doctors", doctorList);
            return result = SUCCESS;
        }
        return result = ERROR;
    }

    @Override
    public Map<String, Object> getData() {
        return super.getData();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public DoctorService getDoctorService() {
        return doctorService;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public List<Long> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<Long> doctorList) {
        this.doctorList = doctorList;
    }

    public PrivilegeService getPrivilegeService() {
        return privilegeService;
    }

    public void setPrivilegeService(PrivilegeService privilegeService) {
        this.privilegeService = privilegeService;
    }

}
