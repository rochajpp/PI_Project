package com.pi_engenhariadesoftware.pi_project.Services.Authentication;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.pi_engenhariadesoftware.pi_project.Services.CookieService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        if(CookieService.getCookie(request, "userId") != null){
            return true;
        }

        response.sendRedirect("/login");
        return false;
    }

    // @Override
    // public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{
    //     System.out.println("Post Handle method is Calling");
    // }

    // @Override
    // public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object hadler, Exception exception) throws Exception{
    //     System.out.println("Request and Reponse is completed");
    // }
}
