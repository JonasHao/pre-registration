package po;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Koche on 2016/4/27.
 */
@Entity
class Contact {

    private String name;
    private String idNo;
    private String phone;

    private long ownerId;

    @Id
    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }
}
