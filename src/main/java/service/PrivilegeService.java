package service;

import po.Hospital;

/**
 * Created by jinzil on 2016/6/8.
 */
public interface PrivilegeService {
    String getCurrentUserID();

    User getCurrentUser();

    Hospital getAdminHospital();
    Hospital getAdminHospital(String userName);
}
