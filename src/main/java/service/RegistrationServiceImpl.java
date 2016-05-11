package service;

import dao.RegistrationDao;
import po.Registration;


/**
 * Created by Koche on 2016/5/10.
 */
public class RegistrationServiceImpl implements RegistrationService {
    private RegistrationDao mRegistrationDao;


    public void setRegistrationDao(RegistrationDao registrationDao) {
        mRegistrationDao = registrationDao;
    }

    @Override
    public void create(Registration registration) {
        mRegistrationDao.create(registration);
    }
}
