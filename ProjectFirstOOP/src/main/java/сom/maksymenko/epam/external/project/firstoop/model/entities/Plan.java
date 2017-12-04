package сom.maksymenko.epam.external.project.firstoop.model.entities;

import java.util.ArrayList;
import java.util.List;

public class Plan {
    protected static double FEE;
    protected List<Customer> customers;
    protected static Calls CALLS;
    protected static Internet INTERNET;

    public Plan() {
        FEE = 0.0;
        customers = new ArrayList<Customer>();
        CALLS = new Calls();
        INTERNET = new Internet();
    }

    public Plan(double FEE, Calls CALLS, Internet INTERNET) {
        this.FEE = FEE;
        this.CALLS = CALLS;
        this.INTERNET = INTERNET;
    }

    public Plan(double FEE, Calls CALLS, Internet INTERNET, List<Customer> customers) {
        this.FEE = FEE;
        this.CALLS = CALLS;
        this.INTERNET = INTERNET;
        this.customers = customers;
    }

    public boolean newCustomer(String name, String lastName, boolean isHuman) {
        Customer customer = new Customer(name, lastName, isHuman);
        customers.add(customer);
        return true;
    }

    public boolean deleteCustomer(Customer customer) {
        customers.remove(customer);
        return true;
    }

    public int getNumberOfCustomers() {
        return customers.size();
    }

}
