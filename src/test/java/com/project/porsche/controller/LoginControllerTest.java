package com.project.porsche.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc //тест запускается в фейковом окружении и подменяет слой MVC
public class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnPageByUrl() throws Exception {
        this.mockMvc.perform(get("/login"))   //выполняется get - запрос по url
                .andDo(print())  //выводит полученный результат в консоль
                .andExpect(status().isOk())   // проверяет полученный код результата(200)
                .andExpect(forwardedUrl("/WEB-INF/view/login.jsp")); // проверка получаемой страницы
    }

    @Test
    public void shouldRedirectUserToMainPageIfLogInSuccess() throws Exception {
        this.mockMvc.perform(formLogin().user("qwerty").password("12345"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/main"));
    }

    @Test
    public void shouldBanLogInIfUserNotExistInDB() throws Exception {
        this.mockMvc.perform(formLogin().user("jack").password("55555"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/login?error=true"));
    }
}