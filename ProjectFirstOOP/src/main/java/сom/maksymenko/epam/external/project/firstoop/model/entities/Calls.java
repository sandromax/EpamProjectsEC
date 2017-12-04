package сom.maksymenko.epam.external.project.firstoop.model.entities;

public class Calls {
    private String freeCallsInLimit;
    private String freeCallsOutLimit;
    private String freeCallsAbroadLimit;

    private double freeCallsInBalance;
    private double freeCallsOutBalance;
    private double freeCallsAbroadBalance;
    private double pricePerSecond;

    public Calls() {
        freeCallsInLimit = "";
        freeCallsOutLimit = "";

        freeCallsInBalance = 0.0;
        freeCallsOutBalance = 0.0;

        pricePerSecond = 0.0;
    }

    public Calls(String freeCallsInLimit, String freeCallsOutLimit) {
        try {
            freeCallsInBalance = Double.parseDouble(freeCallsInLimit);
            freeCallsOutBalance = Double.parseDouble(freeCallsOutLimit);
        } catch (NumberFormatException e) {
            System.out.println("Error! Wrong number format");
        }
    }

    public Calls(String freeCallsInLimit, String freeCallsOutLimit, double pricePerSecond) {
        try {
            freeCallsInBalance = Double.parseDouble(freeCallsInLimit);
            freeCallsOutBalance = Double.parseDouble(freeCallsOutLimit);
            freeCallsAbroadBalance = Double.parseDouble(freeCallsAbroadLimit);
            this.pricePerSecond = pricePerSecond;
        } catch (NumberFormatException e) {
            System.out.println("Error! Wrong number format");
        }
    }
    public Calls(String limit) {

    }


}
