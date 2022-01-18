package com.project.porsche.transformers;

import com.project.porsche.dto.DealDto;
import com.project.porsche.entity.Deal;
import org.springframework.stereotype.Component;

@Component
public class DealTransformer implements TransformerDto<Deal, DealDto> {

    @Override
    public DealDto transform(Deal deal) {
        return DealDto.builder()
                .id(deal.getId())
                .city(deal.getCity())
                .country(deal.getCountry())
                .creatingDate(deal.getCreatingDate())
                .model(deal.getCar().getModel())
                .firstName(deal.getUser().getFirstName())
                .lastName(deal.getUser().getLastName())
                .price(deal.getCar().getPrice())
                .status(deal.getStatus())
                .phoneNumber(deal.getPhoneNumber())
                .build();
    }
}