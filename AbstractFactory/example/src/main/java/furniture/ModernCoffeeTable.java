package furniture;

public class ModernCoffeeTable implements CoffeeTable{
    @Override
    public int hasLegs() {
        return 0;
    }

    @Override
    public void putOn() {
        System.out.println("Put on ModernCoffeeTable");
    }
}
