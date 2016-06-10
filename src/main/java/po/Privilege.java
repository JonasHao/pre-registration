package po;

import javax.persistence.*;
import javax.persistence.criteria.Fetch;

/**
 * Created by jinzil on 2016/6/8.
 */
@Entity
public class Privilege {
    private long id;
    private boolean root;
    private User user;
    private Hospital hospital;

    public Privilege(){
        root = false;
        hospital = null;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public boolean isRoot() {
        return root;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setRoot(boolean root) {
        this.root = root;
    }


    @OneToOne
    @JoinColumn(name="userId",insertable=true,unique=true)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hospitalID", nullable = false)
    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
}
