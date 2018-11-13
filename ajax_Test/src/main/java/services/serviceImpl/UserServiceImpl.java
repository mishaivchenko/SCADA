package services.serviceImpl;

import Entity.User;
import dao.daoImpl.DaoFactoryImpl;
import Entity.User;
import services.Service;

import java.util.List;

public class UserServiceImpl implements Service<User> {


    @Override
    public boolean create(User element) {
        return DaoFactoryImpl.getDaoFactoryImpl().getUserDaoImpl().create(element);
    }

    @Override
    public User read(int id) {
        return DaoFactoryImpl.getDaoFactoryImpl().getUserDaoImpl().read(id);
    }
    @Override
    public List<User> read() {
        return DaoFactoryImpl.getDaoFactoryImpl().getUserDaoImpl().read();
    }
    @Override
    public boolean update(User element) {
        return DaoFactoryImpl.getDaoFactoryImpl().getUserDaoImpl().update(element);
    }
    @Override
    public boolean delete(int id) {
        return DaoFactoryImpl.getDaoFactoryImpl().getUserDaoImpl().delete(id);
    }
    public User getUserByName(String name) { return DaoFactoryImpl.getDaoFactoryImpl().getUserDaoImpl().getUserByName(name);}
}
