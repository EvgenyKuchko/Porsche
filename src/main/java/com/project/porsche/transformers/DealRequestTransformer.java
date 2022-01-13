package com.project.porsche.transformers;

import com.project.porsche.dto.DealRequestDto;
import com.project.porsche.entity.Deal;

public class DealRequestTransformer implements Transformer<Deal, DealRequestDto> {
    @Override
    public DealRequestDto transform(Deal deal) {
        DealRequestDto dealRequestDto = new DealRequestDto();
        dealRequestDto.setCity(deal.getCity());
        dealRequestDto.setCountry(deal.getCountry());
        dealRequestDto.setPhoneNumber(deal.getPhoneNumber());
        return dealRequestDto;
    }

    @Override
    public Deal transform(DealRequestDto dealRequestDto) {
//        Deal deal = new Deal();
//        deal.setCity(dealRe);
        return null;
    }
}