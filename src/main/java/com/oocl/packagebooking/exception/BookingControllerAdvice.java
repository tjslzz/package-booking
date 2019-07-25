package com.oocl.packagebooking.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class BookingControllerAdvice {
    @ExceptionHandler(BookingException.class)
    public @ResponseBody ExceptionResponse
    getException(final BookingException exception, final HttpServletRequest request){
        ExceptionResponse error = new ExceptionResponse();
        error.setErrorMessage(exception.getMessage());
        error.callerURL(request.getRequestURI());
        return error;
    }
}
