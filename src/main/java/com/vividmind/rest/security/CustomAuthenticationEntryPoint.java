package com.vividmind.rest.security;

import com.vividmind.rest.handlers.ApiErrorCode;
import com.vividmind.rest.handlers.ApiErrorResponse;
import com.vividmind.util.JsonUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Girish Sarashwat
 */
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ApiErrorResponse error = new ApiErrorResponse(false, authException.getMessage(), ApiErrorCode.INVALID_CREDENTIALS);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.getWriter().write(JsonUtil.toJson(error));
    }
}
