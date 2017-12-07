package сom.maksymenko.epam.external.project.firstoop.model.plans;

import сom.maksymenko.epam.external.project.firstoop.model.entities.Calls;
import сom.maksymenko.epam.external.project.firstoop.model.entities.Customer;
import сom.maksymenko.epam.external.project.firstoop.model.entities.Internet;
import сom.maksymenko.epam.external.project.firstoop.model.entities.PrepaidPlan;

import java.util.List;

public class NetFree extends PrepaidPlan {
    {
        fee = 95.0;
        calls = new Calls("unlimited", "6000.0", 0.6);
        internet = new Internet("unlimited", 0.01);
    }

    public NetFree() {
    }

    public NetFree(List<Customer> customers) {
        this.customers = customers;
    }
}
