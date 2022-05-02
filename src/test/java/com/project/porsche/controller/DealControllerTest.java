package com.project.porsche.controller;

import com.project.porsche.dto.DealRequestDto;
import com.project.porsche.service.DealService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DealControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DealService dealService;

    @Test
    public void shouldRedirectToLoginPageNotAuthUser() throws Exception {

        String model = "911";

        this.mockMvc.perform(get("/deal/{model}", model))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    @Test
    @WithUserDetails("qwerty")
    public void shouldReturnPageIfUserAuth() throws Exception {

        String model = "911";

        this.mockMvc.perform(get("/deal/{model}", model))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/view/form.jsp"));
    }

    @Test
    @WithUserDetails("qwerty")
    public void shouldSaveNewDealAndRedirectToSuccessPage() throws Exception {

        DealRequestDto deal = new DealRequestDto();
        deal.setPhoneNumber("+375291112233");
        deal.setCountry("Belarus");
        deal.setCity("Brest");
        String model = "911";
        UserDetails loggedUser = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        doNothing().when(dealService).saveDeal(deal, model, loggedUser);

        this.mockMvc.perform(post("/deal/{model}", model).flashAttr("deal", deal).with(user(loggedUser)))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/deal/success"));

        verify(dealService, times(1)).saveDeal(deal, model, loggedUser);
    }

    @Test
    @WithUserDetails("qwerty")
    public void shouldReturnSuccessPageIfUserMadeADeal() throws Exception {
        this.mockMvc.perform(get("/deal/success"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/view/deal.jsp"));
    }
}