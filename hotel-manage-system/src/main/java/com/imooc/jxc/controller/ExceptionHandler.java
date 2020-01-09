package com.imooc.jxc.controller;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExceptionHandler implements HandlerExceptionResolver {     
    
    @Override    
    public ModelAndView resolveException(HttpServletRequest request,     
            HttpServletResponse response, Object handler, Exception ex) {     
        // TODO Auto-generated method stub     
        return new ModelAndView("exception");     
    }     
    
}  