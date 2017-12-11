package com.maksymenko.epam.external.projects.second.model.entities;

import java.util.List;

/**
 * Class
 *
 * @author Maksymenko Oleksandr
 * @version 1.01 2017-12-11
 */
public class Sentence {

    private StringBuilder value;

    public Sentence() {
        value = new StringBuilder();
    }

    public Sentence(List<String> parts) {
        for(String string : parts) {
            value.append(string);
        }
    }

    public String newSentence(List<String> parts) {
        for(String string : parts) {
            value.append(string);
        }

        return value.toString();
    }
}
