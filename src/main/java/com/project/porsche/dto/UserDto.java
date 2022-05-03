package com.project.porsche.dto;

import com.project.porsche.entity.RoleUser;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserDto implements Dto {
    @NotNull
    @Size(min = 2, max = 15, message = "first name must be 2 or more characters")
    private String firstName;
    @NotNull
    @Size(min = 2, max = 20, message = "last name must be 2 or more characters")
    private String lastName;
    @NotNull
    @Min(value = 18, message = "age cannot be less than 18")
    private int age;
    @NotNull
    @Size(min = 5, message = "login name must be 5 or more characters")
    private String login;
    @NotNull
    @Size(min = 5, message = "password must be 5 or more characters")
    private String password;
    private Set<RoleUser> roles;
}