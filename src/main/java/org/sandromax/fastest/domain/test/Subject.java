package org.sandromax.fastest.domain.test;

import java.util.Locale;

public class Subject {
    private int id;
    private String name;
    private Locale lang;

    public Subject() {
        id = 0;
        name = "";
        lang = new Locale("uk");
    }

    public Subject(int id, String name, Locale lang) {
        this.id = id;
        this.name = name;
        this.lang = lang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Locale getLang() {
        return lang;
    }

    public void setLang(Locale lang) {
        this.lang = lang;
    }
}
