package action;

import org.apache.struts2.dispatcher.DefaultActionSupport;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Koche on 2016/6/6.
 */
public class BaseAction extends DefaultActionSupport {
    private String result = SUCCESS;

    private Map<String, Object> data = new HashMap<>();

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
