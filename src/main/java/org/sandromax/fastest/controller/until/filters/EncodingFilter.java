//package org.sandromax.fastest.controller.until.filters;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.annotation.WebInitParam;
//import java.io.IOException;
//import java.util.Date;
//
//@WebFilter(urlPatterns = {"/*"},
//            initParams = {
//            @WebInitParam(name = "encoding", value = "UTF-8", description = "Encoding Param") })
//public class EncodingFilter implements Filter {
//    private String code;
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        code = filterConfig.getInitParameter("encoding");
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        String codeRequest = servletRequest.getCharacterEncoding();
////        System.out.println("doFilter output---");
////        System.out.println(new Date());
////        System.out.println("codeRequest: " + codeRequest);
////        System.out.println("code: " + code);
//
//        if(code != null && !code.equalsIgnoreCase(codeRequest)) {
////            System.out.println("inside if operator");
////            System.out.println("request encoding: " + servletRequest.getCharacterEncoding());
//            servletRequest.setCharacterEncoding(code);
////            System.out.println("(after)request encoding: " + servletRequest.getCharacterEncoding());
//
////            System.out.println("response encoding: " + servletResponse.getCharacterEncoding());
//            servletResponse.setCharacterEncoding(code);
////            System.out.println("(after)response encoding: " + servletResponse.getCharacterEncoding());
//
//        }
//
//        filterChain.doFilter(servletRequest, servletResponse);
//        System.out.println("doFilter: " + servletRequest.getCharacterEncoding());
//    }
//
//    @Override
//    public void destroy() {
//        code = null;
//    }
//}
