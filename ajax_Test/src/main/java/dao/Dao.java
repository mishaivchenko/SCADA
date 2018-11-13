package dao;

import java.util.List;

public interface Dao<E> {
    //CREATE
     boolean create(E element);
     //READ
    E read(int id);
    List<E> read();
    //UPDATE
    boolean update(E element);
    //DELETE
    boolean delete(int id);

}
