package service;

import po.Capacity;

public interface CapacityService {
    void refresh(Capacity capacity);

    Capacity get(long id);
}
