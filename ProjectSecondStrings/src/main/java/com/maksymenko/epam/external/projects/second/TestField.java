package com.maksymenko.epam.external.projects.second;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestField {
    public static void main(String[] args) {

        int wordLenght = 4;
        String number = "" + (wordLenght - 1);

        String textKotlin = "Makar, I want to tell you about a new programming language called Kotlin and why you should consider it for your next project.";
        String regConsolant = "[BbCcDdFfGgHhJjKkLlMmNnPpQqRrSsTtVvWwXxYyZz]";

        String regExpBegin = "(\\s|\\W)([BbCcDdFfGgHhJjKkLlMmNnPpQqRrSsTtVvWwXxYyZz][\\w]{";
        String regExpEnd = "})[\\s.,!?*\"\']";

        String regExp = regExpBegin.concat(number).concat(regExpEnd);

        System.out.println(regExp);

        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(textKotlin);

        List<String> allMatches = new LinkedList<>();
        List<String> testResult = new LinkedList<>();

        int iteratorStart = 0;
        int iteratorEnd = 0;

        while(matcher.find()) {
            allMatches.add(matcher.group());
            System.out.println("start index" + matcher.start());
            System.out.println("end index" + matcher.end());

            iteratorStart = matcher.start();

            testResult.add(textKotlin.substring(iteratorEnd, matcher.start()));

            iteratorEnd = matcher.end();
        }

        System.out.println("founded " + allMatches.size() + " matches: ");
        System.out.println(allMatches);

        System.out.println("new string");
        for(String str : testResult) {
            System.out.println(str);
        }


    }
}
