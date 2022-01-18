package com.project.porsche.service;

import com.project.porsche.dto.DealDto;
import com.project.porsche.dto.DealRequestDto;
import com.project.porsche.entity.Car;
import com.project.porsche.entity.Deal;
import com.project.porsche.entity.User;
import com.project.porsche.repository.CarRepository;
import com.project.porsche.repository.DealRepository;
import com.project.porsche.repository.UserRepository;
import com.project.porsche.transformers.DealTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DealService {

    @Autowired
    private DealRepository dealRepository;

    @Autowired
    private DealTransformer dealTransformer;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void saveDeal(@Valid DealRequestDto dealDto, String model, UserDetails userDetails) {
        Deal deal = new Deal();
        Car car = carRepository.findByModel(model);
        deal.setCar(car);
        User user = userRepository.findByLogin(userDetails.getUsername());
        deal.setUser(user);
        deal.setCity(dealDto.getCity());
        deal.setCountry(dealDto.getCountry());
        deal.setPhoneNumber(dealDto.getPhoneNumber());
        deal.setStatus("Active");
        deal.setCreatingDate(new Timestamp(System.currentTimeMillis()));
        dealRepository.save(deal);
    }

    @Transactional
    public List<DealDto> getDeals() {
        return dealRepository.findAll()
                .stream()
                .map(x -> dealTransformer.transform(x))
                .collect(Collectors.toList());
    }

    @Transactional
    public DealDto getDeal(Long id) {
        return dealTransformer.transform(dealRepository.getById(id));
    }

    @Transactional
    public void update(String status) {
        dealRepository.changeStatus(status);
    }
}