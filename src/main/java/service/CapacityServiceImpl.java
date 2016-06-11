package service;

import dao.BaseDao;
import po.Capacity;

import java.util.List;


public class CapacityServiceImpl implements CapacityService {
    private BaseDao capacityDao;

    @Override
    public void add(Capacity capacity){
        capacityDao.save(capacity);
    }

    @Override
    public Capacity get(long id) {
        return capacityDao.get(Capacity.class, id);
    }

    @Override
    public void update(Capacity capacity){
        capacityDao.update(capacity);
    }

    @Override
    public void delete(long id){
        Capacity capacity = get(id);
        capacityDao.delete(capacity);
    }

    public void setCapacityDao(BaseDao capacityDao) {
        this.capacityDao = capacityDao;
    }

}
