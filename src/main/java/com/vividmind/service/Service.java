package com.vividmind.service;

import com.vividmind.db.model.IdentityModel;
import com.vividmind.db.repositories.Repository;

import java.util.List;

/**
 * @author Girish Sarashwat
 */
public interface Service<E extends IdentityModel, R extends Repository<E>>{

    /**
     * Get
     *
     * @param id : id
     *
     * @return : Reference of Type E
     */
    E findById(int id);



    /**
     * Get
     * @param column : column
     * @param value : value
     * @return : List of Reference Type E
     */
    List<E> findAllBy(String column,String value);

    /**
     * Get
     * @param column : column
     * @param value : value
     * @return : Reference of Type E
     */
    E findOneBy(String column,String value);

    /**
     * Get
     * Persist entity into DB
     * @param e : e
     * @return : Reference of Type E
     */
    E save (E e);

    /**
     * Update entity into Db
     * @param e : e
     * @return : Reference of Type E
     */
    E update(E e);


}
