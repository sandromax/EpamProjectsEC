package org.sandromax.fastest.domain.test;

import java.util.Locale;

public class Subject {
    private int idInDb;
    private String name;
    private Locale lang;

    public Subject() {
    }

    public Subject(String name, Locale lang) {
        this.idInDb = 0;
        this.name = name;
        this.lang = lang;
    }

    public int getId() {
        return idInDb;
    }

    public void setId(int idInDb) {
        this.idInDb = idInDb;
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
