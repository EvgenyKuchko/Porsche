package com.project.porsche.controller;

import com.project.porsche.dto.CarDto;
import com.project.porsche.service.CarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ModelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    @Test
    public void shouldReturnPageByUrl() throws Exception {

        String model = "911";

        CarDto car = CarDto.builder()
                .model(model)
                .price("10000")
                .power(500)
                .build();

        given(carService.getCarByModel(model)).willReturn(car);

        this.mockMvc.perform(get("/model/{model}", "911"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/view/model.jsp"))
                .andExpect(model().attribute("car", hasProperty("price", is(car.getPrice()))))
                .andExpect(model().attribute("car", hasProperty("power", is(car.getPower()))));

        verify(carService, times(1)).getCarByModel(model);
    }
}