package dao;

import po.Hospital;

import java.util.List;


public interface HospitalDao {
    List<Hospital> all();
    Hospital get(long id);

}
