package сom.maksymenko.epam.external.project.firstoop.controller;


import сom.maksymenko.epam.external.project.firstoop.model.Model;
import сom.maksymenko.epam.external.project.firstoop.model.entities.Plan;
import сom.maksymenko.epam.external.project.firstoop.view.View;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Controller {

    Model model;

    String paramFee = "";
    String paramCalls = "";
    String paramInternet = "";

    public void launch() {
        model = new Model(10,20,30,5,1);

        System.out.println("10, 20, 30, 5, 1");

        String command = "";
        while (!command.equals("exit")) {
            View.showCommands();
            command = enterCommand();
            switch (command) {
                case "clients": {
                    View.clientsMenu(model.getNumberAllClients());
                    break;
                }
                case "sort": {
                    View.sortMenu(model.sortPlansByFee());
                    break;
                }
                case "find": {
                    askParams();

                }
            }
        }


    }

    private String enterCommand() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    private void askParams() {
        System.out.println("Enter fee max");
        paramFee = enterCommand();
        System.out.println("Enter free minutes min");
        paramCalls = enterCommand();
        System.out.println("Enter free MB min");
        paramInternet = enterCommand();
    }

    private List<Plan> findPlansByParams() {
        if(paramFee.equals("") && paramCalls.equals("") && paramInternet.equals("")) {
            System.out.println("Error! No parameters.");
            return null;
        } else if (!validateParams()) {
            System.out.println("Error! Invalid parameters.");
            return null;
        } else {
            List<Plan> result = new LinkedList<>();
            for(Plan plan : model.getAllPlans()) {

            }

            return result;
        }
    }
    private boolean validateParams() {

        return true;
    }

}
