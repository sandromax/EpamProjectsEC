package сom.maksymenko.epam.external.project.firstoop.controller;


import сom.maksymenko.epam.external.project.firstoop.model.Model;
import сom.maksymenko.epam.external.project.firstoop.model.entities.Plan;
import сom.maksymenko.epam.external.project.firstoop.view.View;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {

    Model model;

    private Double paramFee = 0.0;
    private String paramCalls = "";
    private String paramInternet = "";

    public void launch() {
        model = new Model(10, 20, 30, 5, 1);

        System.out.println("10, 20, 30, 5, 1");

        String command = "";
        while (!command.equals("exit")) {
            View.showCommands();
            command = enterCommandString();
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
                    paramsToZero();
                    askParams();
                    System.out.println("Plans by params: ");
                    View.showSet(findPlansByParams());
                }
            }
        }


    }

    private String enterCommandString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    private Double enterCommandDouble() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    private void askParams() {
        while (paramFee == 0) {
            System.out.println("Enter fee max (double)");
            paramFee = enterCommandDouble();
        }

        while (!isParamValid(paramCalls)){
            System.out.println("Enter free minutes min (string)");
            paramCalls = enterCommandString();
        }
        while (!isParamValid(paramInternet)) {
            System.out.println("Enter free MB min (string)");
            paramInternet = enterCommandString();
        }
    }

    private void paramsToZero() {
        paramFee = 0.0;
        paramCalls = "";
        paramInternet = "";
    }

    private Set<Plan> findPlansByParams() {
            return model.findCommon(model.findPlansByMaxFee(paramFee), model.findPlansByCalls(paramCalls), model.findPlansByInternet(paramInternet));
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
