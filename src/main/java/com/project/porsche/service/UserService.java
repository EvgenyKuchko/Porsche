package com.project.porsche.service;

import com.project.porsche.entity.User;
import com.project.porsche.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public boolean saveNewUser(User user){
        User userFromDB = userRepository.findByLogin(user.getLogin());

        if(userFromDB != null){
            return false;
        }

        userRepository.save(user);
        return true;
    }
}
