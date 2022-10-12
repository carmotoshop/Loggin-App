package com.example.loggincontrol.customer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Order(2)
public class CustomerSecurityConfig {

    @Bean
    public UserDetailsService customerUserDetailsService(){

        return new CustomUserDetailsService();
    }

    @Bean
    public PasswordEncoder passwordEncoder2(){

        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public AuthenticationProvider authenticationProvider2(){

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(customerUserDetailsService());
        provider.setPasswordEncoder(passwordEncoder2());

        return provider;
    }


    @Bean
    public SecurityFilterChain filterChain2(HttpSecurity http) throws Exception{

        //Dando permisos al admin
        //Esto es una configuracion de logeo para el administrador
        //que otorga mucho de las peticiones a urls.

        http.authenticationProvider(authenticationProvider2());
        http.authorizeRequests().antMatchers("/").permitAll();
        http.antMatcher("/customer/**")
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/customer/login")
                .usernameParameter("email")
                .loginProcessingUrl("/customer/login")
                .defaultSuccessUrl("/customer/home")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/customer/logout")
                .logoutSuccessUrl("/");

        return http.build();

    }
}
