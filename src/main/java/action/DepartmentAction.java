package action;



import org.apache.struts2.dispatcher.DefaultActionSupport;
import po.Department;


/**
 * Created by jinzil on 2016/4/25.
 * 科室相关的Action
 */
public class DepartmentAction extends DefaultActionSupport {
    private long id;
    private Department department;




    //
    public String get() throws Exception {

        return SUCCESS;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

}
