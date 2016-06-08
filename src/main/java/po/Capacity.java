package po;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Koche on 2016/5/10.
 * 以dateStart为起始，1小时为一个区间的时间片内,doctorID对应医生的剩余挂号量。
 */
@Entity
public class Capacity {
    private long id;
    private Doctor doctor;
    private Calendar slot;
    private int total;
    private int surplus;


    public Capacity() {
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctorID", nullable = false)
    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Calendar getSlot() {
        return slot;
    }

    public void setSlot(Calendar slot) {
        this.slot = slot;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSurplus() {
        return surplus;
    }

    public void setSurplus(int left) {
        this.surplus = left;
    }

//    @Transient
//    public int getYear() {
//        return slot.get(Calendar.YEAR);
//    }
//
//    @Transient
//    public int getMonth() {
//        return slot.get(Calendar.MONTH);
//    }
//
//    @Transient
//    public int getDay() {
//        return slot.get(Calendar.DATE);
//    }
//
//    @Transient
//    public int getHour() {
//        return slot.get(Calendar.HOUR_OF_DAY);
//    }
//
    @Transient
    public String getSlotString() {
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String d = date.format(slot.getTime());
        SimpleDateFormat time = new SimpleDateFormat("HH:00");
        String t1 = time.format(slot.getTime());
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, slot.get(Calendar.HOUR_OF_DAY)+1);
        String t2 = time.format(slot.getTime());
        return String.format("%s %s - %s", d, t1, t2);
    }
}
