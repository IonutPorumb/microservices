package com.savindi.codestatebkend.exception.handler;

public class InternalServerError extends RuntimeException {
    private final String fieldName;

    public InternalServerError(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName(){
        return fieldName;
    }
}
