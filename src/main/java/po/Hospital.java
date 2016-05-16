package po;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Koche on 2016/5/10.
 */
@Entity
public class Hospital {
    private long ID;
    private String name;
    private String description;
    private Set<Department> departments = new HashSet<>(0);


    @Id
    @GeneratedValue
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "hospital")
    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return name;
    }
}


