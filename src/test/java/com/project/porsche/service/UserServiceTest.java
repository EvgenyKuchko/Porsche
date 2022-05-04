package com.project.porsche.service;

import com.project.porsche.dto.UserDto;
import com.project.porsche.entity.RoleUser;
import com.project.porsche.entity.User;
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
import static org.mockito.Mockito.*;

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
        user.setLogin(login);
        user.setPassword("password");
    }

    @Test
    void shouldSaveUserAndReturnTrue() {
        User userEntity = new User();

        when(userRepository.existsByLogin(user.getLogin())).thenReturn(false);
        when(bCryptPasswordEncoder.encode(user.getPassword())).thenReturn("xxx");
        when(userTransformer.transform(user)).thenReturn(userEntity);
        when(userRepository.save(userEntity)).thenReturn(userEntity);

        boolean isUserSaved = userService.saveNewUser(user);

        verify(userRepository, times(1)).existsByLogin(user.getLogin());
        verify(userTransformer, times(1)).transform(user);
        verifyNoMoreInteractions(userTransformer);
        verify(userRepository, times(1)).save(userEntity);
        verifyNoMoreInteractions(userRepository);
        assertTrue(isUserSaved);
        assertTrue(CoreMatchers.is(user.getRoles()).matches(Collections.singleton(RoleUser.USER)));
        assertTrue(CoreMatchers.is(user.getPassword()).matches("xxx"));
    }

    @Test
    void shouldFailSaveUserAndReturnFalseIfUserLoginIsAlreadyExist() {
        when(userRepository.existsByLogin(user.getLogin())).thenReturn(true);

        boolean isUserSaved = userService.saveNewUser(user);

        verify(userRepository, times(1)).existsByLogin(user.getLogin());
        verifyNoMoreInteractions(userRepository);
        assertFalse(isUserSaved);
    }

    @Test
    void loadUserByUsernameShouldFailAndThrowUserNotFoundExceptionIfUserNotExist() {
        when(userRepository.findByLogin(login)).thenReturn(null);

        Throwable exception = assertThrows(UsernameNotFoundException.class, () -> userService.loadUserByUsername(login));
        assertEquals("User not found", exception.getMessage());
    }

    @Test
    void shouldLoadAndReturnUserByUsername() {
        Set<RoleUser> roles = new HashSet<>();
        roles.add(RoleUser.USER);
        user.setRoles(roles);

        when(userTransformer.transform(userRepository.findByLogin(login))).thenReturn(user);

        UserDetails userDetails = userService.loadUserByUsername(login);

        verify(userTransformer, times(1)).transform(userRepository.findByLogin(login));
        verifyNoMoreInteractions(userTransformer);
        assertThat(user.getLogin()).isEqualTo(userDetails.getUsername());
        assertThat(user.getPassword()).isEqualTo(userDetails.getPassword());
    }

    @Test
    void shouldReturnTrueIfUserFoundByLogin() {
        when(userRepository.existsByLogin(login)).thenReturn(true);

        boolean find = userRepository.existsByLogin(login);

        verify(userRepository, times(1)).existsByLogin(login);
        verifyNoMoreInteractions(userRepository);
        assertTrue(find);
    }
}