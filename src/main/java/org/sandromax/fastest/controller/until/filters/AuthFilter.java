package org.sandromax.fastest.controller.until.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sandromax
 * by mar {http://findevelop.blogspot.com/2013/10/web-spring-security-100.html}
 */
@WebFilter("/jsp/sign_in.jsp")
public class AuthFilter implements Filter {

    private static List<Rule> rules = new ArrayList<>();
    public static final String PARAM_TOKEN = "token";
    public static final String PARAM_LOGIN = "login";
    public static final String PARAM_PASS = "pass";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        BufferedReader res = new BufferedReader(new InputStreamReader(filterConfig.getServletContext().getResourceAsStream("/WEB-INF/classes/users.txt")));
        try{
            String tmp;
            while((tmp = res.readLine()) != null) {
                String[] strings = tmp.split("~");
                if(strings.length == 3) rules.add(new Rule(strings[0], strings[1], strings[2].split(",")));
            }
        } catch (IOException e) {
            System.out.println("access rules not loaded");
            e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        String uri = ((HttpServletRequest) req).getRequestURI();
        boolean rez = false;
        for(Rule r : rules) {
            if(r.isApply(uri) && auth((HttpServletRequest)req, r)) {
                rez = true;
                break;
            }
        }
        if(rez) chain.doFilter(req, resp);
        else {
            PrintWriter out = resp.getWriter();
            out.print("<html><body><form method=\"POST\" action=\"" + uri + "\">\n" +
                    "<input type=\"text\" name=\""+PARAM_LOGIN+"\" placeholder=\"Login\"><br/>\n" +
                    "<input type=\"password\" name=\""+PARAM_PASS+"\" placeholder=\"Password\"><br/>\n" +
                    "<input type=\"submit\" value=\"Login\" />\n" +
                    "</form></body></html>");
            out.flush();
            out.close();
        }
    }

    @Override
    public void destroy() {

    }

    private boolean auth(HttpServletRequest req, Rule r) {
        if(Rule.USER_ANY.equals(r.user)) return true;

        String reqUser = getStoredUser(req);
        String reqLogin = req.getParameter(PARAM_LOGIN);
        String reqPass = req.getParameter(PARAM_PASS);

        if(reqUser != null && reqPass != null && r.check(reqLogin, reqPass)) {
            storeUser(req, reqLogin);
            return true;
        }
        return false;
    }

    private String getStoredUser(HttpServletRequest req) {
        return (String) req.getSession().getAttribute(PARAM_TOKEN);
    }

    private void storeUser(HttpServletRequest req, String user) {
        req.getSession(true).setAttribute(PARAM_TOKEN, user);
    }

    private class Rule {
        public static final String USER_ANY = "*";
        public static final String URL_ANY = "*";
        String user, password;
        String[] access;

        public Rule(String user, String password, String[] access) {
            this.user = user;
            this.password = password;
            this.access = access;
        }

        public boolean isApply(String uri) {
            for(String a : access) if(URL_ANY.equals(a) || a.equals(uri)) return true;
            return false;
        }

        public boolean check(String login, String pass) {
            return USER_ANY.equals(this.user) || (login.equals(this.user) && pass.equals(this.password));
        }
    }
}
