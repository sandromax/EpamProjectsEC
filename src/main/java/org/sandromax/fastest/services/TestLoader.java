package org.sandromax.fastest.services;

import org.sandromax.fastest.domain.test.Issue;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

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
        HashSet<Issue> testsSet = new HashSet<>();
        String lang = "";
        String subject = "";
        String theme = "";
        String question= "";
        String rightAnswer= "";
        LinkedList<String> answers= new LinkedList<>();

        for(String str : rows) {
            if(rowCounter == 87) {
                lang = str;
                rowCounter++;
            } else if(rowCounter == 88) {
                subject = str;
                rowCounter++;
            }
            else if(rowCounter == 89) {
                theme = str;
                rowCounter = 1;
            }
            else if(rowCounter == 1) {
                question = str;
                rowCounter++;
            }
            else if(rowCounter == 2) {
                rowCounter++;
                continue;
            }
            else if(rowCounter == 3) {
                answers.add(str);
                rowCounter++;
            }
            else if(rowCounter == 4) {
                answers.add(str);
                rowCounter++;
            }
            else if(rowCounter == 5) {
                answers.add(str);
                rowCounter++;
            }
            else if(rowCounter == 6) {
                answers.add(str);
                rowCounter++;
            }
            else if(rowCounter == 7) {
                rowCounter++;
                continue;
            }
            else if(rowCounter == 8) {
                rightAnswer = str;
                rowCounter++;
            }
            else if(rowCounter == 9) {
                rowCounter++;
                continue;
            }
            else if(rowCounter == 10) {
                rowCounter++;
                continue;
            }
            else if(rowCounter == 11) {
                testsSet.add(new Issue(lang, subject, theme, question, rightAnswer, answers));
                question= "";
                rightAnswer= "";
                answers= new LinkedList<>();
                rowCounter = 1;
            }
        }

        return testsSet;
    }
}
