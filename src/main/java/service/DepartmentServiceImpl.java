package service;

import dao.BaseDao;
import org.hibernate.HibernateException;
import po.Department;
import po.Hospital;
import po.Privilege;
import po.User;

import java.util.List;

/**
 * Created by jinzil on 2016/6/8.
 */
public class DepartmentServiceImpl implements DepartmentService {
    private BaseDao departmentDao;

    @Override

    public void add(Department department) {
        departmentDao.save(department);
    }

    @Override
    public List<Department> getDepartmentByName(String name) {
        return departmentDao.query("from Department where name=?").setParameter(0,name).list();
    }

    @Override
    public Department getDepartmentByName(String name, Hospital hospital){
        long hospitalId=hospital.getId();
        return (Department)departmentDao.query("from Department where name=? and hospitalId=?").setParameter(0,name)
                .setParameter(1,hospitalId).list().get(0);
    }

    @Override
    public Department get(long id) {
        return departmentDao.get(Department.class,id);
    }
    @Override
    public List<Department> showAll(long hospitalID){
        return departmentDao.query("from Department where hospitalID=?").setParameter(0,hospitalID).list();
    }
    @Override
    public void update(Department department) {
        departmentDao.update(department);
    }

    @Override
    public void delete(long id) {
       // Department department=(Department) departmentDao.query("from Department where Department.id=?")
        //        .setParameter(0,id).list().get(0);
        Department department=departmentDao.get(Department.class,id);
        departmentDao.delete(department);
    }

    public void setDepartmentDao(BaseDao departmentDao) {
        this.departmentDao = departmentDao;
    }
}
