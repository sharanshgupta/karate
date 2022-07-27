package com.sharansh.karate.interceptors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Component
@Slf4j
public class ClientAuthenticationInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String username = request.getHeader("username");
        String password = request.getHeader("password");
        boolean isHeaderPresent = (Objects.nonNull(username) && Objects.nonNull(password));
        if (!isHeaderPresent) {
            log.info("Missing header");
            response.setStatus(HttpStatus.FORBIDDEN.value());
            return false;
        }
        boolean isValidUser = username.equals("user") && password.equals("password");
        if (isValidUser) {
            log.info("Valid user logged in");
            return true;
        } else {
            log.info("Invalid user");
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
