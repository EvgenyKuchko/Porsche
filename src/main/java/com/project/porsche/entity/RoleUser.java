package com.project.porsche.entity;

import org.springframework.security.core.GrantedAuthority;

public enum RoleUser implements GrantedAuthority {
    USER,
    MANAGER;

    @Override
    public String getAuthority() {
        return name();
    }
}