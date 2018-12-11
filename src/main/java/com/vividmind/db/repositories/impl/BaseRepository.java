package com.vividmind.db.repositories.impl;

import com.vividmind.db.model.IdentityModel;
import com.vividmind.db.model.TimeStampableModel;
import com.vividmind.db.repositories.Repository;
import com.vividmind.exceptions.DatabaseOperationException;
import com.vividmind.exceptions.InitializationException;
import org.joda.time.DateTime;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Girish Sarashwat
 * @param <E> : e
 */
@Transactional
public class BaseRepository<E extends IdentityModel> implements Repository<E> {
    @PersistenceContext
    private EntityManager entityManager;
    private String tableName;

    public BaseRepository (Class<E> entityClass){
        try{
            tableName = entityClass.getName();
        }catch (Exception e){
            throw  new InitializationException("BaseRepository class constructor in get GenericTypeParameter class ",e);
        }

    }

    @Override
    public String getTableName() {
        return tableName;
    }

    @Override
    public E findById(int id) {
        try{
            String hql = " FROM "+this.getTableName()+" as tbl WHERE tbl.id =:id";
            return (E)entityManager.createQuery(hql).setParameter("id",id).getSingleResult();
        }catch (Exception e){
            throw new DatabaseOperationException(e.getMessage(), e);
        }
    }


    @Override
    public List<E> findAllBy(String column, String value) {
        try{
            String hql = "FROM " +this.getTableName()+" as tbl WHERE tbl."+column+" =:"+column;
            return (List<E>) entityManager.createQuery(hql).setParameter(column,value).getResultList();
        }catch (Exception e){
            throw new DatabaseOperationException(e.getMessage(),e);
        }
    }

    @Override
    public E findOneBy(String column, String value) {
        try{
            String hql = "FROM "+ this.getTableName()+ " as tbl WHERE tbl."+column+" =:"+column;
            return (E)entityManager.createQuery(hql).setParameter(column,value).getSingleResult();
        }catch (NoResultException e){
            return  null;
        }
    }

    @Override
    public E save(E e) {
        try {
            if (e instanceof TimeStampableModel) {
                TimeStampableModel t = (TimeStampableModel) e;
                t.setCreatedDate(new DateTime().getMillis());
            }
            entityManager.persist(e);
            entityManager.flush();
        }catch (Exception ex){
            throw  new DatabaseOperationException(ex.getMessage(),ex);
        }
        return e;
    }

    @Override
    public E update(E e) {
        try{
            if(e instanceof TimeStampableModel){
                TimeStampableModel t = (TimeStampableModel)e;
                t.setUpdatedDate(new DateTime().getMillis());
            }
            entityManager.merge(e);
            entityManager.flush();
            return e;
        }catch (Exception ex){
            throw new DatabaseOperationException(ex.getMessage(),ex);
        }
    }



    @Override
    public E findOneBy(String column, int value) {
        try{
            String hql = "FROM "+ this.getTableName()+ " as tbl WHERE tbl."+column+" =:"+column;
            return (E)entityManager.createQuery(hql).setParameter(column,value).getSingleResult();
        }catch (NoResultException e){
            return  null;
        }
    }
}
