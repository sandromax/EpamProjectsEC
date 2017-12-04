package сom.maksymenko.epam.external.project.firstoop.model.plans;

import сom.maksymenko.epam.external.project.firstoop.model.entities.Calls;
import сom.maksymenko.epam.external.project.firstoop.model.entities.Customer;
import сom.maksymenko.epam.external.project.firstoop.model.entities.Internet;
import сom.maksymenko.epam.external.project.firstoop.model.entities.PrepaidPlan;

import java.util.List;

public class NetFree extends PrepaidPlan {
    static {
        FEE = 95;
        CALLS = new Calls("unlimited", "6000", 0.6);
        INTERNET = new Internet("6000", 0.01);
    }

    public NetFree() {

    }

    public NetFree(List<Customer> customers) {
        this.customers = customers;
    }
}
