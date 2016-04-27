package action;

import org.apache.struts2.dispatcher.DefaultActionSupport;
import po.User;
import service.UserService;


public class UserAction extends DefaultActionSupport {

    private String name;
    private String username;
    private String password;
    private String id;
    private String phone;

    private UserService mService;

    UserAction() {
    }

    public String login() throws Exception {
        User user = mService.findUserByName(name);
        if (user == null) {
            return INPUT;
        }

        if (password.hashCode() != user.getPassword()) {
            return ERROR;
        }

        return SUCCESS;
    }

    public String singUp() throws Exception {
        User user = new User(name, password.hashCode());
        mService.addUser(user);
        return SUCCESS;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUserService(UserService userService) {
        mService = userService;
    }
}



