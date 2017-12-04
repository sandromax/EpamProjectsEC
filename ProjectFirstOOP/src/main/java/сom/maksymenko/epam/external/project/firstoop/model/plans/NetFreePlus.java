package сom.maksymenko.epam.external.project.firstoop.model.plans;

import сom.maksymenko.epam.external.project.firstoop.model.entities.Calls;
import сom.maksymenko.epam.external.project.firstoop.model.entities.FreeNetResources;
import сom.maksymenko.epam.external.project.firstoop.model.entities.Internet;
import сom.maksymenko.epam.external.project.firstoop.model.entities.PrepaidPlan;

import static сom.maksymenko.epam.external.project.firstoop.model.entities.FreeNetResources.*;


public class NetFreePlus extends PrepaidPlan {

//    freeNetResources = FACEBOOK, TWITTER, WIKIPEDIA, MY_BOOK, YOUTUBE;

    static {
        FEE = 155;
        CALLS = new Calls("unlimited", "18000", 0.6);
        INTERNET = new Internet("unlimited", 0.01);

    }

}
