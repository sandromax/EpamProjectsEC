package org.sandromax.fastest.controller;

import org.sandromax.fastest.controller.command.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;

@WebServlet(name = "controller", urlPatterns = {"/controller"})
public class MainController extends HttpServlet {
    private String encoding;
    @Override
    public void init() throws ServletException {
        ServletConfig config = getServletConfig();
        encoding = config.getInitParameter("PARAMETER_ENCODING");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req ,resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  UTF-8 problem fix
//        System.out.println("inside servled encoding req: "+req.getCharacterEncoding());
        if(encoding != null) {
            System.out.println("encoding is null. UTF-8 fixing ...");
            req.setCharacterEncoding(encoding);
        }

        String page = null;
        ActionFactory action = new ActionFactory();
        Command command = action.defineCommand(req);
        page = command.execute(req);

        if(page != null) {
            req.getRequestDispatcher(page).forward(req, resp);

        }
//        String param = req.getParameter("punct");
//        req.setAttribute("punctP", param);
//
//        String strEmail = req.getParameter("email");
//        String strName = req.getParameter("name");
//        String strPass = req.getParameter("pass");
//
//        req.setAttribute("emailP", strEmail);
//        req.setAttribute("nameP", strName);
//        req.setAttribute("passP", strPass);
//        if(!req.getParameter("where_btn").isEmpty())
//            req.getRequestDispatcher(Pages.INDEX.toString()).forward(req, resp);

//        UserDao sd = new UserDao();
//        List<Student> students = sd.getAllStudents();
//---------------Testing DAO
//        System.out.println("LIST: ");
//        for(Student student : students) {
//            System.out.println("(id)" + student.getIdInDb() + " (name)" + student.getName() + " (email)" +student.getEmail());
//        }

//        req.setAttribute("studentFirst", students.get(1).getName());
//        req.setAttribute("studentSecond", students.get(2).getName());
//        req.setAttribute("header_text", "Предмети");
//---------------Testing DAO and JSTL-----------works
//        TestDao testDao = new TestDao();
//        List<Subject> subjects = testDao.getAllSubjects();
//
//        for(Subject s : subjects) {
//            System.out.println("(id)" + s.getIdInDb() + " (name)" + s.getName() + " (lang)" +s.getLang());
//        }
//
//        req.setAttribute("list", subjects);
        //-------End Testing DAO and JSTL
//---------------End Tesing DA
//--------FORWARDING PAGES
//        req.getRequestDispatcher("jsp/Finish_test_field.jsp").forward(req, resp);
//        req.getRequestDispatcher("jsp/subjects_catalog.jsp").forward(req, resp);
//        req.getRequestDispatcher("jsp/header.jsp").forward(req, resp);

        //-------Testing Pattern Command

//        Receiver receiver = new Receiver();
//        ActionFactory actionFactory = new ActionFactory(receiver);
//
//        Command commandSubjectsCatalog = actionFactory.defineCommand(CommandList.SUBJECTS_CATALOG);
//        Invoker invokerSubj = new Invoker(commandSubjectsCatalog);
//        invokerSubj.invokeCommand();
//
//        Command commandMainPage = actionFactory.defineCommand(CommandList.MAIN_PAGE);
//        Invoker invokerMainPage = new Invoker(commandMainPage);
//        invokerMainPage.invokeCommand();

    }
}
