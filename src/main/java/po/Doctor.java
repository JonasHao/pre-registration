package po;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Doctor {
    private long id;
    private String name;
    private String introduction;
    private String title;
    private String image;

    private Department department;
    private List<Capacity> capacities = new ArrayList<>(10);
    private List<Order> orders = new ArrayList<>(10);

    public Doctor(){
    }

    public Doctor(String name, String introduction, Department department, String title, String image) {
        this.name = name;
        this.introduction = introduction;
        this.department = department;
        this.title = title;
        this.image = image;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long ID) {
        this.id = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "departmentID", nullable = false)
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor")
    public List<Capacity> getCapacities() {
        return capacities;
    }

    public void setCapacities(List<Capacity> capacities) {
        this.capacities = capacities;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor")
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
