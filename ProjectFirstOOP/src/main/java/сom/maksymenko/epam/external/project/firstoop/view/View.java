package сom.maksymenko.epam.external.project.firstoop.view;

import java.util.Scanner;

public class View {

    public void menu() {
        Scanner sc = new Scanner(System.in);
        String command = sc.next();
        while (!command.equals("exit")) {
            switch (command) {
                case "clients":{

                    break;
                }
                case "sort":{

                    break;
                }
                case "find":{

                    break;
                }
                default:{
//                    showCommands();
                    break;
                }
            }
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
