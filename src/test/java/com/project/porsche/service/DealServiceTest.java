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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DealServiceTest {

    @InjectMocks
    private DealService dealService;
    @Mock
    private DealRepository dealRepository;
    @Mock
    private CarRepository carRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private DealTransformer dealTransformer;

    @Test
    void shouldReturnDealById() {
        Deal deal = new Deal();
        deal.setId(1L);

        when(dealRepository.getById(deal.getId())).thenReturn(deal);

        assertThat(dealService.getDeal(deal.getId())).isEqualTo(dealTransformer.transform(deal));
    }

    @Test
    void shouldReturnAllDeals() {
        Deal dealOne = new Deal();
        Deal dealTwo = new Deal();
        List<Deal> deals = new ArrayList<>();
        deals.add(dealOne);
        deals.add(dealTwo);

        when(dealRepository.findAll()).thenReturn(deals);

        List<DealDto> dtoDeals = dealService.getDeals();

        assertThat(deals.size()).isEqualTo(dtoDeals.size());
    }

    @Test
    void shouldSaveNewDeal() {
        Deal deal = new Deal();
        String model = "911";
        Car car = new Car();
        UserDetails userDetails = new User();
        User user = new User();
        DealRequestDto dealRequestDto = new DealRequestDto();
        dealRequestDto.setCity("London");
        dealRequestDto.setCountry("Great Britain");
        dealRequestDto.setPhoneNumber("+123557896542");
        deal.setCreatingDate(new Timestamp(System.currentTimeMillis()));
        deal.setStatus("Active");
        deal.setCar(car);
        deal.setUser(user);
        deal.setCountry(dealRequestDto.getCountry());
        deal.setCity(dealRequestDto.getCity());
        deal.setPhoneNumber(dealRequestDto.getPhoneNumber());

        when(carRepository.findByModel(model)).thenReturn(car);
        when(userRepository.findByLogin(userDetails.getUsername())).thenReturn(user);
        lenient().when(dealRepository.save(deal)).thenReturn(deal);

        dealService.saveDeal(dealRequestDto, model, userDetails);

        assertThat(deal.getCity()).isEqualTo(dealRequestDto.getCity());
        assertThat(deal.getStatus()).isEqualTo("Active");
    }

    @Test
    void shouldReturnUpdatedDeal() {
        dealService.update(anyString(), anyLong());

        verify(dealRepository, times(1)).changeStatus(anyString(), anyLong());
    }
}