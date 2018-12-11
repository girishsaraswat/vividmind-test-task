package com.vividmind.db.repositories;

import com.vividmind.db.model.Tour;

import java.util.List;

/**
 * @author Girish Sarashwat
 */
public interface TourRepository extends Repository<Tour> {
    /**
     *
     * @param filter : fitler
     * @return : tourList
     */
    List<Tour> getFilteredTours(String filter);
}
