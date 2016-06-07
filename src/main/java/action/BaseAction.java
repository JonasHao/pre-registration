package action;

import org.apache.struts2.dispatcher.DefaultActionSupport;

import java.util.HashMap;
import java.util.Map;

/**
 * Base Action for RESTFUL services.
 * Provide a json response formed as:
 * <code>
 * {
 * "result":"success",
 * "data":{
 * "key":"value"
 * }
 * }
 * </code>
 */
public class BaseAction extends DefaultActionSupport {
    protected String result = SUCCESS;

    private Map<String, Object> data = new HashMap<>();

    public void addFieldError(String fieldName, String errorMessage, String code) {
        super.addFieldError(fieldName, errorMessage);
        if (!data.containsKey("error_code")) {
            data.put("error_code", code);
        }
    }

    public void addData(String key, Object value) {
        data.put(key, value);
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Map<String, Object> getData() {
        Map<String, Object> map = new HashMap<>();
        map.put("result", result);
        map.put("data", data);
        return map;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
