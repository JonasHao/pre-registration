package action;

import org.apache.struts2.dispatcher.DefaultActionSupport;
@SuppressWarnings("serial")
 
 
public class MyAction extends DefaultActionSupport {
 
 
    private String name;
 
    @Override
    public String execute() throws Exception {
 
        name = "David";
        return "myview";
 
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
}
 