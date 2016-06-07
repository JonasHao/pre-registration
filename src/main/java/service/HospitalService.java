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

    @SuppressWarnings("unchecked")
    public List<Hospital> all() {
        return dao.query("from Hospital").list();
    }

    public Hospital get(long id){
        return dao.get(Hospital.class,id);
    }

    public void setDao(BaseDao dao) {
        this.dao = dao;
    }
}
