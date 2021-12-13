package com.project.porsche.config;

import com.project.porsche.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder(8);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()   //Включаем авторизацию
                .antMatchers("/", "/static/**", "/registration",
                        "/main", "/cars", "/model/*", "/news", "/aboutCompany",
                        "/about-company", "/news", "/contacts", "/h2-console/**").permitAll()  //указываем, для каких страниц есть доступ у всех
                .antMatchers("/manager/**").hasAuthority("MANAGER")
                .antMatchers("/form").hasAuthority("USER")
                .anyRequest().authenticated()  //а для всех остальных запросов мы требуем авторизацию
                .and()
                .formLogin()  // включаем форму Login (из нашего шаблона MvcConfig
                .loginPage("/login")  // указываем, что форма Login находится по данному мапингу
                .failureUrl("/login?error=true")
                .defaultSuccessUrl("/main")  // перенаправление на главную страницу после успешного входа
                .permitAll()  // указываем, что формой логина могут пользоваться все
                .and()
                .logout()  // выход из аккаунта
                .permitAll()  // также указываем, что могут пользоваться все
                .logoutSuccessUrl("/main");

        http.csrf().disable();
        http.headers().frameOptions().disable();    //Команды, благодоря которым открывается консоль h2
    }

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userService)
                .passwordEncoder(bCryptPasswordEncoder());
    }
}