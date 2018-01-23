package org.sandromax.fastest.domain;

public class Student {
    private int id;
    private String name;
    private String surname;
    private String email;

    public Student() {
        id = 0;
        name = "";
        surname = "";
        email = "";
    }

    public Student(int id, String name, String surname, String email) {
        this.id = id;
        this.name = name;
        this.surname = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }
}
