package сom.maksymenko.epam.external.project.firstoop.model.entities;

public class PrepaidPlan extends Plan {

    protected static FreeNetResources FREE_RESOURCES[];

    public PrepaidPlan() {
        FREE_RESOURCES = new FreeNetResources[1];
    }

    public PrepaidPlan(double fee, Calls calls, Internet internet) {
        super(fee, calls, internet);
    }


}
