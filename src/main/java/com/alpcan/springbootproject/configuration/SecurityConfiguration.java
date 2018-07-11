package com.alpcan.springbootproject.configuration;


import com.alpcan.springbootproject.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Primary
@Configuration
@EnableGlobalMethodSecurity( securedEnabled = true )

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationService authenticationService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationService);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{

        httpSecurity.authorizeRequests()
                .antMatchers("/home","/resources/**","/","/registration","/reg/**", "/index").permitAll()
                .antMatchers("/admin/**").authenticated()

                .and().formLogin().successForwardUrl("/admin/listUser").loginProcessingUrl("/login").passwordParameter("password").usernameParameter("username").permitAll()
                .and().logout().logoutSuccessUrl("/login?logout").permitAll();
        httpSecurity.csrf().disable();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }


}
