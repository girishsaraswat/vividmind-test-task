package com.vividmind.service.impl;

import com.vividmind.db.repositories.UserRepository;
import com.vividmind.rest.request.UserRequest;
import com.vividmind.rest.security.token.TokenProvider;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class UserServiceImplTest {


    private UserServiceImpl userService;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        userService = mock(UserServiceImpl.class);
    }

    @Test
    public void login() {
        UserRequest userRequest = mock(UserRequest.class);
        userService.login(userRequest);
        verify(userService).login(userRequest);
    }
}