package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import po.Department;

import java.util.List;


public class DepartmentDaoImpl implements DepartmentDao {
    private SessionFactory mSessionFactory;

    @Override
    public Department get(long departmentID) {
        Session session=mSessionFactory.getCurrentSession();
        session.beginTransaction();
        return session.get(Department.class,departmentID);
    }

    @Override
    public List<Department> getAllOfHospital(long hospitalID) {
        Session session = mSessionFactory.getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<Department> result = session.createQuery("from Department where hospital.id = ?").
                setParameter(0, hospitalID).list();
        if (result.size() > 0)
            return result;
        return null;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        mSessionFactory = sessionFactory;
    }
}
