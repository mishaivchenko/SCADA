package dao.daoImpl;

import dao.Dao;
import dao.DaoFactory;

import Entity.User;

public class DaoFactoryImpl implements DaoFactory<Dao> {
    private static final DaoFactoryImpl daoFactory = new DaoFactoryImpl();
    private final Dao<User> userDao = new UserDaoImpl();


    public static DaoFactoryImpl getDaoFactoryImpl() {
        return daoFactory;
    }


    @Override
    public UserDaoImpl getUserDaoImpl() {
        return (UserDaoImpl) this.userDao;
    }
}
