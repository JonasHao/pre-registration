package action;

import dao.DepartmentDao;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.dispatcher.DefaultActionSupport;
import po.Department;


/**
 * Created by jinzil on 2016/4/25.
 * 科室相关的Action
 */
public class DepartmentAction extends DefaultActionSupport {
    private long id;
    private Department department;
    private DepartmentDao mDepartmentDao;


    public String get() throws Exception {
        department = mDepartmentDao.get(id);
        if (department != null) {
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setDepartmentDao(DepartmentDao departmentDao) {
        mDepartmentDao = departmentDao;
    }
}
