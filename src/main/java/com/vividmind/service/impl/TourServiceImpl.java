package com.vividmind.service.impl;

import com.vividmind.config.prop.ApplicationProperties;
import com.vividmind.db.model.Tour;
import com.vividmind.db.model.User;
import com.vividmind.db.repositories.TourRepository;
import com.vividmind.db.repositories.impl.BaseRepository;
import com.vividmind.rest.handlers.ApiErrorCode;
import com.vividmind.rest.request.TourRequest;
import com.vividmind.rest.security.token.TokenProvider;
import com.vividmind.rpc.JsonRPCService;
import com.vividmind.service.TourService;
import com.vividmind.service.UserService;
import com.vividmind.util.JsonUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author Girish Sarashwat
 */
@Service
public class TourServiceImpl extends BaseRepository<Tour> implements TourService {
    @Autowired
    private TourRepository tourRepository;
    @Autowired
    private ApplicationProperties applicationProperties;
    @Autowired
    private UserService userService;
    @Autowired
    private TokenProvider tokenProvider;


    public TourServiceImpl() {
        super(Tour.class);
    }


    @Override
    public List<Tour> getAllTours(HttpServletRequest request, HttpServletResponse response, TourRequest tourRequest) {
        List<Tour> newTourList = new ArrayList<>();
        String header = request.getHeader("Authorization");
        Map<String,String> authToken = tokenProvider.decryptToken(header);
        User user=userService.findOneBy("username",authToken.get("username"));
        if(user.getRole().getName().equalsIgnoreCase("ADMIN")){
            if(Objects.isNull(tourRequest.getFilter()) || tourRequest.getFilter().equalsIgnoreCase("")){
                String responseJson = JsonRPCService.sendGet(applicationProperties.getApiURL());
                List<Tour> tourList = JsonUtil.loadJsonNode(JsonUtil.getJsonNode(responseJson).get("tours"));
                tourList.forEach(e->{
                    Tour tour = tourRepository.findOneBy("tourId",e.getId());
                    if(Objects.nonNull(tour)){ //update
                        tour.setName(e.getName());
                        tour.setLongDesc(e.getLongDesc());
                        tour.setTourId(e.getId());
                        tour =  tourRepository.update(tour);
                        newTourList.add(tour);
                    }else{ // Save
                        tour = new Tour();
                        tour.setName(e.getName());
                        tour.setLongDesc(e.getLongDesc());
                        tour.setTourId(e.getId());
                        tour.setUpdatedDate(new DateTime().getMillis());
                        tour =tourRepository.save(tour);
                        newTourList.add(tour);
                    }
                });
            }else{
                return tourRepository.getFilteredTours(tourRequest.getFilter());
            }
        }else{
            if(Objects.isNull(tourRequest.getFilter()) || tourRequest.getFilter().equalsIgnoreCase("")){
                response.setStatus(ApiErrorCode.USER_NOT_ACCESSS.getCode());
                return null;
            }else{
                return tourRepository.getFilteredTours(tourRequest.getFilter());
            }

        }
       return  newTourList;

    }


}
