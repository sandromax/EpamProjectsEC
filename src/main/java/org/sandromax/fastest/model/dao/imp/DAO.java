package org.sandromax.fastest.model.dao.imp;


public interface DAO {

    boolean create();
    Object get(String name);
    boolean delete(String name);

}
