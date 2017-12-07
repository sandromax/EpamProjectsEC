package сom.maksymenko.epam.external.project.firstoop.model.plans;

import сom.maksymenko.epam.external.project.firstoop.model.entities.Calls;
import сom.maksymenko.epam.external.project.firstoop.model.entities.Customer;
import сom.maksymenko.epam.external.project.firstoop.model.entities.Internet;
import сom.maksymenko.epam.external.project.firstoop.model.entities.PrepaidPlan;

import java.util.List;

public class SpeakFree extends PrepaidPlan {

    {
        fee = 45.0;
        calls = new Calls("unlimited", "300", 0.6);
        internet = new Internet("500", 0.01);
    }

    public SpeakFree() {
    }

    public SpeakFree(List<Customer> customers) {
        this.customers = customers;
    }
}
