package service;

import dao.BaseDao;
import po.User;

public class UserServiceImpl implements UserService {
    private BaseDao dao;

    @Override
    public void signUp(User user) {
        dao.save(user);

    }

    @Override
    public User get(String name) {
        return dao.get(User.class, name);
    }


    @Override
    public String generateToken(User user) {
        return "fake token";
    }

    public void setBaseDao(BaseDao baseDao) {
        this.dao = baseDao;
    }
}