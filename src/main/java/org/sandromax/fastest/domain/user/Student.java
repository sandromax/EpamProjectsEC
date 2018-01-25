package org.sandromax.fastest.domain.user;

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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
