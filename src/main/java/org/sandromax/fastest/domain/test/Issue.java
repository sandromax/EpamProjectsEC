package org.sandromax.fastest.domain.test;

import java.util.LinkedList;
import java.util.Locale;

/**
 * @author Oleksandr Maksymenko 2017.01.09
 */
public class Issue {
        private Locale language;
        private String subject;
        private String theme;
        private String question;
        private String rightAnswer;
        private LinkedList<String> answers;

        public Issue() {
            language = new Locale("uk");
            subject = "";
            theme = "";
            question = "";
            rightAnswer = "";
            answers = new LinkedList<>();
        }

        public Issue(String language, String subject, String theme, String question, String rightAnswer, LinkedList<String> answers) {
            this.language = new Locale(language);
            this.subject = subject;
            this.theme = theme;
            this.question = question;
            this.rightAnswer = rightAnswer;
            this.answers = answers;
        }

    public Locale getLanguage() {
        return language;
    }

    public void setLanguage(Locale language) {
        this.language = language;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public LinkedList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(LinkedList<String> answers) {
        this.answers = answers;
    }

    @Override
        public String toString() {
            return "\nsubject: "+subject+"\ntheme: "+theme+"\nquestion: "+question+"\nright: "+rightAnswer+"\nanswers: "+answers.toString()+"\n";
        }
}
