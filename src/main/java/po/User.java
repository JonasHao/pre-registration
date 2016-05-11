package po;


import javax.persistence.*;

@Entity
public class User {
    private String ID;
    private String phone;
    private String email;
    private long password;


    public User(String ID, long password, String phone) {
        this.ID = ID;
        this.password = password;
        this.phone = phone;
    }

    public User() {
    }

    @Id
    public String getID() {
        return ID;
    }

    public void setID(String name) {
        this.ID = name;
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

    @Override
    public String toString() {
        return ID;
    }
}