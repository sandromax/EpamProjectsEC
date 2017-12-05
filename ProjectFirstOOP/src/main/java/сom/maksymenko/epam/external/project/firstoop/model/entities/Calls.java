package сom.maksymenko.epam.external.project.firstoop.model.entities;

public class Calls {
    private String freeCallsInLimit;
    private String freeCallsOutLimit;

    private double freeCallsInBalance;
    private double freeCallsOutBalance;
    private double pricePerSecond;

    public Calls() {
        freeCallsInLimit = "";
        freeCallsOutLimit = "";

        freeCallsInBalance = 0.0;
        freeCallsOutBalance = 0.0;

        pricePerSecond = 0.0;
    }

    public Calls(String freeCallsInLimit, String freeCallsOutLimit, double pricePerSecond) {
        if(freeCallsInLimit.equals("unlimited")) {
            freeCallsInBalance = 1000000.0;
        } else {
            try {
                freeCallsInBalance = Double.parseDouble(freeCallsInLimit);
                freeCallsOutBalance = Double.parseDouble(freeCallsOutLimit);
                this.pricePerSecond = pricePerSecond;
            } catch (NumberFormatException e) {
                System.out.println("Error! Wrong number format. Class: Calls");
            }
        }
    }
    public Calls(String limit) {

    }


}
