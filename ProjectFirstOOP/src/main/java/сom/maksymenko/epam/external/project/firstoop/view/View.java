package сom.maksymenko.epam.external.project.firstoop.view;

import сom.maksymenko.epam.external.project.firstoop.model.entities.Plan;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class View {

    /**
     * Method prints invitation of the program
     */
    public static void welcome() {
        System.out.println("        Plans by mobile company");
        System.out.println("We can to show all clients of our company,\nsort plans by fee per month\n" +
                "and find plan by parameters");
    }

    /**
     * Method prints valid commands
     */
    public static void showCommands() {
        System.out.println("    Commands:\nclients - to get all clients\n" +
                "sort - to sort plans by fee\nfind - to find plan by" +
                "parameters");
    }

    /**
     * Method for the output of a menu item "clients"
     *
     * @param clients number of clients
     */
    public static void clientsMenu(int clients) {
        System.out.println("All we have is " + clients + " clients");
    }

    public static void sortMenu(List<Plan> planList) {
        System.out.println("Plans sorted by fee:");
        showList(planList);
    }

    public static void showPlanName(Plan plan) {
        plan.getClass().getSimpleName();
    }

    public static void showPlan(Plan plan) {
        System.out.println("plan: " + plan.getClass() + " fee: " + plan.getFee());
    }

    public static void showSet(Set<Plan> set) {
        for(Plan plan : set) {
            System.out.println("Plan name: " + plan.getClass().getSimpleName() +
                    ", fee: " + plan.getFee() + " ");
        }
    }

    public static void showList(List<Plan> list) {
        for(Plan plan : list) {
            System.out.println("Plan name: " + plan.getClass().getSimpleName() +
                    ", fee: " + plan.getFee() + " ");
        }
    }
}
