import factory.FurnitureFactory;
import factory.ModernFurnitureFactory;
import factory.VictorianFurnitureFactory;

import java.util.Objects;

public class Demo {
    private static Application configureApplication(String type) throws Exception {
        FurnitureFactory factory;

        if (Objects.equals(type, "modern")) {
            factory = new ModernFurnitureFactory();
        } else if (Objects.equals(type, "victorian")) {
            factory = new VictorianFurnitureFactory();
        } else {
            throw new Exception("Error! Unknown operating system.");
        }

        return new Application(factory);
    }

    public static void main(String[] args) throws Exception {
        Application application = configureApplication("victorian");
        application.createFurniture();
        application.hasLegs();
        application.sitOn();
    }
}
