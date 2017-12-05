package сom.maksymenko.epam.external.project.firstoop;

import сom.maksymenko.epam.external.project.firstoop.model.Model;
import сom.maksymenko.epam.external.project.firstoop.model.additional.CustomeRandomMaker;
import сom.maksymenko.epam.external.project.firstoop.model.entities.Customer;
import сom.maksymenko.epam.external.project.firstoop.model.entities.Plan;
import сom.maksymenko.epam.external.project.firstoop.model.plans.*;
import сom.maksymenko.epam.external.project.firstoop.view.View;

import java.util.*;

public class TestField {
    public static void main(String[] args) {

//        List<Customer> newList = new LinkedList<Customer>();
//        newList = CustomeRandomMaker.getMore(33);
//
//        for(Customer c : newList) {
//            System.out.println(c.getLastName()+c.getName());
//        }
//
//        System.out.println(newList.size());

//        Plan.getFee();
//        Business.getFee();
//        Business b = new Business();
//        b.getFee();

        Model model = new Model(5,6,7,8,9);


        View view = new View();

//        view.showSet(model.getAllPlans());
        System.out.println("Sorting...");
//        view.showList(model.sortPlansByFee());

        SpeakFree speakFree = new SpeakFree();
        NetFree netFree = new NetFree();
        NetFreePlus netFreePlus = new NetFreePlus();

        Business business = new Business();
        BusinessPlatinum businessPlatinum = new BusinessPlatinum();

        Set<? extends Plan> setExtPlan = new HashSet<>();
        Set<? super Plan> setSupPlan = new HashSet<>();

        


    }

}
