package po;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by jinzil on 2016/4/25.
 */

@Entity
public class Department {
    private int id;
    private String name;
    private String description;
    private Hospital hospital;
    private Set<Doctor> doctors;


    @SuppressWarnings("unused")
    public Department(String name, String description, int id) {
        this.name = name;
        this.description = description;
        this.id = id;
    }

    public Department() {
    }

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setDescription(String type) {
        this.description = type;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hospitalID", nullable = false)
    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "department")
    public Set<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }
}
