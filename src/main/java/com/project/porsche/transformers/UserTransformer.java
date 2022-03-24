package com.project.porsche.transformers;

import com.project.porsche.dto.UserDto;
import com.project.porsche.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserTransformer implements Transformer<User, UserDto> {

    @Override
    public UserDto transform(User user) {
        return UserDto.builder()
                .login(user.getLogin())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .age(user.getAge())
                .password(user.getPassword())
                .roles(user.getRoles())
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
                .roles(userDto.getRoles())
                .build();
    }
}