package org.sandromax.fastest.domain.result;

import org.sandromax.fastest.domain.user.Student;

import java.sql.Date;
import java.time.LocalDate;

/**
 * contains result of the passed test by theme
 * corresponds to fastest.successes in DB
 */
public class TestDone {
    private Student student;
    private String theme;
    private Double rate;
    private LocalDate date;
    private TestHistory testHistory;


    public TestDone() {
        theme = "";
        rate = 0.0;
        date = LocalDate.now();
    }

    public TestDone(Student student, String theme, Double rate, LocalDate date, TestHistory testHistory) {
        this.student = student;
        this.theme = theme;
        this.date = date;
        this.rate = rate;
        this.testHistory = testHistory;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDate(Date dateSql) {
        this.date = dateSql.toLocalDate();
    }

    public Date getSqlDate() {
        return Date.valueOf(date);
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public TestHistory getTestHistory() {
        return testHistory;
    }

    public void setTestHistory(TestHistory testHistory) {
        this.testHistory = testHistory;
    }
}
