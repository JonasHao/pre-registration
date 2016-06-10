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
public class DepartmentServiceImlp implements DepartmentService {
    private BaseDao departmentDao;
    private User user;
    @Override

    public void add(Department department) {

        departmentDao.save(department);
//        try {
//            departmentDao.save(department);
//            return true;
//        } catch (HibernateException e) {
//            e.printStackTrace();
//            return false;
//        }
//
//    }
//        return false;
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
    public void update(Department department) {
        departmentDao.update(department);
    }

    @Override
    public void delete(long id) {
        Object department=departmentDao.query("from Department,Privilege where Department.id=?")
                .setParameter(0,id).list().get(0);
        departmentDao.delete(department);
    }

    public void setDepartmentDao(BaseDao departmentDao) {
        this.departmentDao = departmentDao;
    }
}
