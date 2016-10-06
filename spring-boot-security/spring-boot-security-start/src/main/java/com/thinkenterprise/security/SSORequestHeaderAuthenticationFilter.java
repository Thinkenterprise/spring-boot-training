package com.thinkenterprise.security;

import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;

public class SSORequestHeaderAuthenticationFilter extends RequestHeaderAuthenticationFilter {

    public SSORequestHeaderAuthenticationFilter() {
        super();
        this.setPrincipalRequestHeader("SM_USER");
    }

    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        String userName = (String) (super.getPreAuthenticatedPrincipal(request));
        if (userName == null || userName.isEmpty()) {
            return userName;
        }

        return userName;
    }
}
