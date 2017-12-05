package сom.maksymenko.epam.external.project.firstoop.model.additional;

import сom.maksymenko.epam.external.project.firstoop.model.entities.Plan;

import java.util.Comparator;

public class ByFeeComparator implements Comparator<Plan> {
    @Override
    public int compare(Plan firstPlan, Plan secondPlan) {
            Integer first = (int) firstPlan.getFee();
            Integer second = (int) secondPlan.getFee();
            return first.compareTo(second);
    }
}
