package org.sandromax.fastest.domain;

import org.sandromax.fastest.domain.test.Issue;
import org.sandromax.fastest.domain.user.Student;

import java.util.LinkedList;

/**
 * Ensures the passage of the test
 */
public class Tester {
    Student student;
    LinkedList<Issue> issues = new LinkedList<>();
    int questionCounter;


    public Tester() {
    }

    public Tester(Student student, LinkedList<Issue> issues) {
        this.student = student;
        this.issues = issues;
        questionCounter = 1;
    }


}
