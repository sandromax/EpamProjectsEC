package org.sandromax.fastest.controller.until.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter(urlPatterns = {"/*"})
public class CheckEncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("CheckEncodingFilter---");
        System.out.println("request encoding: " + servletRequest.getCharacterEncoding());
        System.out.println("response encoding: " + servletResponse.getCharacterEncoding());

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
