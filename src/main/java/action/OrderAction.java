package action;

import po.*;
import service.CapacityService;
import service.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Koche on 2016/4/27.
 * 这是挂号的Action，不是用户注册的
 */
public class OrderAction extends BaseAction {
    private long contactID;
    private long doctorID;
    private long capacityID;
    private Date createDate;

    private Capacity capacity;
    private Contact contact;
    private List<Contact> contacts;

    private String doctorName;
    private String department;
    private String hospital;
    private String slot;

    private long orderID;

    private List<Long> list;

    public List<Long> getList() {
        return list;
    }

    public void setList(List<Long> list) {
        this.list = list;
    }

    private DoctorService doctorService;
    private OrderService orderService;
    private UserService userService;
    private PrivilegeService privilegeService;
    private CapacityService capacityService;


    public String fillOrder() throws Exception {
        Doctor doctor = doctorService.get(doctorID);
        doctorName = doctor.getName();
        department = doctor.getDepartment().getName();
        hospital = doctor.getDepartment().getHospital().getName();

        capacity = capacityService.get(capacityID);
        if (capacity == null) {
            return "out";
        }

        slot = capacity.getSlotString();

        String userID = privilegeService.getCurrentUserID();

        if (userID == null) {
            return INPUT;
        }

        contacts = userService.get(userID).getContacts();
        if (contacts.size() > 0) {
            for (Contact c : contacts) {
                if (c.isDefault()) {
                    contact = c;
                    break;
                }
            }
            if (contact == null) {
                contact = contacts.get(0);
            }
        }

        return SUCCESS;
    }


    /**
     * 需要的参数：capacityID, contactID
     *
     * @return "out"表示用户过期，需重新登陆。
     * @throws Exception
     */
    public String commit() throws Exception {
        String userID = privilegeService.getCurrentUserID();
        if (userID == null) {
            addData("error_code", USER_INACTIVE);
            return result = ERROR;
        }
        try {
            orderService.create(userID, capacityID, contactID);
            return result = SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return result = ERROR;
        }

    }

    public String cancel() throws Exception {
        String userID = privilegeService.getCurrentUserID();
        if (userID == null) {
            addData("error_code", USER_INACTIVE);
            return result = ERROR;
        }

        try {
            orderService.cancel(orderID);
            return result = SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return result = ERROR;
        }
    }

    public String delete() throws Exception {
        String userID = privilegeService.getCurrentUserID();
        if (userID == null) {
            addData("error_code", USER_INACTIVE);
            return result = ERROR;
        }
        try {
            orderService.delete(orderID);
            return result = SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return result = ERROR;
        }
    }


    public String all() throws Exception {
        User user = privilegeService.getCurrentUser();
        if (user == null) {
            addData("error_code", USER_INACTIVE);
            return result = ERROR;
        }

        try {
            addData("orders", user.getOrders());
            return result = SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return result = ERROR;
        }
    }

    public String get() throws Exception {
        User user = privilegeService.getCurrentUser();
        if (user == null) {
            addData("error_code", USER_INACTIVE);
            return result = ERROR;
        }

        try {
            Order order = orderService.get(orderID);
            order.setHospital(null);
            order.setDepartment(null);
            order.setDoctor(null);
            order.setUser(null);
            addData("order", order);
            return result = SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return result = ERROR;
        }
    }


    public String test() throws Exception {
        System.out.println(list);
        return result = SUCCESS;
    }


    // getters and setters
    public long getContactID() {
        return contactID;
    }

    public void setContactID(long contactID) {
        this.contactID = contactID;
    }

    public long getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(long doctorID) {
        this.doctorID = doctorID;
    }

    public long getCapacityID() {
        return capacityID;
    }

    public void setCapacityID(long capacityID) {
        this.capacityID = capacityID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public Capacity getCapacity() {
        return capacity;
    }

    public void setCapacity(Capacity capacity) {
        this.capacity = capacity;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public void setDoctorService(DoctorService DoctorService) {
        doctorService = DoctorService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public void setPrivilegeService(PrivilegeService privilegeService) {
        this.privilegeService = privilegeService;
    }

    public void setCapacityService(CapacityService capacityService) {
        this.capacityService = capacityService;
    }

}
