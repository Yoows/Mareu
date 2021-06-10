package com.lamzone.Mareu.security;

import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.lamzone.Mareu.security.ApplicationUserPermission.*;

@AllArgsConstructor
@Getter
public enum ApplicationUserRole {
    EMPLOYEE(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(MEETING_READ, MEETING_WRITE, EMPLOYEE_READ, EMPLOYEE_WRITE));

    private final Set<ApplicationUserPermission> permissions;

    public Set<SimpleGrantedAuthority> geGrantedAuthorities(){
        Set<SimpleGrantedAuthority> permissions = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
