package сom.maksymenko.epam.external.project.firstoop.model.plans;

import сom.maksymenko.epam.external.project.firstoop.model.entities.*;

import java.util.List;

import static сom.maksymenko.epam.external.project.firstoop.model.entities.FreeNetResources.*;


public class NetFreePlus extends PrepaidPlan {
    static {
        FEE = 155.0;
        CALLS = new Calls("unlimited", "18000", 0.6);
        INTERNET = new Internet("unlimited");
        FREE_RESOURCES = new FreeNetResources[]{FACEBOOK, TWITTER, WIKIPEDIA, MY_BOOK, YOUTUBE, MEGOGO};
    }

    public NetFreePlus() {

    }

    public NetFreePlus(List<Customer> customers) {
        this.customers = customers;
    }

}
