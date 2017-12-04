package сom.maksymenko.epam.external.project.firstoop.model.entities;

public class PrepaidPlan extends Plan {

    protected FreeNetResources freeNetResources;

    public PrepaidPlan() {

    }

    public PrepaidPlan(double fee, Calls calls, Internet internet) {
        super(fee, calls, internet);
    }


}
