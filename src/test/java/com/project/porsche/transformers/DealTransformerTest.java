package com.project.porsche.transformers;

import com.project.porsche.dto.DealDto;
import com.project.porsche.entity.Car;
import com.project.porsche.entity.Deal;
import com.project.porsche.entity.User;
import org.junit.Test;

import java.sql.Timestamp;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DealTransformerTest {

    private static final DealTransformer dealTransformer = new DealTransformer();

    @Test
    public void shouldTransformDealToDealDto() {
        Deal deal = new Deal();
        deal.setId(1L);
        deal.setStatus("Active");
        deal.setCreatingDate(new Timestamp(System.currentTimeMillis()));
        deal.setCountry("Belarus");
        deal.setCity("Minsk");
        deal.setPhoneNumber("+375290000000");
        Car car = new Car();
        deal.setCar(car);
        User user = new User();
        deal.setUser(user);

        DealDto dealDto = dealTransformer.transform(deal);

        assertThat(deal.getCountry())
                .isEqualTo(dealDto.getCountry());
    }
}