package dao;

import po.Department;

import java.util.List;


public interface DepartmentDao {
    List<Department> getAllOfHospital(long hospitalID);
}
