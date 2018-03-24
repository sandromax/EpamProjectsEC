package org.sandromax.fastest.domain.test;

public class Theme {
    private int idInDb;
    private String name;
    private Subject subject;

    public Theme() {
    }

    public Theme(String name, Subject subject) {
        this.idInDb = 0;
        this.name = name;
        this.subject = subject;
    }

    public int getIdInDb() {
        return idInDb;
    }

    public void setIdInDb(int idInDb) {
        this.idInDb = idInDb;
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

    @Override
    public String toString() {
        return "ID in DB: " + idInDb + "; theme name: " + name + "; subject name: " + subject.getName();
    }
}
