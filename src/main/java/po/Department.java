package po;

/**
 * Created by jinzil on 2016/4/25.
 */
public class Department {
    private String name;
    private String type;

    public Department(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
