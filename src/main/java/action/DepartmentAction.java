package action;

import org.hibernate.HibernateException;
import po.Department;
import po.Hospital;
import service.DepartmentService;
import service.PrivilegeService;

import java.util.List;


/**
 * Created by jinzil on 2016/4/25.
 * 科室相关的Action
 */
public class DepartmentAction extends BaseAction {
    private String userName;
    private long id;
    private String name;
    private String description;
    private String image;
    private Department department;
    private long hospitalID;
    private List<Department> departments;
    private DepartmentService departmentService;
    private PrivilegeService privilegeService;


    public String adminShow() throws Exception {
        try {
            Hospital hospital = privilegeService.getAdminHospital(userName);
            departments=departmentService.showAll(hospital.getId());
            for(Department department:departments){
                department.setOrders(null);
                department.getHospital().setOrders(null);
                department.getHospital().setDepartments(null);
            }
            addData("departments",departments);
            return result = SUCCESS;
        }catch(HibernateException e){
            e.printStackTrace();
            return result=ERROR;
        }
    }

    public String userShow() throws Exception {
        try {
            departments = departmentService.showAll(hospitalID);
            for (Department department : departments) {
                department.setOrders(null);
                department.getHospital().setOrders(null);
                department.getHospital().setDepartments(null);
            }
            addData("departments", departments);
            return result = SUCCESS;
        }catch(HibernateException e){
            e.printStackTrace();
            return result=ERROR;
        }
    }

    public String add()throws Exception{
        try {
            department=new Department();
            department.setName(name);
            department.setImage(image);
            department.setDescription(description);
            Hospital hospital = privilegeService.getAdminHospital(userName);
            department.setHospital(hospital);
            departmentService.add(department);
            return result=SUCCESS;
        }catch(HibernateException e){
           e.printStackTrace();
            return result=ERROR;
       }
    }

    public String delete()throws Exception{
        try {
            departmentService.delete(id);
            return result = SUCCESS;
        }catch(HibernateException e){
            e.printStackTrace();
            return result=ERROR;
        }
    }

    public String update(){
        try {
            department = departmentService.get(id);
            department.setDescription(description);
            department.setName(name);
            department.setImage(image);
            departmentService.update(department);
            return result = SUCCESS;
        }catch(HibernateException e){
            e.printStackTrace();
            return result=ERROR;
        }
    }
    public String adminQuery(){
        try {
            Hospital hospital = privilegeService.getAdminHospital(userName);
            department=departmentService.getDepartmentByName(name, hospital);
            department.setOrders(null);
            department.getHospital().setOrders(null);
            department.getHospital().setDepartments(null);
            addData("department",department);
            return result = SUCCESS;
        }catch(HibernateException e){
            e.printStackTrace();
            return result=ERROR;
        }
    }
    public String userQuery(){
        try {
            departments=departmentService.getDepartmentByName(name);
            for(Department department:departments){
                department.setOrders(null);
                department.getHospital().setOrders(null);
                department.getHospital().setDepartments(null);
            }
            addData("departments",departments);
            return result = SUCCESS;
        }catch(HibernateException e){
            e.printStackTrace();
            return result=ERROR;
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPrivilegeService(PrivilegeService privilegeService) {
        this.privilegeService = privilegeService;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public long getHospitalID() {
        return hospitalID;
    }

    public void setHospitalID(long hospitalID) {
        this.hospitalID = hospitalID;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
