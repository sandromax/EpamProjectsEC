package org.sandromax.fastest.controller;

import org.sandromax.fastest.controller.command.*;
import org.sandromax.fastest.domain.test.Subject;
import org.sandromax.fastest.domain.user.Student;
import org.sandromax.fastest.model.dao.imp.TestDao;
import org.sandromax.fastest.model.dao.imp.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controller", urlPatterns = {"/controller"})
public class MainController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req ,resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
//            System.out.println("(id)" + student.getId() + " (name)" + student.getName() + " (email)" +student.getEmail());
//        }

//        req.setAttribute("studentFirst", students.get(1).getName());
//        req.setAttribute("studentSecond", students.get(2).getName());
//        req.setAttribute("header_text", "Предмети");
//---------------Testing DAO and JSTL-----------works
//        TestDao testDao = new TestDao();
//        List<Subject> subjects = testDao.getAllSubjects();
//
//        for(Subject s : subjects) {
//            System.out.println("(id)" + s.getId() + " (name)" + s.getName() + " (lang)" +s.getLang());
//        }
//
//        req.setAttribute("list", subjects);
        //-------End Testing DAO and JSTL
//---------------End Tesing DA
//--------FORWARDING PAGES
//        req.getRequestDispatcher("jsp/Finish_test_field.jsp").forward(req, resp);
//        req.getRequestDispatcher("jsp/catalog_subjects.jsp").forward(req, resp);
//        req.getRequestDispatcher("jsp/header.jsp").forward(req, resp);

        //-------Testing Pattern Command

        Receiver receiver = new Receiver();
        Client client = new Client(receiver);
        Command commandSubjectsCatalog = client.initCommand(CommandList.SUBJECTS_CATALOG);
        Invoker invokerSubj = new Invoker(commandSubjectsCatalog);
        invokerSubj.invokeCommand();

        Command commandMainPage = client.initCommand(CommandList.MAIN);
        Invoker invokerMainPage = new Invoker(commandMainPage);
        invokerMainPage.invokeCommand();

    }
}
