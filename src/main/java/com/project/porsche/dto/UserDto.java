package com.project.porsche.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UserDto implements Dto {
    private String firstName;
    private String lastName;
    private int age;
    private String login;
    private String password;
    private Set<RoleDto> roles;
}