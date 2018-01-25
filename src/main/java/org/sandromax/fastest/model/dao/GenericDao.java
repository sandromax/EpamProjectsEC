package org.sandromax.fastest.model.dao;

import org.sandromax.fastest.domain.user.Admin;

import java.util.List;

public interface GenericDao<K, L, T extends Admin>{
    List<T> findAll();
    T findById(K id);
    T findById(K id, L elseId);
    boolean delete(K id);
    boolean delete(T entity);
    boolean create(T entity);
    T update(T entity);
}
