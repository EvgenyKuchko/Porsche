package com.project.porsche.service;

import com.project.porsche.dto.UserDto;
import com.project.porsche.entity.RoleUser;
import com.project.porsche.repository.UserRepository;
import com.project.porsche.transformers.UserTransformer;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
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

    private String login;
    private UserDto user;

    @BeforeEach
    void setUp() {
        login = "login";

        user = new UserDto();
        user.setLogin("login");
        user.setPassword("password");
    }

    @Test
    void shouldSaveUserAndReturnTrue() {
        when(bCryptPasswordEncoder.encode(user.getPassword())).thenReturn("xxx");

        boolean isUserSaved = userService.saveNewUser(user);

        assertTrue(isUserSaved);
        assertTrue(CoreMatchers.is(user.getRoles()).matches(Collections.singleton(RoleUser.USER)));
        assertTrue(CoreMatchers.is(user.getPassword()).matches("xxx"));
    }

    @Test
    void shouldFailSaveUserAndReturnFalseIfUserLoginAlreadyExist() {
        when(userRepository.existsByLogin(user.getLogin())).thenReturn(true);

        boolean isUserSaved = userService.saveNewUser(user);

        assertFalse(isUserSaved);
    }

    @Test
    void loadUserByUsernameShouldFailAndThrowUserNotFoundExceptionIfUserNotExist() {
        when(userRepository.findByLogin(anyString())).thenReturn(null);

        assertThrows(UsernameNotFoundException.class, () -> userService.loadUserByUsername(login));
    }

    @Test
    void shouldLoadAndReturnUserByUsername() {
        Set<RoleUser> roles = new HashSet<>();
        roles.add(RoleUser.USER);
        user.setRoles(roles);

        when(userTransformer.transform(userRepository.findByLogin(anyString()))).thenReturn(user);

        UserDetails userDetails = userService.loadUserByUsername("login");

        assertThat(user.getLogin()).isEqualTo(userDetails.getUsername());
        assertThat(user.getPassword()).isEqualTo(userDetails.getPassword());
    }

    @Test
    void shouldReturnTrueIfUserFoundByLogin() {
        when(userRepository.existsByLogin(login)).thenReturn(true);

        boolean find = userRepository.existsByLogin(login);

        assertTrue(find);
    }
}