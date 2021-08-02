import factory.FurnitureFactory;
import furniture.Chair;
import furniture.CoffeeTable;
import furniture.Sofa;

public class Application {
    private final FurnitureFactory factory;

    private Chair chair;
    private Sofa sofa;
    private CoffeeTable coffeeTable;

    public Application(FurnitureFactory factory) {
        this.factory = factory;
    }

    public void createFurniture() {
        this.chair = factory.createChair();
        this.sofa = factory.createSofa();
        this.coffeeTable = factory.createCoffeeTable();
    }

    public void hasLegs() {
        System.out.println("Chair has " + chair.hasLegs());
        System.out.println("Sofa has " + sofa.hasLegs());
        System.out.println("Coffee table has " + coffeeTable.hasLegs());
    }

    public void sitOn() {
        chair.sitOn();
    }

}
