package service;

import po.Doctor;

import java.util.List;

/**
 * Created by Koche on 2016/5/10.
 */
public interface DoctorService {
    void save(Doctor doctor);
    Doctor get(long id);
}
