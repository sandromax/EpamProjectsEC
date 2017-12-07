package сom.maksymenko.epam.external.project.firstoop;

import сom.maksymenko.epam.external.project.firstoop.model.Model;
import сom.maksymenko.epam.external.project.firstoop.model.additional.CustomerRandomMaker;
import сom.maksymenko.epam.external.project.firstoop.model.entities.ContractPlan;
import сom.maksymenko.epam.external.project.firstoop.model.entities.Plan;
import сom.maksymenko.epam.external.project.firstoop.model.plans.*;
import сom.maksymenko.epam.external.project.firstoop.view.View;

import java.util.*;

public class TestField {
    public static void main(String[] args) {

        SpeakFree speakFree = new SpeakFree(CustomerRandomMaker.getMore(15));
        System.out.println(speakFree.getFee());
        System.out.println(speakFree.getCalls().getFreeCallsOutLimit());
        System.out.println(speakFree.getInternet().getFreeMBNetLimit());

    }

}
