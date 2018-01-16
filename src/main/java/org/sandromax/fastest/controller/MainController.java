package org.sandromax.fastest.controller;

import org.sandromax.fastest.domain.Student;
import org.sandromax.fastest.model.dao.imp.StudentDao;

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

        StudentDao sd = new StudentDao();
        List<Student> students = sd.findAllStudents();

        System.out.println("LIST: ");
        for(Student student : students) {
            System.out.println(student.getId()+"-id. "+student.getName()+"-name. "+student.getEmail()+"-email.");
        }

        req.setAttribute("studentFirst", students.get(1).getName());
        req.setAttribute("studentSecond", students.get(2).getName());

        req.getRequestDispatcher("jsp/test_field_page.jsp").forward(req, resp);

    }
}
