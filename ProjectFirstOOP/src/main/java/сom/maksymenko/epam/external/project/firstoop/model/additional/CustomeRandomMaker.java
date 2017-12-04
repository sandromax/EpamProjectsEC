package сom.maksymenko.epam.external.project.firstoop.model.additional;

import сom.maksymenko.epam.external.project.firstoop.model.entities.Customer;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class CustomeRandomMaker {

    private static String[] names = {"John", "William", "Bob", "Sylvester", "Arnold"};
    private static String[] lastNames = {"Ford", "Dodge", "Armstrong", "Franklin", "Roosevelt"};
    private static boolean[] isHumans = {true, false};

    public static Customer getOne() {
        Random random = new Random();

        String name, lastName;
        boolean isHuman;

        name = names[random.nextInt(names.length - 1)];
        lastName = lastNames[random.nextInt(lastNames.length - 1)];
        isHuman = isHumans[random.nextInt(isHumans.length - 1)];

        return new Customer(name, lastName, isHuman);
    }

    public static List<Customer> getMore(int quantity) {
        List<Customer> customers = new LinkedList<Customer>();
        Random random = new Random();

        String name, lastName;
        boolean isHuman;

        for(int i = 0; i < quantity; i++){
            name = names[random.nextInt(names.length - 1)];
            lastName = lastNames[random.nextInt(lastNames.length - 1)];
            isHuman = isHumans[random.nextInt(isHumans.length - 1)];

            customers.add(new Customer(name, lastName, isHuman));
        }

        return customers;
    }
}
