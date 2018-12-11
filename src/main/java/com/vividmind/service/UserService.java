package com.vividmind.service;

import com.vividmind.db.model.User;
import com.vividmind.db.repositories.UserRepository;
import com.vividmind.rest.request.UserRequest;
import com.vividmind.rest.security.token.AuthToken;

/**
 * @author Girish Sarashwat
 */
public interface UserService extends Service<User, UserRepository>{
    AuthToken login(UserRequest userRequest);

}
