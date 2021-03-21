package com.demo.microservice.goodmorning.config;

import org.springframework.security.oauth2.common.exceptions.UnauthorizedClientException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class GatewayInterceptor  extends HandlerInterceptorAdapter {

    private static final String GATEWAY_ENDPOINT_PORT = "8765";
    private static final String X_FORWARDED_PORT= "x-forwarded-port";
    private static final String X_FORWARDED_PREFIX= "/good-morning";


    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws IOException {
        String proxyForwardedHostHeader = request.getHeader(X_FORWARDED_PORT);
        if (proxyForwardedHostHeader == null || !proxyForwardedHostHeader.equals(GATEWAY_ENDPOINT_PORT)) {
            response.getWriter().write("Unauthorized");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        return true;
    }
}
