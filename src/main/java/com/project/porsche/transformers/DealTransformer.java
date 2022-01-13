package com.project.porsche.transformers;

import com.project.porsche.dto.DealDto;
import com.project.porsche.entity.Deal;
import com.project.porsche.repository.CarRepository;
import com.project.porsche.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DealTransformer implements Transformer<Deal, DealDto> {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CarRepository carRepository;

    @Override
    public DealDto transform(Deal deal) {
        DealDto dealDto = new DealDto();
        dealDto.setId(deal.getId());
        dealDto.setCity(deal.getCity());
        dealDto.setCountry(deal.getCountry());
        dealDto.setCreatingDate(deal.getCreatingDate());
        dealDto.setModel(deal.getCar().getModel());
        dealDto.setFirstName(deal.getUser().getFirstName());
        dealDto.setLastName(deal.getUser().getLastName());
        dealDto.setPrice(deal.getCar().getPrice());
        dealDto.setStatus(deal.getStatus());
        dealDto.setPhoneNumber(deal.getPhoneNumber());
        return dealDto;
    }

    @Override
    public Deal transform(DealDto dealDto) {
        Deal deal = new Deal();
        deal.setCity(dealDto.getCity());
        deal.setCountry(dealDto.getCountry());
        deal.setCreatingDate(dealDto.getCreatingDate());
        deal.setPhoneNumber(dealDto.getPhoneNumber());
        deal.setStatus(dealDto.getStatus());
        deal.setCar(carRepository.findByModel(dealDto.getModel()));
        deal.setUser(userRepository.findByFirstName(dealDto.getFirstName()));
        return deal;
    }
}