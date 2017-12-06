package сom.maksymenko.epam.external.project.firstoop.model;

import сom.maksymenko.epam.external.project.firstoop.model.additional.ByFeeComparator;
import сom.maksymenko.epam.external.project.firstoop.model.additional.CustomerRandomMaker;
import сom.maksymenko.epam.external.project.firstoop.model.entities.Plan;
import сom.maksymenko.epam.external.project.firstoop.model.plans.*;

import java.util.*;

public class Model {
    private HashSet<Plan> allPlans = new HashSet<Plan>();

    public Model() {

    }

    public Model(int numberClientsSpeakFree, int numberClientsNetFree, int numberClientsNetFreePlus, int numberClientsBusiness, int numberClientsBusinessPlatinum) {
        allPlans.add(new SpeakFree(CustomerRandomMaker.getMore(numberClientsSpeakFree)));
        allPlans.add(new NetFree(CustomerRandomMaker.getMore(numberClientsNetFree)));
        allPlans.add(new NetFreePlus(CustomerRandomMaker.getMore(numberClientsNetFreePlus)));
        allPlans.add(new Business(CustomerRandomMaker.getMore(numberClientsBusiness)));
        allPlans.add(new BusinessPlatinum(CustomerRandomMaker.getMore(numberClientsBusinessPlatinum)));
    }

    public Set<Plan> getAllPlans() {
        return allPlans;
    }

    public int getNumberAllClients() {
        int result = 0;

        for(Plan plan : allPlans) {
            result += plan.getNumberOfCustomers();
        }

        return result;
    }

    public List<Plan> sortPlansByFee() {
        List<Plan> sortedPlans = new ArrayList<>(allPlans);
//        Collections.sort(sortedPlans, new ByFeeComparator());
        sortedPlans.sort(new ByFeeComparator());

        return sortedPlans;
    }

}
