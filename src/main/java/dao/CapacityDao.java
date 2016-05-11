package dao;

import java.util.Calendar;

/**
 * Created by Koche on 2016/5/10.
 */
public interface CapacityDao {
    int queryCapacityByDateAndDoctorID(Calendar date, long doctorID);
}
