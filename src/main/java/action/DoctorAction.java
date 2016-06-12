package action;

import po.Capacity;
import po.Department;
import po.Doctor;
import service.DepartmentService;
import service.DoctorService;
import service.PrivilegeService;

import java.util.List;
import java.util.Map;


public class DoctorAction extends BaseAction {
    private long id;
    private String name = null;
    private String introduction = null;
    private String title = null;
    private String image = null;
    private Doctor doctor;

    private List<Long> doctorList;

    private long departmentId = -1;

    private DoctorService doctorService;
    private DepartmentService departmentService;
    private PrivilegeService privilegeService;



    public String add() throws Exception
    {
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
        if (null != doctor) {
            doctorService.add(doctor);
            return result = SUCCESS;
        }
        addFieldError("doctor", "医生不合法", "103");
        return result = ERROR;
    }

    public String delete() throws Exception
    {
        doctorService.delete(id);
        return result = SUCCESS;
    }

    public String update() throws  Exception
    {
        Doctor doctor = doctorService.get(id);
        if (departmentId != -1) {
            Department department = departmentService.get(departmentId);
            if (department == null) {
                addFieldError("department", "部门不存在", "102");
                return result = ERROR;
            }
            doctor.setDepartment(department);
        }
        if (name != null)
        {
            doctor.setName(name);
        }
        if (introduction != null)
        {
            doctor.setIntroduction(introduction);
        }
        if (title != null)
        {
            doctor.setTitle(title);
        }
        if (image != null)
        {
            doctor.setImage(image);
        }
        doctorService.update(doctor);
        return result = SUCCESS;
    }

    public String get() throws Exception {
        Doctor doctor = doctorService.get(id);
        if (doctor != null){
            doctor.getDepartment().setHospital(null);
            doctor.getDepartment().setDoctors(null);
            doctor.getDepartment().setOrders(null);
            for (Capacity capacity : doctor.getCapacities())
            {
                capacity.setDoctor(null);
            }
            doctor.setOrders(null);

            addData("doctor", doctor);
            return result = SUCCESS;
        }
        return result = ERROR;
    }

    public String getDoctors() throws Exception {
        List<Doctor> doctorList = doctorService.getDoctorByName(name);
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
