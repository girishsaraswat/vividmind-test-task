package com.vividmind.rest.controller;

import com.vividmind.rest.request.UserRequest;
import com.vividmind.rest.response.Response;
import com.vividmind.rest.security.token.AuthToken;
import com.vividmind.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Girish Sarashwat
 */
@RestController
@RequestMapping("/api/v1/public")
public class PublicController {
    private UserService userService;
    @Autowired
    public PublicController(UserService userService){
        this.userService = userService;
    }
    @PostMapping(value = "/login")
    public Response<AuthToken> login(@Valid @RequestBody  UserRequest userRequest){
        return new Response(userService.login(userRequest));
    }


}
