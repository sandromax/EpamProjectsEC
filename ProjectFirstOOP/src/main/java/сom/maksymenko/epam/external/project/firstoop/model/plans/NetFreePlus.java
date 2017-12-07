package сom.maksymenko.epam.external.project.firstoop.model.plans;

import сom.maksymenko.epam.external.project.firstoop.model.entities.*;

import java.util.List;

import static сom.maksymenko.epam.external.project.firstoop.model.entities.FreeNetResources.*;


public class NetFreePlus extends PrepaidPlan {
    {
        fee = 155.0;
        calls = new Calls("unlimited", "18000", 0.6);
        internet = new Internet("unlimited");
        freeNetResources = new FreeNetResources[]{FACEBOOK, TWITTER, WIKIPEDIA, MY_BOOK, YOUTUBE, MEGOGO};
    }

    public NetFreePlus() {
    }

    public NetFreePlus(List<Customer> customers) {
        this.customers = customers;
    }

}
