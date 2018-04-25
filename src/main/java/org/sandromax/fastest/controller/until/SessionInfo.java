package org.sandromax.fastest.controller.until;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Enumeration;

public class SessionInfo {
    public static void show(HttpServletRequest req) {
        HttpSession session = req.getSession();

        System.out.println("--- --- --- SESSION INFO --- --- ---");
        System.out.println("current time: " + new Date());
        System.out.println("class name: " + req.getClass().getName());
        System.out.println("id: " + session.getId());
        System.out.println("creation time: " + session.getCreationTime());
        System.out.println("servlet context: " + session.getServletContext());

        Enumeration attrs = session.getAttributeNames();
        showEnum(req, attrs, "attr");


        Enumeration params = req.getParameterNames();
        showEnum(req, params, "param");

    }

    private static void showEnum(HttpServletRequest req, Enumeration en, String name) {
        int counterP =0;
        while(en.hasMoreElements()) {
            String param = (String) en.nextElement();
            System.out.println(name + " name: " + param);

            String paramValue = (String) req.getParameter(param);
            System.out.println(name + " value: " + paramValue);

            counterP++;
        }
        System.out.println("Number of " + name + ": " + counterP);
    }
}
