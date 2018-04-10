package org.sandromax.fastest.services;

import org.sandromax.fastest.domain.test.Issue;
import org.sandromax.fastest.domain.test.Subject;
import org.sandromax.fastest.domain.test.Theme;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class TestLoader {
    public HashSet<Issue> download(String filePath) throws IOException {
        return handle(read(filePath));
    }

    private LinkedList<String> read(String  filePath) throws IOException {
        LinkedList<String> rows = new LinkedList<>();

        Files.lines(Paths.get(filePath), StandardCharsets.UTF_8).forEach(str -> {
            rows.add(str);
        });

        return rows;
    }

    public HashSet handle(LinkedList<String> rows) {
        int rowCounter = 87;
        HashSet<Issue> issues = new HashSet<>();


        String langName = "";
        String subjectName = "";
        Subject subject;

        String themeName = "";
        Theme theme;

        String question= "";
        String rightAnswer= "";
        LinkedList<String> answers= new LinkedList<>();

        for(String str : rows) {
            if(rowCounter == 87) {
                langName = str.trim();
                rowCounter++;
            } else if(rowCounter == 88) {
                subjectName = str.trim();
                rowCounter++;
            }
            else if(rowCounter == 89) {
                themeName = str.trim();
                rowCounter++;
            }
            else if(rowCounter == 90) {
                rowCounter = 1;
                continue;
            }
            else if(rowCounter == 1) {
                question = str.trim();
                rowCounter++;
            }
            else if(rowCounter == 2) {
                rowCounter++;
                continue;
            }
            else if(rowCounter == 3) {
                answers.add(str.trim());
                rowCounter++;
            }
            else if(rowCounter == 4) {
                answers.add(str.trim());
                rowCounter++;
            }
            else if(rowCounter == 5) {
                answers.add(str.trim());
                rowCounter++;
            }
            else if(rowCounter == 6) {
                answers.add(str.trim());
                rowCounter++;
            }
            else if(rowCounter == 7) {
                rowCounter++;
                continue;
            }
            else if(rowCounter == 8) {
                rightAnswer = str.trim();
                subject = new Subject(subjectName, new Locale(langName));
                theme = new Theme(themeName, subject);
                issues.add(new Issue(theme, question, rightAnswer, answers));
                rowCounter++;
            }
            else if(rowCounter == 9) {
                rowCounter++;
                continue;
            }
            else if(rowCounter == 10) {
                question = "";
                rightAnswer = "";
                answers = new LinkedList<>();
                rowCounter = 1;
            }
        }

        return issues;
    }
}
