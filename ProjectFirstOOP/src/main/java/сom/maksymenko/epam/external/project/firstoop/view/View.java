package сom.maksymenko.epam.external.project.firstoop.view;

import сom.maksymenko.epam.external.project.firstoop.model.entities.Plan;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class View {

    public void showList(List<? extends Plan> list) {
        for(Plan plan : list) {
            System.out.println("Plan name: " + plan.getClass().getName() +
            ", fee: " + plan.getFee() + " ");
        }
    }

    public void showSet(Set<? extends Plan> set) {
        for(Plan plan : set) {
            System.out.println("Plan name: " + plan.getClass().getName() +
                    ", fee: " + plan.getFee() + " ");
        }
    }

    public void showCommands() {
        System.out.println("    Commands:\nclients - to get all clients\n" +
                "sort - to sort plans by fee\nfind - to find plan by" +
                "parameters");
    }

    public void welcome() {
        System.out.println("        Plans by mobile company");
        System.out.println("We can to show all clients of our company,\nsort plans by fee per month\n" +
                "and find plan by parameters");
    }


}
