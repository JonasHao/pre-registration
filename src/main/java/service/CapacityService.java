package service;

import java.util.Calendar;

/**
 * Created by Koche on 2016/5/10.
 */
public interface CapacityService {
    int queryCapacityByDateAndDoctorID(Calendar calendar, long doctorID);
}
