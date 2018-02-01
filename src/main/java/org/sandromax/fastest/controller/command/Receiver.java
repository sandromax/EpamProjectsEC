package org.sandromax.fastest.controller.command;

public class Receiver {
    public void action(CommandList cmd){
        switch (cmd){
            case MAIN:
                System.out.println("Know the information to complete going to main oage");
                break;
            case SUBJECTS_CATALOG:
                System.out.println("Know the information to complete going to subjects catalog");
                break;
        }
    }
}
