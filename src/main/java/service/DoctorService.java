package service;

import po.Doctor;

import java.util.List;

/**
 * Created by Koche on 2016/5/10.
 */
public interface DoctorService {
    String addDoctor(Doctor doctor);
    Doctor findDoctorByID(long id);
    List<Doctor> listAll();
}
