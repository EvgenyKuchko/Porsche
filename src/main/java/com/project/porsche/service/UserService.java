package com.project.porsche.service;

import com.project.porsche.dto.UserDto;
import com.project.porsche.entity.RoleUser;
import com.project.porsche.repository.UserRepository;
import com.project.porsche.transformers.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserTransformer userTransformer;

    @Transactional
    public boolean saveNewUser(UserDto userDto) {
        boolean isUserExist = userRepository.existsByLogin(userDto.getLogin());
        if (isUserExist) {
            return false;
        }
        userDto.setRoles(Collections.singleton(RoleUser.USER));
        userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        userRepository.save(userTransformer.transform(userDto));
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserDto userDto = userTransformer.transform(userRepository.findByLogin(login));
        if (userDto == null) {
            throw new UsernameNotFoundException("User not found");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (RoleUser role : userDto.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }
        return new org.springframework.security.core.userdetails.User(userDto.getLogin(), userDto.getPassword(), grantedAuthorities);
    }

    @Transactional
    public boolean findUserByLogin(String login) {
        return userRepository.existsByLogin(login);
    }
}