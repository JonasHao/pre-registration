package po;

import javax.persistence.*;

/**
 * Created by Koche on 2016/5/10.
 */
@Entity
public class Doctor {
    private long ID;
    private String name;
    private Department department;

    @Id
    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "departmentID", nullable = false)
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


}
