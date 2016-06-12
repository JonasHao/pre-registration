package service;

import po.Department;
import po.Doctor;

import java.util.List;

/**
 * Created by Koche on 2016/5/10.
 */
public interface DoctorService {
    void add(Doctor doctor);
    Doctor get(long id);
    List<Doctor> getDoctorByName(String name);
    void update(Doctor department);
    void delete(long id);
}
