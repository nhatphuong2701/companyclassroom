package com.personalproject.axonclassroom.exception;

import org.springframework.http.HttpStatus;

public class TeacherException {
    private static final String TEACHER_NOT_FOUND_MSG_KEY = "TeacherNotExist";
    private static final String TEACHER_MSG = "Teacher Not Found";

    public static ResponseException notFound(String messageKey, String message) {
        return new ResponseException(messageKey, message, HttpStatus.NOT_FOUND);
    }

    public static ResponseException badRequest(String messageKey, String message) {
        return new ResponseException(messageKey, message,HttpStatus.BAD_REQUEST);
    }

    public static ResponseException internalServer(String messageKey, String message){
        return new ResponseException(messageKey, message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static ResponseException teacherNotFound(String messageKey, String message){
        return notFound(TEACHER_NOT_FOUND_MSG_KEY, TEACHER_MSG);
    }
}
