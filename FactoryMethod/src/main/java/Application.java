public class Application {
    private static Logistics logistics;

    private static void initialize() throws Exception {
        String transportType = "ship";

        switch (transportType){
            case "truck":
                logistics = new RoadLogistics();
                break;
            case "ship":
                logistics = new SeaLogistics();
                break;
            default:
                throw new Exception("Error! Unknown operating system.");
        }
    }

    public static void main(String[] args) throws Exception {
        initialize();
        logistics.planDelivery();
    }
}
