package com.project.porsche.transformers;

import com.project.porsche.dto.DealDto;
import com.project.porsche.entity.Deal;
import org.springframework.stereotype.Component;

@Component
public class DealTransformer implements TransformerDto<Deal, DealDto> {

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
}