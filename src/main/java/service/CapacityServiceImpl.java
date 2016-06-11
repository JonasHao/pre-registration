package service;

import dao.BaseDao;
import po.Capacity;


public class CapacityServiceImpl implements CapacityService {
    private BaseDao dao;

    @Override
    public void add(Capacity capacity){
        dao.save(capacity);
    }

    @Override
    public Capacity get(long id) {
        return dao.get(Capacity.class, id);
    }

    @Override
    public void update(Capacity capacity){
        dao.update(capacity);
    }

    @Override
    public void delete(long id){
        Capacity capacity = get(id);
        dao.delete(capacity);
    }

    public void setDao(BaseDao dao) {
        this.dao = dao;
    }

}
