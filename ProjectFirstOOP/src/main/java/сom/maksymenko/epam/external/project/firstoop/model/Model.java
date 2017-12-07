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

        for (Plan plan : allPlans) {
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

    public Set<Plan> findPlansByMaxFee(Double param) {
        Set<Plan> result = new HashSet<>();

        for (Plan plan : allPlans) {
            if ((param.equals(plan.getFee())) || (param > plan.getFee()))
                result.add(plan);
        }

        return result;
    }

    public Set<Plan> findPlansByCalls(String param) {
        Set<Plan> result = new HashSet<>();

        for (Plan plan : allPlans) {
            if((this.stringToDouble(param) <= this.stringToDouble(plan.getCalls().getFreeCallsOutLimit())))
                result.add(plan);
        }

        return result;
    }

    public Set<Plan> findPlansByInternet(String param) {
        Set<Plan> result = new HashSet<>();

        for (Plan plan : allPlans) {
            if((plan.getInternet().getFreeMBNetLimit().equals(param))
                    || (this.stringToDouble(param) <= this.stringToDouble(plan.getCalls().getFreeCallsOutLimit()))) {
                result.add(plan);
            }
        }

        return result;
    }

    public Set<Plan> findCommon(Set<Plan> first, Set<Plan> second, Set<Plan> third) {
        Set<Plan> result = new HashSet<>();

        for(Plan planFirst : first) {
            for (Plan planSecond : second) {
                for(Plan planThird : third) {
                    if((planFirst.equals(planSecond)) && planSecond.equals(planThird))
                        result.add(planFirst);
                }
            }
        }

        return result;
    }

    public Double stringToDouble(String string) {
        try {
            Double result = Double.parseDouble(string);
            return result;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

}
