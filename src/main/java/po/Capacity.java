package po;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Calendar;

/**
 * Created by Koche on 2016/5/10.
 * 以dateStart为起始，30分钟为一个区间的时间片内,doctorID对应医生的剩余挂号量。
 */
@Entity
public class Capacity {
    private Calendar dateStart;
    private long doctorID;
    private int capacity;

    public Capacity() {
    }

    @Id
    public Calendar getDateStart() {
        return dateStart;
    }

    public void setDateStart(Calendar dateStart) {
        this.dateStart = dateStart;
    }

    public long getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(long doctorID) {
        this.doctorID = doctorID;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
