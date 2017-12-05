package сom.maksymenko.epam.external.project.firstoop.model.entities;

public class Internet {
    private String freeMBNetLimit;
    private double freeMBNetBalance;
    private double mbCost;

    public Internet() {
        freeMBNetLimit = "";
        freeMBNetBalance = 0.0;
        mbCost = 0.0;
    }

    public Internet(String freeMBNetLimit) {
        if(freeMBNetLimit.equals("unlimited")){
            freeMBNetBalance = 1000000.0;
        }else {
            try {
                freeMBNetBalance = Double.parseDouble(freeMBNetLimit);
            } catch (NumberFormatException e) {
                System.out.println("Error! Wrong number format. Internet");
            }
        }

    }

    public Internet(String freeMBNetLimit, double mbCost) {
        if(freeMBNetLimit.equals("unlimited")){
            freeMBNetBalance = 1000000.0;
            this.mbCost = 0.0;
        }else {
            try {
                freeMBNetBalance = Double.parseDouble(freeMBNetLimit);
            } catch (NumberFormatException e) {
                System.out.println("Error! Wrong number format. Internet2");
            }
        }

    }
}
