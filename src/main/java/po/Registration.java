package po;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Koche on 2016/5/10.
 * 挂号订单的POJO
 */
@Entity
@Table(name = "order")
public class Registration {
    private String userID;
    private Date createDate;
    private Calendar reserveDate;
    private String hospitalName;
    private String departmentName;
    private String doctorName;

    public Registration(String userID, Date createDate, Calendar reserveDate,
                        String hospitalName, String departmentName, String doctorName) {
        this.userID = userID;
        this.createDate = createDate;
        this.reserveDate = reserveDate;
        this.hospitalName = hospitalName;
        this.departmentName = departmentName;
        this.doctorName = doctorName;
    }

    public Registration() {
    }

    @Id
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    @NotNull
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
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
}
