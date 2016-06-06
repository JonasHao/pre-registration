package action;

import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.dispatcher.DefaultActionSupport;
import org.springframework.beans.factory.support.SecurityContextProvider;
import org.springframework.security.core.context.SecurityContextHolder;
import po.User;
import service.UserService;

import java.util.Map;


public class UserAction extends BaseAction{

    /* 登陆 */
    private String username;
    private String password;
    /* 注册 */
    private String passwordAgain;
    private String phone;
    private String email;

    private UserService mService;

    UserAction() {
    }

    public String login() throws Exception {
        if (validateUsername()) {
            User user = mService.findUserByID(username);
            if (user == null) {
                addFieldError("username", "这个用户名尚未注册");
                return INPUT;
            }

            if (password.hashCode() != user.getPassword()) {
                addFieldError("password", "密码错误");
                return INPUT;
            }
            ActionContext context = ActionContext.getContext();
            context.getSession().put("username", username);

            return SUCCESS;
        }

        return INPUT;
    }

    public String singUp() throws Exception {
        if (validateUsername() && validatePassword()) {

            if (!password.equals(passwordAgain)) {
                addFieldError("passwordAgain", "两次密码输入不一致");
            }

            User user = mService.findUserByID(username);
            if (user != null) {
                addFieldError("username", "用户名已经被占用");
                return INPUT;
            }

            user = new User(username, password.hashCode(), phone);
            mService.addUser(user);
            ActionContext context = ActionContext.getContext();
            context.getSession().put("username", username);


            SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return SUCCESS;

        }
        return INPUT;
    }


    /**
     * 校验用户名
     */
    private boolean validateUsername() {
        if (username != null && username.matches("^[a-z0-9_-]{3,15}$")) {
            return true;
        }
        addFieldError("username", "用户名不符合规范");
        return false;
    }

    /**
     * 校验密码，只能包含数字、字母、下划线、符号，长度为6-20位
     */
    private boolean validatePassword() {
        if (!password.isEmpty() && password.matches("[0-9a-zA-Z!@#$%^?,./]{6,20}")) {
            return true;
        }
        addFieldError("password", "密码不符合规范");
        return false;
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

    public String getPasswordAgain() {
        return passwordAgain;
    }

    public void setPasswordAgain(String passwordAgain) {
        this.passwordAgain = passwordAgain;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserService(UserService userService) {
        mService = userService;
    }


}



