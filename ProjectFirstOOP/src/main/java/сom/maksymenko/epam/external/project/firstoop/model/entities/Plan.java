package сom.maksymenko.epam.external.project.firstoop.model.entities;

import java.util.ArrayList;
import java.util.List;

public class Plan {
    protected double fee;
    List<Customer> customers;

    public Plan() {
        fee = 0.0;
        customers = new ArrayList<Customer>();
    }

    public Plan(double fee, List<Customer> customers) {
        this.fee = fee;
        this.customers = customers;
    }

}
