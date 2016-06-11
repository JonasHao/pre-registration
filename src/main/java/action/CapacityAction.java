package action;

import org.apache.struts2.dispatcher.DefaultActionSupport;
import org.apache.tomcat.jni.Time;
import po.Capacity;
import po.Doctor;
import service.CapacityService;
import service.DoctorService;

import javax.persistence.Convert;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;

/**
 * Created by Kil on 5/24/2016.
 */
public class CapacityAction extends BaseAction {

    private DoctorService doctorService;
    private CapacityService capacityService;
    private long id;
    private long doctorId;
    private Calendar slot;
    private Calendar startTime;
    private Calendar endTime;
    private int total;


    public String add() {
        Doctor doctor = doctorService.get(doctorId);
        Capacity capacity = new Capacity(doctor, slot, total);
        if (doctor != null && capacity != null) {
            capacityService.add(capacity);
            return result = SUCCESS;
        }
        return result = ERROR;
    }

    public String delete(){
        capacityService.delete(id);
        return result = SUCCESS;
    }

    public String update(){
        Capacity capacity = capacityService.get(id);
        Doctor doctor = doctorService.get(doctorId);
        if (doctor == null)
        {
            addFieldError("doctor", "医生不存在", "103");
            return result = ERROR;
        }
        capacity.setDoctor(doctor);
        capacityService.update(capacity);
        return result = SUCCESS;
    }

    public String getCapacities()
    {
        Doctor doctor = doctorService.get(doctorId);
        List<Capacity> capacityList = doctor.getCapacities();
        List<Capacity> resList = new ArrayList<>(10);
        for(Capacity capacity : capacityList)
        {
            if (capacity.getSlot().compareTo(startTime) >= 0 && capacity.getSlot().compareTo(endTime) <= 0)
            {
                capacity.getDoctor().setCapacities(null);
                capacity.getDoctor().setOrders(null);
                capacity.getDoctor().setDepartment(null);
                resList.add(capacity);

            }
        }
        addData("capacities", resList);
        return result = SUCCESS;
    }


    public DoctorService getDoctorService() {
        return doctorService;
    }

    public void setDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    public CapacityService getCapacityService() {
        return capacityService;
    }

    public void setCapacityService(CapacityService capacityService) {
        this.capacityService = capacityService;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Calendar getSlot() {
        return slot;
    }

    public void setSlot(Calendar slot) {
        this.slot = slot;
    }

    public Calendar getEndTime() {
        return endTime;
    }

    public void setEndTime(Calendar endTime) {
        this.endTime = endTime;
    }

    public Calendar getStartTime() {

        return startTime;
    }

    public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }

}
