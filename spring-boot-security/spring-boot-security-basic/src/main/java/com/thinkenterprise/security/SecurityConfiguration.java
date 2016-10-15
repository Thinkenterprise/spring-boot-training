package com.thinkenterprise.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsByNameServiceWrapper;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(ssoFilter(), RequestHeaderAuthenticationFilter.class)
                .authenticationProvider(preAuthAuthProvider())
                .csrf().disable()
                .authorizeRequests().anyRequest().authenticated();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(preAuthAuthProvider());
    }

    @Bean
    public UserDetailsByNameServiceWrapper<PreAuthenticatedAuthenticationToken> userDetailsServiceWrapper() {
        UserDetailsByNameServiceWrapper<PreAuthenticatedAuthenticationToken> wrapper =
                new UserDetailsByNameServiceWrapper<>();
        wrapper.setUserDetailsService(new CustomUserDetailsService());
        return wrapper;
    }

    @Bean
    public PreAuthenticatedAuthenticationProvider preAuthAuthProvider() {
        PreAuthenticatedAuthenticationProvider preAuthenticatedAuthenticationProvider =
                new PreAuthenticatedAuthenticationProvider();
        preAuthenticatedAuthenticationProvider.setPreAuthenticatedUserDetailsService(userDetailsServiceWrapper());
        return preAuthenticatedAuthenticationProvider;
    }

    @Bean
    public SSORequestHeaderAuthenticationFilter ssoFilter() throws Exception {
        SSORequestHeaderAuthenticationFilter filter = new SSORequestHeaderAuthenticationFilter();
        filter.setAuthenticationManager(authenticationManager());
        return filter;
    }

}
