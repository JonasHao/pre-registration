package service;

import po.Department;
import po.Hospital;
import po.Privilege;

import java.util.List;

/**
 * Created by jinzil on 2016/6/8.
 */
public interface DepartmentService {
    void add(Department department);

    List<Department> getDepartmentByName(String name);

    Department getDepartmentByName(String name, Hospital hospital);

    Department get(long id);

    void update(Department department);

    void delete(long id);

    List<Department> showAll(long hospitalID);
}
