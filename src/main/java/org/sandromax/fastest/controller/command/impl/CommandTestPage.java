package org.sandromax.fastest.controller.command.impl;

import org.sandromax.fastest.controller.command.Command;
import org.sandromax.fastest.controller.until.RequestInfo;
import org.sandromax.fastest.controller.until.SessionInfo;
import org.sandromax.fastest.controller.until.constants.Pages;
import org.sandromax.fastest.domain.test.Issue;
import org.sandromax.fastest.domain.test.Subject;
import org.sandromax.fastest.domain.test.Theme;
import org.sandromax.fastest.domain.testing.TestProvider;
import org.sandromax.fastest.domain.user.Student;
import org.sandromax.fastest.model.dao.imp.UserDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.LinkedList;

public class CommandTestPage implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page = Pages.TEST_PAGE;

//        System.out.println("--- class CommandTestPage ---");
//        RequestInfo.show(request);
//        SessionInfo.show(request);


        request.setAttribute("title", request.getParameter("title"));

        String themeName = request.getParameter("theme");
        String subjectName = request.getParameter("subject");
        Theme theme = new Theme(themeName, new Subject(subjectName));
//        System.out.println(theme.toString() + " - theme object");

        HttpSession session = request.getSession();
//        System.out.println(session.toString() + " - session object ");

        String studentName = (String) session.getAttribute("user_name");
//        System.out.println(studentName + " - studentName");
        Student student = UserDao.findStudentByName(studentName);

        TestProvider testProvider = new TestProvider();
        testProvider.init(student, theme, 4);   //Exceptions
//        java.util.NoSuchElementException
//        java.util.LinkedList.removeLast(LinkedList.java:283)
//        org.sandromax.fastest.domain.testing.TestProvider.cut(TestProvider.java:131)
//        org.sandromax.fastest.domain.testing.TestProvider.init(TestProvider.java:53)
//        org.sandromax.fastest.controller.command.impl.CommandTestPage.execute(CommandTestPage.java:44)
//        org.sandromax.fastest.controller.MainController.processRequest(MainController.java:46)
        testProvider.start();

        int current_issue_number = testProvider.getCurrentIssueIndex() + 1;
//        System.out.println(current_issue_number + " - current_issue_number");
        request.setAttribute("current_issue_number", current_issue_number);

        int numberOfIssues = testProvider.getNumberOfIssues();
//        System.out.println(numberOfIssues + " - numberOfIssues");
        request.setAttribute("number_of_issue", numberOfIssues);

        String question = testProvider.getCurrentIssue().getQuestion();
//        System.out.println(question + " - question");
        request.setAttribute("question", question);

        LinkedList<String> answers = testProvider.getCurrentIssue().getVariantAnswers();
//        System.out.println(answers + " - answers List");
        request.setAttribute("answers", answers);

//        System.out.println(testProvider.toString() + " - testProvider Object");
        session.setAttribute("test_provider", testProvider);


        return page;
    }
}
