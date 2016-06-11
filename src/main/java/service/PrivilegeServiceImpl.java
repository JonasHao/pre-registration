package service;

import com.opensymphony.xwork2.ActionContext;
import po.Hospital;
import po.Privilege;
import po.User;

import java.util.Map;

/**
 * Created by jinzil on 2016/6/8.
 */
public class PrivilegeServiceImpl implements PrivilegeService {
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String getCurrentUserID() {
        ActionContext context = ActionContext.getContext();
        Map session = context.getSession();
        return (String) session.get("username");
    }

    @Override
    public User getCurrentUser() {
        return userService.get(getCurrentUserID());
    }


    @Override
    public Hospital getAdminHospital(String userName) {
        User user =  userService.get(userName);
        Privilege privilege = user.getPrivilege();
        return privilege.getHospital();
    }
}
