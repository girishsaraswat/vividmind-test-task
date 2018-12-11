package com.vividmind.db.repositories.impl;

import com.vividmind.db.model.Tour;
import com.vividmind.db.repositories.TourRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Girish Sarashwat
 */
@Repository
public class TourRepositoryImpl extends BaseRepository<Tour> implements TourRepository {
    @PersistenceContext
    private EntityManager entityManager;
    public TourRepositoryImpl() {
        super(Tour.class);
    }

    @Transactional
    @Override
    public List<Tour> getFilteredTours(String filter) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tour> criteria = builder.createQuery(Tour.class);
        Root<Tour> fromTour = criteria.from(Tour.class);
        criteria.where(builder.like(fromTour.get("longDesc"), "%"+filter+"%"));
        return  entityManager.createQuery(criteria).getResultList();
    }
}
