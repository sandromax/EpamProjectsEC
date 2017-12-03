package сom.maksymenko.epam.external.project.firstoop;

import сom.maksymenko.epam.external.project.firstoop.model.entities.Customer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestField {
    public static void main(String[] args) {



        Customer c = new Customer();
        Customer c2 = new Customer();
        Customer c3 = new Customer();
        Customer c4 = new Customer();
        Customer c5 = new Customer();
        Customer c6 = new Customer();
        Customer c7 = new Customer();
        Customer c8 = new Customer();

        List<Customer> list = new ArrayList<Customer>();
        list.add(c);
        list.add(c2);
        list.add(c3);
        list.add(c4);

        List<Customer> list2 = new LinkedList<Customer>();
        list2.add(c5);
        list2.add(c6);
        list2.add(c7);
        list2.add(c8);

        System.out.println("list: " + list.size());
        list.addAll(list2);
        System.out.println("list: " + list.size());




    }

}
