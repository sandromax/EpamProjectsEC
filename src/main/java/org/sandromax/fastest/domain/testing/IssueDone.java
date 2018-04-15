package org.sandromax.fastest.domain.testing;

import org.sandromax.fastest.domain.test.Issue;
import org.sandromax.fastest.domain.user.Student;

import java.time.LocalDate;

public class IssueDone {
    private int idInDb;
    private Issue issue;
    private String answer;
    private Boolean isPositive;
    private Student student;
    private LocalDate Date;

    /**
     * Constructors
     */
    public IssueDone() {
    }

    public IssueDone(Issue issue, String answer, Student student) {
        this.issue = issue;
        this.answer = answer;
        this.student = student;
        Date = LocalDate.now();
    }

    public IssueDone(int idInDb, Issue issue, String answer, Student student) {
        this.idInDb = idInDb;
        this.issue = issue;
        this.answer = answer;
        this.student = student;
        Date = LocalDate.now();
    }

    /**
     * Getters
     * @return
     */
    public int getIdInDb() {
        return idInDb;
    }

    public Issue getIssue() {
        return issue;
    }

    public String getAnswer() {
        return answer;
    }

    public Boolean getPositive() {
        return isPositive;
    }

    public Student getStudent() {
        return student;
    }

    public LocalDate getDate() {
        return Date;
    }

    /**
     * Setters
     */
    public void setIdInDb(int idInDb) {
        this.idInDb = idInDb;
    }


    /**
     * Methods
     */
    public void evaluateIssue() {
        String right = issue.getRightAnswer();

        if(answer.equals(right))    //Exception
//            java.lang.NullPointerException
//        org.sandromax.fastest.domain.testing.IssueDone.evaluateIssue(IssueDone.java:79)
//        org.sandromax.fastest.domain.testing.TestProvider.next(TestProvider.java:77)
//        org.sandromax.fastest.controller.command.impl.CommandNextQuestion.execute(CommandNextQuestion.java:35)
            isPositive = true;
        else
            isPositive = false;
    }
}
