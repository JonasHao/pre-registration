package dao;

import po.Department;

import java.util.List;


public interface DepartmentDao {
    Department get(long departmentID);
    List<Department> getAllOfHospital(long hospitalID);
}
