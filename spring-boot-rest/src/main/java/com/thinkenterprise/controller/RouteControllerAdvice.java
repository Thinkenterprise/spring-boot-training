package com.thinkenterprise.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RouteControllerAdvice {
    /**
     * Handle exceptions thrown by handlers.
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String exception(Exception exception) {
        return exception.getMessage();
    }
}
