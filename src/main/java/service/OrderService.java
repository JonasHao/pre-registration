package service;


import po.Order;

/**
 * Created by Koche on 2016/5/10.
 */
public interface OrderService {
    Order get(long orderID);

    /**
     * 创建一笔订单
     * @return 挂号余量不足返回false, 创建成功返回true
     */
    boolean create(String userID, long CapacityID, long ContactID);

    void cancel(long orderID);

    void delete(long orderID);
}
