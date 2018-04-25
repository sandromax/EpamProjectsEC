package org.sandromax.fastest.domain.user;

public class Admin {
    int idInDb;
    String name;
    String email;

    public Admin() {
    }

    public Admin(int idInDb, String name, String email) {
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

    public String getEmail() {
        return email;
    }
}
