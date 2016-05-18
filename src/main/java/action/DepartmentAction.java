package action;

import dao.DepartmentDao;

import org.apache.struts2.dispatcher.DefaultActionSupport;
import po.Department;

import java.util.List;


/**
 * Created by jinzil on 2016/4/25.
 * 科室相关的Action
 */
public class DepartmentAction extends DefaultActionSupport {
    private long hospitalID;
    private List<Department> departments;
    private DepartmentDao mDepartmentDao;

    public String queryDepartments() throws Exception {
        if (hospitalID >= 0) {
            departments = mDepartmentDao.getAllOfHospital(hospitalID);
            return SUCCESS;
        } else {
            return ERROR;
        }
    }


    public long getHospitalID() {
        return hospitalID;
    }

    public void setHospitalID(long hospitalID) {
        this.hospitalID = hospitalID;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public void setDepartmentDao(DepartmentDao departmentDao) {
        mDepartmentDao = departmentDao;
    }
}
