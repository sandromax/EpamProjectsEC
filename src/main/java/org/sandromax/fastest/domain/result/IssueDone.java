package org.sandromax.fastest.domain.result;

import org.sandromax.fastest.domain.user.Student;

/**
 * contains result of the passed single issue in the test
 *
 * corresponds to table test_history in DB
 */
public class IssueDone {
    private Student student;
    private String theme;
    private String question;
    private String answer;
    private Boolean is_positive;

    public IssueDone(Student student, String theme, String question, String answer, Boolean is_positive) {
        this.student = student;
        this.theme = theme;
        this.question = question;
        this.answer = answer;
        this.is_positive = is_positive;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Boolean getIs_positive() {
        return is_positive;
    }

    public void setIs_positive(Boolean is_positive) {
        this.is_positive = is_positive;
    }
}
