package service;

import po.Capacity;

public interface CapacityService {
    Capacity get(long id);
    void add(Capacity capacity);
    void update(Capacity capacity);
    void delete(long id);
}
