package org.sandromax.fastest.domain.testing;

import org.sandromax.fastest.domain.test.Theme;
import org.sandromax.fastest.domain.user.Student;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

public class TestResult {
    private Theme theme;
    private Student student;
    private LocalDateTime timeMoment;

    private LinkedList<IssueDone> issueDones = new LinkedList<>();

    private int rights;
    private int wrongs;
    private int elapsedTime;
    private double rate;
    private boolean isRated;

    public TestResult() { }

    public TestResult(Theme theme, Student student) {
        this.theme = theme;
        this.student = student;
    }

    public void addIssueDone(IssueDone issueDone) {
        issueDones.add(issueDone);
    }

    public void setTimeMoment(LocalDateTime timeMoment) {
        this.timeMoment = timeMoment;
    }

    public void evaluateIssues() {
        int positiveAnswers = 0;

        if(!isRated) {
            for(IssueDone issueDone : issueDones) {
                if(issueDone.getPositive())
                    positiveAnswers++;
            }
        }

        rights = positiveAnswers;
        wrongs = issueDones.size() - positiveAnswers;
        rate = (100 / issueDones.size()) * positiveAnswers;
        isRated = true;
    }

    public LinkedList<IssueDone> getIssueDones() {
        return issueDones;
    }

    public String getIssueDonesDbFormat() {
        List<String> idList = new LinkedList<>();

        for(IssueDone issueDone : issueDones) {
            if(issueDone.getIdInDb() != 0)
                idList.add("" + issueDone.getIdInDb());
            else
                return "";
        }

        return joinForDb(idList);
    }

    public LocalDateTime getTimeMoment() {
        return timeMoment;
    }

    public Student getStudent() {
        return student;
    }

    public Theme getTheme() {
        return theme;
    }

    public double getRate() {
        if(isRated)
            return rate;
        else
            return -1;
    }

    public int getRights() {
        if(isRated)
            return rights;
        else
            return -1;
    }

    public int getWrongs()  {
        if(isRated)
            return wrongs;
        else
            return -1;
    }

    private static String joinForDb(List<String> list) {

        StringJoiner joiner = new StringJoiner("^");

        for(String str : list) {
            joiner.add(str.toString());
        }

        String result = joiner.toString();

        return result;
    }
}