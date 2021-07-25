public class Application {
    private static Logistics logistics;

    private static void initialize(String transportType) throws Exception {
        switch (transportType) {
            case "truck" -> logistics = new RoadLogistics();
            case "ship" -> logistics = new SeaLogistics();
            default -> throw new Exception("Error! Unknown operating system.");
        }
    }

    public static void main(String[] args) throws Exception {
        initialize(args[0]);
        logistics.planDelivery();
    }
}
