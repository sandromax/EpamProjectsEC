package сom.maksymenko.epam.external.project.firstoop.model.entities;

public class ContractPlan extends Plan{
    protected double credit;
    protected static Service SERVICES[];

    public ContractPlan() {
        credit = 0.0;
        SERVICES = new Service[1];
    }

    public ContractPlan(double fee, Calls calls, Internet internet, double credit) {
        super(fee, calls, internet);
        this.credit = credit;
    }
}
