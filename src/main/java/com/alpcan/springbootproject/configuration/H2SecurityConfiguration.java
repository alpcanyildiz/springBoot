package com.alpcan.springbootproject.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@Order(value=0)
public class H2SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void  configure(HttpSecurity httpSecurity) throws Exception{


        httpSecurity.antMatcher("/console/**").authorizeRequests().anyRequest().permitAll();
        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
    }
}
