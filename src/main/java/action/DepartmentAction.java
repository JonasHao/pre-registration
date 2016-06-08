package action;



import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.org.apache.xml.internal.serializer.SerializerTrace;
import org.apache.struts2.dispatcher.DefaultActionSupport;
import org.hibernate.HibernateException;
import org.springframework.ejb.access.EjbAccessException;
import po.Department;
import po.Hospital;
import po.Privilege;
import service.DepartmentService;
import service.PrivilegeService;


/**
 * Created by jinzil on 2016/4/25.
 * 科室相关的Action
 */
public class DepartmentAction extends BaseAction {
    private long id;
    private String name;
    private String description;
    private DepartmentService departmentService;
    private PrivilegeService privilegeService;

    public void setPrivilegeService(PrivilegeService privilegeService) {
        this.privilegeService = privilegeService;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    //
    public String get() throws Exception {

        return SUCCESS;

    }

    public String add()throws Exception{
        try {
            Hospital hospital = privilegeService.getAdminHospital();
            Department department = new Department(name, description, hospital);
            departmentService.add(department);
            return result=SUCCESS;
        }catch(HibernateException e){
            e.printStackTrace();
            return result=ERROR;
        }
    }

    public String delete()throws Exception{
          return result= SUCCESS;
    }
    public void update(){

    }
    public void adminQuery(){
        Hospital hospital = privilegeService.getAdminHospital();
        departmentService.getDepartmentByName(this.name,hospital);
    }
    public void userQuery(){
        departmentService.getDepartmentByName(this.name);
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


}
