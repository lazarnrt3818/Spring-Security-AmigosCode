package com.example.springsecurity.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.example.springsecurity.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {

    STUDENT(Set.of()),
    ADMIN(Set.of(COURSE_WRITE, COURSE_READ, STUDENT_WRITE, STUDENT_READ)),
    ADMINTRAINEE(Set.of(COURSE_READ,STUDENT_READ));

    private final Set<ApplicationUserPermission> permissions;


    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
        Set<SimpleGrantedAuthority> permissions = getPermissions()
                .stream()
                .map(p -> new SimpleGrantedAuthority(p.getPermission())).collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return permissions;
    }

}
