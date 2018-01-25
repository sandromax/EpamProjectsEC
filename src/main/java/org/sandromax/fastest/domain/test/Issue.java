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

        @Override
        public String toString() {
            return "\nsubject: "+subject+"\ntheme: "+theme+"\nquestion: "+question+"\nright: "+rightAnswer+"\nanswers: "+answers.toString()+"\n";
        }
}
