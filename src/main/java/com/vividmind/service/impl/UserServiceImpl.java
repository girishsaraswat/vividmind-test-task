package com.vividmind.service.impl;

import com.vividmind.db.model.User;
import com.vividmind.db.repositories.UserRepository;
import com.vividmind.db.repositories.impl.BaseRepository;
import com.vividmind.rest.request.UserRequest;
import com.vividmind.rest.security.token.AuthToken;
import com.vividmind.rest.security.token.TokenProvider;
import com.vividmind.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @author Girish Sarashwat
 */
@Service
public class UserServiceImpl extends BaseRepository<User> implements UserService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenProvider tokenProvider;
    public UserServiceImpl() {
        super(User.class);
    }

    @Override
    public AuthToken login(UserRequest userRequest) {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userRequest.getUsername(),
                        userRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = userRepository.findOneBy("username",userRequest.getUsername());
        AuthToken authToken = new AuthToken();
        authToken.setToken(tokenProvider.generateTokenByUserename(user.getId().toString(),user.getUsername()));
        return authToken;
    }
}
