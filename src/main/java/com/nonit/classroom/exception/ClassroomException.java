package com.nonit.classroom.exception;

import org.springframework.http.HttpStatus;

import static com.nonit.classroom.constant.ExceptionConstants.*;

public class ClassroomException {

    public static ResponseException notFound(String messageKey, String message) {
        return new ResponseException(messageKey, message, HttpStatus.NOT_FOUND);
    }

    public static ResponseException badRequest(String messageKey, String message) {
        return new ResponseException(messageKey, message, HttpStatus.BAD_REQUEST);
    }

    public static ResponseException internalServer(String messageKey, String message) {
        return new ResponseException(messageKey, message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static ResponseException userNotFound() {
        return notFound(USER_NOT_FOUND_MSG_KEY, USER_MSG);
    }

    public static ResponseException classroomNotFound() {
        return notFound(CLASSROOM_NOT_FOUND_MSG_KEY, CLASSROOM_MSG);
    }

    public static ResponseException courseNotFound() {
        return notFound(COURSE_NOT_FOUND_MSG_KEY, COURSE_MSG);
    }

    public static ResponseException postNotFound() {
        return notFound(POST_NOT_FOUND_MSG_KEY, POST_MSG);
    }

    public static ResponseException commentNotFound() {
        return notFound(COMMENT_NOT_FOUND_MSG_KEY, COMMENT_MSG);
    }

    public static ResponseException assignmentNotFound() {
        return notFound(ASSIGNMENT_NOT_FOUND_MSG_KEY, ASSIGNMENT_MSG);
    }

    public static ResponseException submissionNotFound() {
        return notFound(SUBMISSION_NOT_FOUND_MSG_KEY, SUBMISSION_MSG);
    }

    public static ResponseException participationNotFound() {
        return notFound(PARTICIPATION_NOT_FOUND_MSG_KEY, PARTICIPATION_MSG);
    }
}
