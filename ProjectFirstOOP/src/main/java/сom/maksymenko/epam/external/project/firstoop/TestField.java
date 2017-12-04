package сom.maksymenko.epam.external.project.firstoop;

import сom.maksymenko.epam.external.project.firstoop.model.additional.CustomeRandomMaker;
import сom.maksymenko.epam.external.project.firstoop.model.entities.Customer;
import сom.maksymenko.epam.external.project.firstoop.model.entities.Plan;
import сom.maksymenko.epam.external.project.firstoop.model.plans.Business;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestField {
    public static void main(String[] args) {

        List<Customer> newList = new LinkedList<Customer>();
        newList = CustomeRandomMaker.getMore(33);

        for(Customer c : newList) {
            System.out.println(c.getLastName()+c.getName());
        }

        System.out.println(newList.size());

        Plan.getFEE();
        Business.getFEE();
        Business b = new Business();
        b.getFEE()

    }

}
