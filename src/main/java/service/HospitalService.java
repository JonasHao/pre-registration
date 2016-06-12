package service;

import dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import po.Hospital;

import java.util.List;

/**
 * Created by Koche on 2016/5/11.
 * HospitalService 的hibernate实现
 */
public class HospitalService {

    private BaseDao dao;

    public void addHospital(Hospital hospital){
        dao.save(hospital);
    }

    public void deleteHospital(Hospital hospital){
        dao.delete(hospital);
    }

    public void deleteHospital(long id){
        deleteHospital(dao.get(Hospital.class, id));
    //    dao.delete(dao.get(Hospital.class, id));
    }



    public void updateHospital(Hospital hospital){
        dao.update(hospital);
    }

    @SuppressWarnings("unchecked")
    public List<Hospital> all() {
        return dao.query("from Hospital").list();
    }

    public Hospital getByID(long id){
        return dao.get(Hospital.class, id);
    }

//    public Hospital getByName(String hospitalName){
//        return dao.get(Hospital.class,hospitalName);
//    }

@SuppressWarnings("unchecked")
    public List<Hospital> getByName(String hospitalName){
        return dao.query("from Hospital where name=?").
                setParameter(0, hospitalName).list();
    }

@SuppressWarnings("unchecked")
    public List<Hospital> getByAddress(String address_province, String address_city, String address_area){
        return dao.query("from Hospital where address_province=? and address_city = ? and address_area = ?").
                setParameter(0, address_province).setParameter(1, address_city).setParameter(2, address_area).list();
    }

    public void setDao(BaseDao dao) {
        this.dao = dao;
    }
}
