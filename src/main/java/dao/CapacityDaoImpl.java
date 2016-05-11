package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import po.Capacity;

import java.util.Calendar;
import java.util.List;

import static utils.SlotUtils.slotting;


/**
 * Created by Koche on 2016/5/10.
 */
public class CapacityDaoImpl implements CapacityDao {
    private SessionFactory mSessionFactory;


    @Override
    public int queryCapacityByDateAndDoctorID(Calendar calendar, long doctorID) {
        Session session = mSessionFactory.getCurrentSession();

        slotting(calendar);

        List<Capacity> list = session.createQuery("from Capacity where dateStart =? and  doctorID=?").
                setParameter(0, calendar).setParameter(1, doctorID).list();

        if(list.size()!=1){
            return 0;
        }
        return list.get(0).getCapacity();
    }


    public void setSessionFactory(SessionFactory sessionFactory) {
        mSessionFactory = sessionFactory;
    }
}
