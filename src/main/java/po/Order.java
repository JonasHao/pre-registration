package po;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Calendar;

/**
 * Created by Koche on 2016/5/10.
 * 挂号订单的POJO
 */
@Entity
@Table(name = "registrations")
public class Order {
    private long id;
    private User user;

    private Calendar createDate;
    private Calendar reserveDate;
    private String hospitalName;
    private String departmentName;
    private String doctorName;
    private String contactName;
    private String contactIDNo;
    private String contactPhone;

    private int orderStatus;

    private Doctor doctor;
    private Department department;
    private Hospital hospital;

    public Order() {
    }

    public Order(User user, Calendar reserveDate, Doctor doctor, Contact contact) {
        this.user = user;

        this.doctor = doctor;
        this.department = doctor.getDepartment();
        this.hospital = department.getHospital();

        this.hospitalName = hospital.getName();
        this.departmentName = department.getName();
        this.doctorName = doctor.getName();

        this.contactIDNo = contact.getIdNo();
        this.contactName = contact.getName();
        this.contactPhone = contact.getPhone();

        this.orderStatus = 0;

        this.reserveDate = reserveDate;
        this.createDate = Calendar.getInstance();
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "default CURRENT_TIMESTAMP")
    public Calendar getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Calendar createDate) {
        this.createDate = createDate;
    }

    @NotNull
    public Calendar getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(Calendar reserveDate) {
        this.reserveDate = reserveDate;
    }

    @NotNull
    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    @NotNull
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @NotNull
    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctorID", nullable = false)
    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
//        this.doctorName = doctor.getName();
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departmentID", nullable = false)
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
//        this.departmentName = department.getName();
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospitalID", nullable = false)
    public Hospital getHospital() {
        return hospital;
    }


    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
//        this.hospitalName = hospital.getName();
    }

    public String getContactIDNo() {
        return contactIDNo;
    }

    public void setContactIDNo(String contactIDNo) {
        this.contactIDNo = contactIDNo;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

}
