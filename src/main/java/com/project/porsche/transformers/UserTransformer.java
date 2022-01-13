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
        UserDto userDto = new UserDto();
        userDto.setLogin(user.getLogin());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setAge(user.getAge());
        userDto.setPassword(user.getPassword());
        Set<RoleDto> roles = user.getRoles().stream()
                .map(roleTransformer::transform)
                .collect(Collectors.toSet());
        userDto.setRoles(roles);
        return userDto;
    }

    @Override
    public User transform(UserDto userDto) {
        User user = new User();
        user.setLogin(userDto.getLogin());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setAge(userDto.getAge());
        user.setPassword(userDto.getPassword());
        Set<Role> roles = userDto.getRoles().stream()
                .map(roleTransformer::transform)
                .collect(Collectors.toSet());
        user.setRoles(roles);
        return user;
    }
}