package com.project.porsche.controller;

import com.project.porsche.dto.UserDto;
import com.project.porsche.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.validation.BindingResult;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class RegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private BindingResult bindingResult;

    @Test
    void shouldReturnRegistrationPage() throws Exception {
        this.mockMvc.perform(get("/registration"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/view/registration.jsp"));
    }

    @Test
    void shouldSaveNewUserAndRedirectToLoginPage() throws Exception {
        UserDto user = new UserDto();

        given(userService.saveNewUser(user)).willReturn(true);

        this.mockMvc.perform(post("/registration"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/login"));

        verify(userService, times(1)).saveNewUser(user);
    }

    @Test
    void shouldBanRegistrationIfFieldsHaveErrorsAndReturnRegistrationPage() throws Exception {
        given(bindingResult.hasErrors()).willReturn(true);

        this.mockMvc.perform(post("/registration"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/view/registration.jsp"));
    }

    @Test
    void shouldBanRegistrationIfLoginAlreadyExistAndReturnRegistrationPage() throws Exception {
        String login = "login";

        given(userService.findUserByLogin(login)).willReturn(true);

        this.mockMvc.perform(post("/registration"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/view/registration.jsp"));
    }
}