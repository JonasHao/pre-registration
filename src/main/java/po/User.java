package po;


import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    private String id;
    private String phone;
    private String email;
    private long password;
    private String image;

    private Privilege privilege;

    private List<Contact> contacts;
    private List<Order> orders;

    public User(String id, long password, String phone) {
        this.id = id;
        this.password = password;
        this.phone = phone;
        this.privilege = new Privilege();
    }

    public User() {
        this.privilege = new Privilege();
    }

    @Id
    public String getId() {
        return id;
    }

    public void setId(String name) {
        this.id = name;
    }

    public long getPassword() {
        return password;
    }

    public void setPassword(long password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "owner")
    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "user")
    public Privilege getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Privilege privilege) {
        this.privilege = privilege;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return id;
    }
}