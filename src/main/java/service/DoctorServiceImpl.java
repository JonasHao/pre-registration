package service;

import dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import po.Department;
import po.Doctor;

import javax.persistence.OneToOne;
import java.util.List;

/**
 * Created by Koche on 2016/5/10.
 */
public class DoctorServiceImpl implements DoctorService {
    private BaseDao doctorDao;

    // 添加doctor对象
    @Override
    public void add(Doctor doctor){
        doctorDao.save(doctor);
    }

    // 通过医生ID获取对象
    @Override
    public Doctor get(long id) {
            return doctorDao.get(Doctor.class, id);
    }

    @Override
    public List<Doctor> getDoctorByNmae(String name){
        return doctorDao.query("from Doctor where name=?").setParameter(0,name).list();
    }

    @Override
    public void update(Doctor doctor){
        doctorDao.update(doctor);
    }
    @Override
    public void delete(long id){
        Doctor doctor = get(id);
        doctorDao.delete(doctor);
    }

    public void setDoctorDao(BaseDao doctorDao) {
        this.doctorDao = doctorDao;
    }

}
