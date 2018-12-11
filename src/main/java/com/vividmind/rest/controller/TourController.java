package com.vividmind.rest.controller;

import com.vividmind.db.model.User;
import com.vividmind.rest.request.TourRequest;
import com.vividmind.rest.response.Response;
import com.vividmind.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Girish Sarashwat
 */
@RestController
@RequestMapping("/api/v1/tours")
public class TourController {
    @Autowired
    private TourService tourService;

    @PostMapping("/refresh")
    public Response<User> refresh(HttpServletRequest request, HttpServletResponse response, @RequestBody TourRequest tourRequest){
        return new Response(tourService.getAllTours(request,response,tourRequest));
    }

}
