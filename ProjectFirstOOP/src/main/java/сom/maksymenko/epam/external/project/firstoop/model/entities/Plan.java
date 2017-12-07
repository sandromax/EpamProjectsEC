package сom.maksymenko.epam.external.project.firstoop.model.entities;

import java.util.ArrayList;
import java.util.List;

public class Plan {
    protected Double fee;
    protected List<Customer> customers;
    protected Calls calls;
    protected Internet internet;

    public Plan() {
        fee = 0.0;
        customers = new ArrayList<Customer>();
        calls = new Calls();
        internet = new Internet();
    }

    public Plan(double fee, Calls calls, Internet internet) {
        this.fee = fee;
        this.calls = calls;
        this.internet = internet;
    }

    public Plan(double fee, Calls calls, Internet internet, List<Customer> customers) {
        this.fee = fee;
        this.calls = calls;
        this.internet = internet;
        this.customers = customers;
    }

    public double getFee() {
        return fee;
    }

    public Calls getCalls() {
        return calls;
    }

    public Internet getInternet() {
        return internet;
    }

    public int getNumberOfCustomers() {
        return customers.size();
    }

    public List<Customer> getCustomers() {
        return customers;
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



}
