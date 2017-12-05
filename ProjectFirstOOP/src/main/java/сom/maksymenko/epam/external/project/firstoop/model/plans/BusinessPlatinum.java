package сom.maksymenko.epam.external.project.firstoop.model.plans;

import сom.maksymenko.epam.external.project.firstoop.model.entities.*;

import java.util.List;

import static сom.maksymenko.epam.external.project.firstoop.model.entities.Service.*;

public class BusinessPlatinum extends ContractPlan {
    static {
        FEE = 300.0;
        CALLS = new Calls("unlimited", "240000", 0.6);
        INTERNET = new Internet("unlimited");
        SERVICES = new Service[]{TWO_SIM, TRACKER, FAAVORITE_COUNTRY, FREE_ROAMING, EXTRA_MONEY, NUMBER_ANTI_IDENTIFIER, PAY_FOR_ME};
    }

    public BusinessPlatinum() {

    }

    public BusinessPlatinum(List<Customer> customers) {
        this.customers = customers;
    }
}
