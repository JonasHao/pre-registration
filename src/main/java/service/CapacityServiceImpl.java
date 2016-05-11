package service;

import dao.CapacityDao;

import java.util.Calendar;


/**
 * Created by Koche on 2016/5/10.
 */
public class CapacityServiceImpl implements CapacityService {
    private CapacityDao mCapacityDao;

    @Override
    public int queryCapacityByDateAndDoctorID(Calendar calendar, long doctorID) {
        return mCapacityDao.queryCapacityByDateAndDoctorID(calendar, doctorID);
    }

    public void setCapacityDao(CapacityDao capacityDao) {
        mCapacityDao = capacityDao;
    }
}
