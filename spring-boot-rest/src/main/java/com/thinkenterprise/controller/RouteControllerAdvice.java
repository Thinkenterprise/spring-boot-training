package com.thinkenterprise.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RouteControllerAdvice {
    @ExceptionHandler(value = RouteNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    // Fehlerklasse mit Status unsMessage
    public RouteErrorStatus exception(RouteNotFoundException exception) {
        return new RouteErrorStatus(6573L, "RouteNotFound: " + exception.getMessage());

    }
}
