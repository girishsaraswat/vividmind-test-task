package com.vividmind.db.repositories;

import com.vividmind.db.model.IdentityModel;

import java.io.Serializable;
import java.util.List;

/**
 * @author Girish Sarashwat
 * @param <E>
 */
public interface Repository <E extends IdentityModel> extends Serializable {

    /**
     * Get
     *
     * get table name
     *
     * @return : string
     */
    String getTableName();

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



    public E findOneBy(String column, int value);

}
