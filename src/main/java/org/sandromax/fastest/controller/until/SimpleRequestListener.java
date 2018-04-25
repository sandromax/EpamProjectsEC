package org.sandromax.fastest.controller.until;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class SimpleRequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent ev) {
        System.out.println("Request Destroyed: " + ev.getServletRequest().getAttribute("lifecycle"));
    }

    @Override
    public void requestInitialized(ServletRequestEvent ev) {
        HttpServletRequest req = (HttpServletRequest) ev.getServletRequest();
        String uri = "Request Initializer for " + req.getRequestURI();
        String id = "Request Initializer with ID=" + req.getRequestedSessionId();
        System.out.println(uri + "\n" + id);
        ServletContext context = ev.getServletContext();

        Integer reqCount = (Integer)req.getSession().getAttribute("counter");
        if(reqCount == null) {
            reqCount = 0;
        }
        context.log(uri + "\n" + id + ", Request Counter = " + reqCount);
    }
}
