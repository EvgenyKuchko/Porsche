package com.project.porsche.transformers;

import com.project.porsche.dto.RoleDto;
import com.project.porsche.dto.UserDto;
import com.project.porsche.entity.Role;
import com.project.porsche.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserTransformer implements Transformer<User, UserDto> {

    @Autowired
    private RoleTransformer roleTransformer;

    @Override
    public UserDto transform(User user) {
        return UserDto.builder()
                .login(user.getLogin())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .age(user.getAge())
                .password(user.getPassword())
                .roles(getRoles(user))
                .build();
    }

    @Override
    public User transform(UserDto userDto) {
        return User.builder()
                .login(userDto.getLogin())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .age(userDto.getAge())
                .password(userDto.getPassword())
                .roles(getRoles(userDto))
                .build();
    }

    private Set<RoleDto> getRoles(User user) {
        return user.getRoles().stream()
                .map(roleTransformer::transform)
                .collect(Collectors.toSet());
    }

    private Set<Role> getRoles(UserDto userDto) {
        return userDto.getRoles().stream()
                .map(roleTransformer::transform)
                .collect(Collectors.toSet());
    }
}