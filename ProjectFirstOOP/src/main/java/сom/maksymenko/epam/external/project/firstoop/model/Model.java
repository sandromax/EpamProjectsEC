package сom.maksymenko.epam.external.project.firstoop.model;

import сom.maksymenko.epam.external.project.firstoop.model.additional.ByFeeComparator;
import сom.maksymenko.epam.external.project.firstoop.model.additional.CustomeRandomMaker;
import сom.maksymenko.epam.external.project.firstoop.model.entities.Plan;
import сom.maksymenko.epam.external.project.firstoop.model.plans.*;

import java.util.*;

public class Model {
    private HashSet<? super Plan> allPlans = new HashSet<Plan>();

    public Model() {

    }

    public Model(int numberClientsSpeakFree, int numberClientsNetFree, int numberClientsNetFreePlus, int numberClientsBusiness, int numberClientsBusinessPlatinum) {
        allPlans.add(new SpeakFree(CustomeRandomMaker.getMore(numberClientsSpeakFree)));
        allPlans.add(new NetFree(CustomeRandomMaker.getMore(numberClientsNetFree)));
        allPlans.add(new NetFreePlus(CustomeRandomMaker.getMore(numberClientsNetFreePlus)));
        allPlans.add(new Business(CustomeRandomMaker.getMore(numberClientsBusiness)));
        allPlans.add(new BusinessPlatinum(CustomeRandomMaker.getMore(numberClientsBusinessPlatinum)));
    }

    public Set<? super Plan> getAllPlans() {
        return allPlans;
    }

//    public List<? super Plan> sortPlansByFee() {
//        List<? super Plan> sortedPlans = new ArrayList<>(allPlans);
//        Collections.sort(sortedPlans, new ByFeeComparator());
//        sortedPlans.sort(new ByFeeComparator());
//
//        return sortedPlans;
//    }

}
