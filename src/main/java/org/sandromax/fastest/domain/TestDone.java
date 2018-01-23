package org.sandromax.fastest.domain;

import java.time.LocalDate;

public class TestDone {
    private String theme;
    private String testName;
    private Double rate;
    private LocalDate date;

    public TestDone() {
        theme = "";
        testName = "";
        rate = 0.0;
        date = LocalDate.now();
    }

    public TestDone(String theme, String testName, Double rate, LocalDate date) {
        this.theme = theme;
        this.testName = testName;
        this.rate = rate;
        this.date = date;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
