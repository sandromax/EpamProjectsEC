package сom.maksymenko.epam.external.project.firstoop;

import сom.maksymenko.epam.external.project.firstoop.model.Model;
import сom.maksymenko.epam.external.project.firstoop.model.entities.ContractPlan;
import сom.maksymenko.epam.external.project.firstoop.model.entities.Plan;
import сom.maksymenko.epam.external.project.firstoop.model.plans.*;
import сom.maksymenko.epam.external.project.firstoop.view.View;

import java.util.*;

public class TestField {
    public static void main(String[] args) {

        Model model = new Model(5,6,7,8,9);

        Set<Plan> set = model.getAllPlans();

        for(Plan plan : set) {
            System.out.println(plan.getClass());
            System.out.println(plan.getFee());
            System.out.println(plan.getNumberOfCustomers());
            System.out.println("--------------------------");
        }

        View.showList(model.sortPlansByFee());

        System.out.println("number of all clients: " + model.getNumberAllClients());

    }

}
