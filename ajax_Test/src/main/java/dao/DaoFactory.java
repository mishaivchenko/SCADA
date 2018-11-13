package dao;

import dao.daoImpl.UserDaoImpl;

public interface DaoFactory<Dao> {


        UserDaoImpl getUserDaoImpl();

}
