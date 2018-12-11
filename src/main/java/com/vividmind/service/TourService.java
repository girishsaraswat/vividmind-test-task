package com.vividmind.service;

import com.vividmind.db.model.Tour;
import com.vividmind.db.repositories.TourRepository;
import com.vividmind.rest.request.TourRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Girish Sarashwat
 */
public interface TourService extends Service<Tour, TourRepository>{
    List<Tour> getAllTours(HttpServletRequest request, HttpServletResponse response, TourRequest tourRequest);

}
