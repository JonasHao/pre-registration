package action;

import org.apache.struts2.dispatcher.DefaultActionSupport;

/**
 * Created by Koche on 2016/4/27.
 * 这是挂号的Action，不是用户注册的
 */
public class RegistrationAction extends DefaultActionSupport {

    public String register() throws Exception {
        return SUCCESS;
    }

    public String unRegister() throws Exception{
        return SUCCESS;
    }


}
