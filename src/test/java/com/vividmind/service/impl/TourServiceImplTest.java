package com.vividmind.service.impl;

import com.vividmind.config.prop.ApplicationProperties;
import com.vividmind.db.repositories.TourRepository;
import com.vividmind.rest.request.TourRequest;
import com.vividmind.rest.security.token.TokenProvider;
import com.vividmind.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.*;

public class TourServiceImplTest {

    private TourRepository tourRepository;
    private ApplicationProperties applicationProperties;
    private UserService userService;
    private TokenProvider tokenProvider;
    private TourServiceImpl tourService;

    @Before
    public void setUp(){
        tourService = Mockito.mock(TourServiceImpl.class);
    }
    @Test
    public void getAllTours() {
        HttpServletRequest httpServletRequest = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse httpServletResponse = Mockito.mock(HttpServletResponse.class);
        TourRequest tourRequest = Mockito.mock(TourRequest.class);
        tourService.getAllTours(httpServletRequest,httpServletResponse,tourRequest);
        Mockito.verify(tourService).getAllTours(httpServletRequest,httpServletResponse,tourRequest);
    }
}