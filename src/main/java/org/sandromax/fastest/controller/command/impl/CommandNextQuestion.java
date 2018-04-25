package org.sandromax.fastest.controller.command.impl;

import org.sandromax.fastest.controller.command.Command;
import org.sandromax.fastest.controller.until.RequestInfo;
import org.sandromax.fastest.controller.until.SessionInfo;
import org.sandromax.fastest.controller.until.constants.Pages;
import org.sandromax.fastest.domain.testing.IssueDone;
import org.sandromax.fastest.domain.testing.TestProvider;
import org.sandromax.fastest.domain.testing.TestResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.LinkedList;

/**
 * Created by sandro on 10.04.18.
 */
public class CommandNextQuestion implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("---CommandNextQuestion---");
//        RequestInfo.show(request);
//        SessionInfo.show(request);

        //  get TestProvider instance from session
        HttpSession session = request.getSession();
        TestProvider testProvider = (TestProvider) session.getAttribute("test_provider");
        System.out.println(testProvider + " - testProvider");

        String answer = (String) request.getParameter("answer");
        System.out.println(answer + " - answer");
//        System.out.println(answer.length() + " - answer length");

        String page = Pages.TEST_PAGE;

        if(testProvider.next(answer)) {
            int current_issue_number = testProvider.getCurrentIssueIndex() + 1;
            System.out.println(current_issue_number + " - current_issue_number");
            request.setAttribute("current_issue_number", current_issue_number);

            int numberOfIssues = testProvider.getNumberOfIssues();
            System.out.println(numberOfIssues + " - numberOfIssues");
            request.setAttribute("number_of_issue", numberOfIssues);

            String question = testProvider.getCurrentIssue().getQuestion();
            System.out.println(question + " - question");
            request.setAttribute("question", question);

            LinkedList<String> answers = testProvider.getCurrentIssue().getVariantAnswers();
            System.out.println(answers + " - answers List");
            request.setAttribute("answers", answers);

            System.out.println(testProvider.toString() + " - testProvider Object");
            session.setAttribute("test_provider", testProvider);
        }
        else {
            testProvider.end();

            TestResult testResult = testProvider.getTestResult();
//            System.out.println(testResult + " - testResult object");
//            session.setAttribute("test_result", testResult);

            LinkedList<IssueDone> issueDones = testProvider.getTestResult().getIssueDones();
            session.setAttribute("issue_dones", issueDones);

            String title = testResult.getTheme().getSubject().getName() + ": " + testResult.getTheme().getName();
            session.setAttribute("title_page", title + " - Результаты");
            session.setAttribute("title", title);

            session.setAttribute("rights", testResult.getRights());
            session.setAttribute("wrongs", testResult.getWrongs());
            session.setAttribute("rate", testResult.getRate());

            page = Pages.TEST_RESULT;

        }

        return page;
    }
}
