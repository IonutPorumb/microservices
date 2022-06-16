package com.savindi.codestatebkend.exception.handler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    public ExceptionResponse handleInternalServerError(InternalServerError e){
        System.out.println("Handle InternalServerError exception");
        return new ExceptionResponse("This is my InternalServerError message", 123456, null);
    }
}
