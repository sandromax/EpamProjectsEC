package org.sandromax.fastest.domain.test;

import java.util.LinkedList;

/**
 * @author Oleksandr Maksymenko 2017.01.09
 */
public class Issue {
    private int idInDb;
    private Theme theme;
    private String question;
    private String rightAnswer;
    private LinkedList<String> variantAnswers;

    public Issue() {
    }

    public Issue(Theme theme, String question, String rightAnswer, LinkedList<String> variantAnswers) {
        this.idInDb = 0;
        this.theme = theme;
        this.question = question;
        this.rightAnswer = rightAnswer;
        this.variantAnswers = variantAnswers;
    }

    public Issue(int idInDb, Theme theme, String question, String rightAnswer, LinkedList<String> variantAnswers) {
        this.idInDb = idInDb;
        this.theme = theme;
        this.question = question;
        this.rightAnswer = rightAnswer;
        this.variantAnswers = variantAnswers;
    }

    public int getIdInDb() {
        return idInDb;
    }

    public void setIdInDb(int idInDb) {
        this.idInDb = idInDb;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public LinkedList<String> getVariantAnswers() {
        return variantAnswers;
    }

    public void setVariantAnswers(LinkedList<String> variantAnswers) {
        this.variantAnswers = variantAnswers;
    }

    @Override
    public String toString() {
        return "\nID in DB: "+idInDb+"\nsubject: " + theme.getSubject().getName() + "\ntheme: " + theme + "\nquestion: " + question + "\nright: " + rightAnswer + "\nvariantAnswers: " + variantAnswers.toString() + "\n";
    }
}
