package service;

import dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import po.*;
import utils.Constants;


public class OrderServiceImpl implements OrderService {

    private CapacityService capacityService;
    private ContactService contactService;
    private SessionFactory sessionFactory;
    private UserService userService;
    private BaseDao dao;

    @Override
    public Order get(long orderID) {
        return dao.get(Order.class,orderID);
    }

    @Override
    public boolean create(String userID, long CapacityID, long ContactID) {
        Capacity capacity = capacityService.get(CapacityID);
        if (capacity == null) {
            return false;
        }

        int left = capacity.getSurplus();
        if (left <= 0) {
            return false;
        }

        Doctor doctor = capacity.getDoctor();
        User user = userService.get(userID);

        Contact contact = contactService.get(ContactID);

        Order order = new Order(user,capacity.getSlot(),doctor,contact);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        capacity.setSurplus(left - 1);
        session.update(capacity);

        session.save(order);

        transaction.commit();
        session.flush();
        session.close();

        return true;
    }

    public void cancel(long orderID){
        Order order = dao.get(Order.class, orderID);
        order.setOrderStatus(Constants.ORDER_STATUS_CANCELED);
        dao.save(order);
    }

    @Override
    public void delete(long orderID) {
        dao.delete(dao.get(Order.class, orderID));
    }


    public void setCapacityService(CapacityService capacityService) {
        this.capacityService = capacityService;
    }

    public void setContactService(ContactService contactService) {
        this.contactService = contactService;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setDao(BaseDao dao) {
        this.dao = dao;
    }
}
