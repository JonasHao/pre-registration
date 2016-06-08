package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import po.*;


public class RegistrationServiceImpl implements RegistrationService {

    private CapacityService capacityService;
    private ContactService contactService;
    private SessionFactory sessionFactory;
    private UserService userService;

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
        User user = userService.findUserByID(userID);

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
}
