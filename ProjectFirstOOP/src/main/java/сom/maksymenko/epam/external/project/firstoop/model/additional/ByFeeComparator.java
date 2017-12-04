package сom.maksymenko.epam.external.project.firstoop.model.additional;

import сom.maksymenko.epam.external.project.firstoop.model.entities.Plan;

import java.util.Comparator;

public class ByFeeComparator implements Comparator<Plan> {
    @Override
    public int compare(Plan firstPlan, Plan secondPlan) {
            int f = (int) firstPlan.getFEE();
            int s = (int) secondPlan.getFEE();
//            return firstPlan.getFEE()
        return 4;
    }
}
