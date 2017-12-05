package сom.maksymenko.epam.external.project.firstoop.model.plans;

import сom.maksymenko.epam.external.project.firstoop.model.entities.*;

import java.util.List;

import static сom.maksymenko.epam.external.project.firstoop.model.entities.Service.*;

public class Business extends ContractPlan {
    static {
        FEE = 150.0;
        CALLS = new Calls("unlimited", "18000", 0.6);
        INTERNET = new Internet("unlimited");
        SERVICES = new Service[]{TWO_SIM, TRACKER, FAAVORITE_COUNTRY, PAY_FOR_ME};
    }

    public Business() {

    }

    public Business(List<Customer> customers) {
        this.customers = customers;
    }
}
