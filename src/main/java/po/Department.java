package po;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinzil on 2016/4/25.
 * 科室的Pure Object
 */
@Entity
public class Department {
    private long id;
    private String name;
    private String description;

    private Hospital hospital;
    private List<Doctor> doctors = new ArrayList<>(10);
    private List<Order> orders = new ArrayList<>(10);


    @SuppressWarnings("unused")
    public Department(String name, String description, int id) {
        this.name = name;
        this.description = description;
        this.id = id;
    }

    public Department() {
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
