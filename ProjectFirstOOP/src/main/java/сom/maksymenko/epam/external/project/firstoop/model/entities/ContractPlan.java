package сom.maksymenko.epam.external.project.firstoop.model.entities;

public class ContractPlan extends Plan{
    protected Customer customer;
    protected String bankAccount;
    protected double credit;

    public ContractPlan() {
        customer = new Customer();
        bankAccount = "";
        credit = 0.0;
    }

    public ContractPlan(double fee, String number, String name, String lastName, boolean isHuman, String bankAccount, double credit) {
//        super(fee, );
        customer = new Customer(name, lastName, isHuman);
        this.bankAccount = bankAccount;
        this.credit = credit;
    }
}
