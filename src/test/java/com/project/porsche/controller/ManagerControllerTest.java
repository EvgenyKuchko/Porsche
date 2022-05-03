package com.project.porsche.controller;

import com.project.porsche.dto.DealDto;
import com.project.porsche.service.DealService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ManagerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DealService dealService;

    private DealDto testDeal;
    private long dealId;

    @Before
    public void setUp() {
        dealId = 1L;

        testDeal = DealDto.builder()
                .id(dealId)
                .city("Minsk")
                .country("Belarus")
                .status("Active")
                .price("10000")
                .model("911")
                .build();
    }

    @Test
    public void shouldRedirectIfUserHaveNotManagerRole() throws Exception {
        this.mockMvc.perform(get("/deals"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    @Test
    @WithUserDetails("manager")
    public void shouldReturnPageByUrlIfUserHaveManagerRole() throws Exception {
        this.mockMvc.perform(get("/deals"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/view/manager-list.jsp"));
    }

    @Test
    public void shouldRedirectIfUserHaveNotManager() throws Exception {
        this.mockMvc.perform(get("/deals/{id}", 1L))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    @Test
    @WithUserDetails("manager")
    public void shouldReturnPageWithAllDeals() throws Exception {
        List<DealDto> allDeals = Collections.singletonList(testDeal);

        given(dealService.getDeals()).willReturn(allDeals);

        this.mockMvc.perform(get("/deals"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attribute("deals", hasSize(1)))
                .andExpect(model().attribute("deals", hasItem(
                        allOf(
                                hasProperty("price", is(testDeal.getPrice())),
                                hasProperty("model", is(testDeal.getModel()))
                        )
                )));

        verify(dealService, times(1)).getDeals();
    }

    @Test
    @WithUserDetails("manager")
    public void shouldReturnDealPageById() throws Exception {
        given(dealService.getDeal(dealId)).willReturn(testDeal);

        this.mockMvc.perform(get("/deals/{id}", testDeal.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/view/manager-form.jsp"))
                .andExpect(model().attribute("deal", hasProperty("city", is(testDeal.getCity()))))
                .andExpect(model().attribute("deal", hasProperty("country", is(testDeal.getCountry()))))
                .andExpect(model().attribute("deal", hasProperty("status", is(testDeal.getStatus()))));

        verify(dealService, times(1)).getDeal(dealId);
    }

    @Test
    @WithUserDetails("manager")
    public void shouldSuccessUpdateDealAndRedirectedToDeals() throws Exception {
        doNothing().when(dealService).update(testDeal.getStatus(), dealId);

        this.mockMvc.perform(post("/deals/{dealId}", testDeal.getId())
                .param("dealId", String.valueOf(1L))  // передает параметры помеченные @RequestParam в контроллере
                .flashAttr("deal", testDeal))  // передает параметр помеченный @ModelAttribute  контроллере
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/deals"));

        verify(dealService, times(1)).update(testDeal.getStatus(), dealId);
    }
}