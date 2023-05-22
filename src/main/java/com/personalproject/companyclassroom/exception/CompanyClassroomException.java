package com.personalproject.companyclassroom.exception;

import org.springframework.http.HttpStatus;

public class CompanyClassroomException {
    private static final String USER_NOT_FOUND_MSG_KEY = "UserNotExist";
    private static final String USER_MSG = "User Not Found";
    private static final String COURSE_NOT_FOUND_MSG_KEY = "CourseNotExist";
    private static final String COURSE_MSG = "Course Not Found";
    private static final String CLASSROOM_NOT_FOUND_MSG_KEY = "ClassroomNotExist";
    private static final String CLASSROOM_MSG = "Classroom Not Found";
    private static final String POST_NOT_FOUND_MSG_KEY = "PostNotExist";
    private static final String POST_MSG = "Post Not Found";
    private static final String COMMENT_NOT_FOUND_MSG_KEY = "CommentNotExist";
    private static final String COMMENT_MSG = "Comment Not Found";
    private static final String ASSIGNMENT_NOT_FOUND_MSG_KEY = "AssignmentNotExist";
    private static final String ASSIGNMENT_MSG = "Assignment Not Found";
    private static final String SUBMISSION_NOT_FOUND_MSG_KEY = "SubmissionNotExist";
    private static final String SUBMISSION_MSG = "Submission Not Found";
    public static ResponseException notFound(String messageKey, String message) {
        return new ResponseException(messageKey, message, HttpStatus.NOT_FOUND);
    }

    public static ResponseException badRequest(String messageKey, String message) {
        return new ResponseException(messageKey, message,HttpStatus.BAD_REQUEST);
    }

    public static ResponseException internalServer(String messageKey, String message){
        return new ResponseException(messageKey, message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static ResponseException userNotFound(){
        return notFound(USER_NOT_FOUND_MSG_KEY, USER_MSG);
    }

    public static ResponseException classroomNotFound(){
        return notFound(CLASSROOM_NOT_FOUND_MSG_KEY, CLASSROOM_MSG);
    }

    public static ResponseException courseNotFound(){
        return notFound(COURSE_NOT_FOUND_MSG_KEY, COURSE_MSG);
    }

    public static ResponseException postNotFound(){
        return notFound(POST_NOT_FOUND_MSG_KEY, POST_MSG);
    }

    public static ResponseException commentNotFound(){
        return notFound(COMMENT_NOT_FOUND_MSG_KEY, COMMENT_MSG);
    }

    public static ResponseException assignmentNotFound(){
        return notFound(ASSIGNMENT_NOT_FOUND_MSG_KEY, ASSIGNMENT_MSG);
    }

    public static ResponseException submissionNotFound(){
        return notFound(SUBMISSION_NOT_FOUND_MSG_KEY, SUBMISSION_MSG);
    }
}
