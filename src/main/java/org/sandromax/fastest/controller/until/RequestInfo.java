package org.sandromax.fastest.controller.until;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Enumeration;

public class RequestInfo {

    public static void show(HttpServletRequest req) {
        System.out.println("--- --- --- REQUEST INFO --- --- ---");
        System.out.println("current time: " + new Date());
        System.out.println("class name: " + req.getClass().getSimpleName());
        System.out.println("context path: " + req.getContextPath() + "\nprotocol: " + req.getProtocol());
        System.out.println("request URI: " + req.getRequestURI() + "\nremote user: " + req.getRemoteUser());
        System.out.println("auth type: " + req.getAuthType() + "\nserver name: " + req.getServerName());
        System.out.println("requested session id: " + req.getRequestedSessionId() + "\ncharacter encoding: " + req.getCharacterEncoding());
        System.out.println("locale: " + req.getLocale() + "\nserver port: " + req.getServerPort());


        Enumeration params = req.getParameterNames();
        int counterP =0;
        while(params.hasMoreElements()) {
            String param = (String) params.nextElement();
            System.out.println("param name: " + param);

            String paramValue = (String) req.getParameter(param);
            System.out.println("param value: " + paramValue);

            counterP++;
        }
        System.out.println("Number of params: " + counterP);

        Enumeration headerNames = req.getHeaderNames();
        int counterH = 0;
        while (headerNames.hasMoreElements()) {
            String headerName = (String) headerNames.nextElement();
            System.out.println("Header Name: " + headerName);
            String headerValue = req.getHeader(headerName);
            System.out.println("Header Value: " + headerValue);
            counterH++;
        }
        System.out.println("Number of headers: " + counterH);

        Enumeration attrs = req.getAttributeNames();
        int counterA = 0;
        while (attrs.hasMoreElements()) {
            String attribute = (String) attrs.nextElement();
            System.out.println("Attr name: " + attribute);

            String attrValue = (String) req.getAttribute(attribute);
            System.out.println("Attr value: " + attrValue);

            counterA++;
        }
        System.out.println("Number of attrs: " + counterA);
    }

}
