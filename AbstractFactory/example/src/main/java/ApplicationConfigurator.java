import factory.FurnitureFactory;
import factory.ModernFurnitureFactory;
import factory.VictorianFurnitureFactory;

import java.util.Objects;

public class ApplicationConfigurator {

    public static void main(String[] args) throws Exception {
        FurnitureFactory factory;

        if (Objects.equals(args[0], "modern")) {
            factory = new ModernFurnitureFactory();
        } else if (Objects.equals(args[0], "victorian")) {
            factory = new VictorianFurnitureFactory();
        } else {
            throw new Exception("Error! Unknown operating system.");
        }

        Application application = new Application(factory);
        application.createFurniture();
        application.hasLegs();
        application.sitOn();
    }
}
