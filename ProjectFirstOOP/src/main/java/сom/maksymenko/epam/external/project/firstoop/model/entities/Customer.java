package сom.maksymenko.epam.external.project.firstoop.model.entities;

public class Customer {
    private String name;
    private String lastName;
    private boolean isHuman;
    private boolean isLegalEntity;

    public Customer() {
        name = "";
        lastName = "";
        isHuman = true;
        isLegalEntity = false;
    }

    public Customer(String name, String lastName, boolean isHuman) {
        this.name = name;
        this.lastName = lastName;
        if(isHuman) {
            isHuman = true;
            isLegalEntity = false;
        }
        else {
            isHuman = false;
            isLegalEntity = true;
        }

    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isHuman() {
        return isHuman;
    }

}
