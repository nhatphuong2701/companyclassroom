package com.personalproject.companyclassroom.exception;

import org.springframework.http.HttpStatus;

public class CompanyClassroomException {
    private static final String ENTITY_NOT_FOUND_MSG_KEY = "EntityNotExist";
    private static final String ENTITY_MSG = "Entity Not Found";

    public static ResponseException notFound(String messageKey, String message) {
        return new ResponseException(messageKey, message, HttpStatus.NOT_FOUND);
    }

    public static ResponseException badRequest(String messageKey, String message) {
        return new ResponseException(messageKey, message,HttpStatus.BAD_REQUEST);
    }

    public static ResponseException internalServer(String messageKey, String message){
        return new ResponseException(messageKey, message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static ResponseException entityNotFound(){
        return notFound(ENTITY_NOT_FOUND_MSG_KEY, ENTITY_MSG);
    }
}
