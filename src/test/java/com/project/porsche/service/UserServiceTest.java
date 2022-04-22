package com.project.porsche.service;

import com.project.porsche.dto.UserDto;
import com.project.porsche.entity.RoleUser;
import com.project.porsche.repository.UserRepository;
import com.project.porsche.transformers.UserTransformer;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserTransformer userTransformer;
    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    void shouldSaveUserAndReturnTrue() {
        UserDto savedUser = new UserDto();
        savedUser.setPassword("password");

        when(bCryptPasswordEncoder.encode(savedUser.getPassword())).thenReturn("xxx");

        boolean isUserSaved = userService.saveNewUser(savedUser);

        assertTrue(isUserSaved);
        assertTrue(CoreMatchers.is(savedUser.getRoles()).matches(Collections.singleton(RoleUser.USER)));
        assertTrue(CoreMatchers.is(savedUser.getPassword()).matches("xxx"));
    }

    @Test
    void shouldFailSaveUserAndReturnFalseIfUserLoginAlreadyExist() {
        UserDto savedUser = new UserDto();
        savedUser.setLogin("login");

        when(userRepository.existsByLogin(savedUser.getLogin())).thenReturn(true);

        boolean isUserSaved = userService.saveNewUser(savedUser);

        assertFalse(isUserSaved);
    }

    @Test
    void loadUserByUsernameShouldFailAndThrowUserNotFoundExceptionIfUserNotExist() {
        String login = "login";

        when(userRepository.findByLogin(anyString())).thenReturn(null);

        assertThrows(UsernameNotFoundException.class, () -> {

            userService.loadUserByUsername(login);

        });
    }

    @Test
    void shouldLoadAndReturnUserByUsername() {
        Set<RoleUser> roles = new HashSet<>();
        roles.add(RoleUser.USER);
        UserDto user = new UserDto();
        user.setLogin("login");
        user.setPassword("password");
        user.setRoles(roles);

        when(userTransformer.transform(userRepository.findByLogin(anyString()))).thenReturn(user);

        UserDetails userDetails = userService.loadUserByUsername("login");

        assertThat(user.getLogin()).isEqualTo(userDetails.getUsername());
        assertThat(user.getPassword()).isEqualTo(userDetails.getPassword());
    }
}