package org.sandromax.fastest.domain.user;

public class Student {
    private int idInDb;
    private String name;
//    private String surname;
    private String email;

    public Student() {
        idInDb = 0;
        name = "";
//        surname = "";
        email = "";
    }

    public Student(int idInDb, String name, String email) {
        this.idInDb = idInDb;
        this.name = name;
        this.email = email;
    }

    public int getIdInDb() {
        return idInDb;
    }

    public String getName() {
        return name;
    }

//    public String getSurname() {
//        return surname;
//    }

    public String getEmail() {
        return email;
    }

    public void setIdInDb(int idInDb) {
        this.idInDb = idInDb;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public void setSurname(String surname) {
//        this.surname = surname;
//    }

    public void setEmail(String email) {
        this.email = email;
    }
}
