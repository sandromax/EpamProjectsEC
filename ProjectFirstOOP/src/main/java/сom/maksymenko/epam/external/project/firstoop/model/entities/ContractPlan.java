package сom.maksymenko.epam.external.project.firstoop.model.entities;

public class ContractPlan extends Plan{
    protected double credit;

    public ContractPlan() {
        credit = 0.0;
    }

    public ContractPlan(double fee, Calls calls, Internet internet, double credit) {
        super(fee, calls, internet);
        this.credit = credit;
    }
}
