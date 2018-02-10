package org.sandromax.fastest.domain.test;

import java.util.Locale;

public class Theme {
    private int id;
    private String name;
    private Subject subject;
    private Locale lang;

    public Theme() {
        id = 0;
        name = "";
        subject = new Subject();
        lang = new Locale("uk");
    }

    public Theme(int id, String name, Subject subject, Locale lang) {
        this.id = id;
        this.name = name;
        this.subject = subject;
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

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Locale getLang() {
        return lang;
    }

    public void setLang(Locale lang) {
        this.lang = lang;
    }

    @Override
    public String toString() {
        return "Id: " + id + " name: " + name + " subject name: " + subject.getName() + " lang: " + lang.getLanguage();
    }
}
