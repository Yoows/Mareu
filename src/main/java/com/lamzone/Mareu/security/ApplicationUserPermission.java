package com.lamzone.Mareu.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ApplicationUserPermission {
    EMPLOYEE_READ("employee:read"),
    EMPLOYEE_WRITE("employee:write"),
    MEETING_READ("meeting:read"),
    MEETING_WRITE("meeting:write");

    private final String permission;
}
