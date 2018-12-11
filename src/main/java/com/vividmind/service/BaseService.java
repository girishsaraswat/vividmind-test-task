package com.vividmind.service;

import com.vividmind.db.model.IdentityModel;
import com.vividmind.db.repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Girish Sarashwat
 *
 * @param <E> : Entity
 * @param <R> : Repository
 */
public class BaseService <E extends IdentityModel, R extends Repository<E>> implements Service<E, R> {
    @Autowired
    private R repository;

    @Override
    public E findById(int id) {
        return repository.findById(id);
    }


    @Override
    public List<E> findAllBy(String column, String value) {
        return repository.findAllBy(column,value);
    }

    @Override
    public E findOneBy(String column, String value) {
        return repository.findOneBy(column,value);
    }

    @Override
    public E save(E e) {
        return repository.save(e);
    }

    @Override
    public E update(E e) {
        return repository.update(e);
    }


}
