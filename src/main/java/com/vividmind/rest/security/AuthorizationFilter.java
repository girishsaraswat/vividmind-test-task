package com.vividmind.rest.security;
import com.google.common.collect.Lists;
import com.vividmind.rest.security.token.TokenProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author Girish Sarashwat
 */
public class AuthorizationFilter extends OncePerRequestFilter {
    private static final Logger LOGGER = LogManager.getLogger(AuthorizationFilter.class);
    private static final String AUTHORIZATION="Authorization";
    @Autowired
    private TokenProvider tokenProvider;
    @Autowired
    @Qualifier("userDetailsServiceImpl")
    private UserDetailsService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(AUTHORIZATION);
        if (header != null) {
            Map<String,String> securedAccessToken = tokenProvider.decryptToken(header);
            checkApiWithToken(securedAccessToken.get("username"), header, request);
        }
        chain.doFilter(request, response);
    }

    private void checkApiWithToken(String username, String authToken, HttpServletRequest req)  {

        if ((username != null) && (SecurityContextHolder.getContext().getAuthentication() == null)) {
            UserDetails userDetails = userService.loadUserByUsername(username);
            if (tokenProvider.isTokenValidated(authToken)) {
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, Lists.newArrayList(new SimpleGrantedAuthority("ROLE_ADMIN")));
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
                LOGGER.info("authenticated user '{}' setting security context", username);
                SecurityContextHolder.getContext().setAuthentication(authentication);

            }
        }
    }
}
