package po;

import java.util.Map;

/**
 * Created by Koche on 2016/5/10.
 */
public class Doctor {
    private long ID;
    private String name;
    private Department department;
    private Hospital hospital;
    private Map<Long,Integer> leftCapacity;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Long, Integer> getLeftCapacity() {
        return leftCapacity;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public void setLeftCapacity(Map<Long, Integer> leftCapacity) {
        this.leftCapacity = leftCapacity;
    }
}
