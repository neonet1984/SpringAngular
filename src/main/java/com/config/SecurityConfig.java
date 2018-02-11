package com.config;

import com.config.security.component.RestAccessDeniedHandler;
import com.config.security.component.RestAuthenticationEntryPoint;
import com.config.security.filter.AuthenticationTokenProcessingFilter;
import com.config.security.filter.RestExceptionTranslationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@ComponentScan("com.config.security")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.logout();
        http.formLogin().disable();
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login/authentication").permitAll()
                .antMatchers("/rest/getTestData").permitAll()
                .antMatchers("/rest/**").access("hasRole('ROLE_USER')");
        http.addFilterBefore(new AuthenticationTokenProcessingFilter(userDetailsService), UsernamePasswordAuthenticationFilter.class);
        http.exceptionHandling()
                .authenticationEntryPoint(new RestAuthenticationEntryPoint());
    }
    @Bean
    public static ExceptionTranslationFilter exceptionTranslationFilter() {
        RestExceptionTranslationFilter exceptionTranslationFilter = new RestExceptionTranslationFilter(new RestAuthenticationEntryPoint());
        RestAccessDeniedHandler accessDeniedHandlerImpl = new RestAccessDeniedHandler();
        exceptionTranslationFilter.setAccessDeniedHandler(accessDeniedHandlerImpl);
        exceptionTranslationFilter.afterPropertiesSet();
        return exceptionTranslationFilter;
    }



}
