import creator.BushCreator;
import creator.HerbCreator;
import creator.PlantCreator;
import plant.Plant;

public class Application {

    private static PlantCreator plantCreator;

    public static void main(String[] args) throws Exception {

        getPlantType(args);
        Plant plant = plantCreator.getNewPlant();
        plantCreator.packing(plant.countNumberOfPackage(Integer.parseInt(args[1])));

    }

    private static void getPlantType(String[] args) throws Exception {
        String kindOfHerb = args[0];

        switch (kindOfHerb) {
            case "herb" -> plantCreator = new HerbCreator();
            case "bush" -> plantCreator = new BushCreator();
            default -> throw new Exception("Error! Unknown operating system.");
        }
    }
}
