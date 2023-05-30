package com.nonit.classroom.constant;

public class AuthorityConstants {

    public static final String HAS_ROLE_ADMIN = "hasRole('ADMIN')";
    public static final String HAS_ROLE_TEACHER_ADMIN = "hasAnyRole('TEACHER','ADMIN')";
    public static final String HAS_ROLE_TEACHER_STUDENT = "hasAnyRole('TEACHER','STUDENT')";
    public static final String HAS_ANY_ROLE = "hasAnyRole('ADMIN','TEACHER','STUDENT')";
    public static final String HAS_ROLE_TEACHER = "hasAnyRole('TEACHER')";
    public static final String HAS_ROLE_STUDENT = "hasAnyRole('STUDENT')";
}
