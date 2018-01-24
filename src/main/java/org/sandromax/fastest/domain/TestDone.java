package org.sandromax.fastest.domain;

import java.sql.Date;
import java.time.LocalDate;

/**
 * contains result of the passed test by theme
 */
public class TestDone {
    private String theme;
    private Double rate;
    private LocalDate date;

    public TestDone() {
        theme = "";
        rate = 0.0;
        date = LocalDate.now();
    }

    public TestDone(String theme, Double rate, LocalDate date) {
        this.theme = theme;
        this.date = date;
        this.rate = rate;
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

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Date getSqlDate() {
        Date dateSql = Date.valueOf(date);
        return dateSql;
    }
}
