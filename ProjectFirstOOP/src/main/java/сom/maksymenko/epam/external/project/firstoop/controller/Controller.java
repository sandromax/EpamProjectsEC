package сom.maksymenko.epam.external.project.firstoop.controller;


import сom.maksymenko.epam.external.project.firstoop.model.Model;
import сom.maksymenko.epam.external.project.firstoop.model.entities.Plan;
import сom.maksymenko.epam.external.project.firstoop.view.View;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {

    Model model;

    private String paramFee = "";
    public String paramCalls = "";
    String paramInternet = "";

    public void launch() {
        model = new Model(10, 20, 30, 5, 1);

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
                    System.out.println("Plans by params: ");
                    View.showList(findPlansByParams());
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
        if (paramFee.equals("") && paramCalls.equals("") && paramInternet.equals("")) {
            System.out.println("Error! No parameters.");
            return null;
        } else if (!isParamValid(paramFee) && !isParamValid(paramCalls) && !isParamValid(paramInternet)) {
            System.out.println("Error! Invalid parameters.");
            return null;
        } else {
            List<Plan> result = new LinkedList<>();
            for (Plan plan : model.getAllPlans()) {
                if(paramFee.equals(plan.getFee()) && paramCalls.equals(plan.getCalls().getFreeCallsOutLimit()) && paramInternet.equals(plan.getInternet().getFreeMBNetLimit()))
                    result.add(plan);
            }

            return result;
        }
    }

    public boolean isParamValid(String param) {   //String param, String regExpByParam
        Pattern pattern = Pattern.compile("(unlimited)|(\\d.\\d)|\\d");
        Matcher matcher = pattern.matcher(param);

        if (matcher.find()) {
//            System.out.println("Param of fee is ok");
            return true;
        } else {
//            System.out.println("Param " + param + "is not valid");
            return false;
        }
    }

}
