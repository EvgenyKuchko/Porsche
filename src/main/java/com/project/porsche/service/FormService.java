package com.project.porsche.service;

import com.project.porsche.entity.Car;
import com.project.porsche.entity.Form;
import com.project.porsche.entity.User;
import com.project.porsche.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FormService {

    @Autowired
    private FormRepository formRepository;

    @Autowired
    private CarService carService;

    @Autowired
    private UserService userService;

    @Transactional
    public boolean saveForm(Form form){
        formRepository.save(form);
        return true;
    }
}
