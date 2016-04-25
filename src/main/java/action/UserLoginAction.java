package action;

import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.dispatcher.DefaultActionSupport;
import org.springframework.context.ApplicationContext;
import po.User;
import service.UserService;
import utils.InitApplicationContext;

import java.util.List;
import java.util.Objects;

@SuppressWarnings("serial")


public class UserLoginAction extends DefaultActionSupport {

    private String name;

    UserLoginAction() {

    }

    @Override
    public String execute() throws Exception {

        return SUCCESS;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public boolean isValid(String keyword) {
        return keyword != null && !Objects.equals(keyword, "");
    }

    public boolean userCheck(User user) {
       return true;
    }

}


