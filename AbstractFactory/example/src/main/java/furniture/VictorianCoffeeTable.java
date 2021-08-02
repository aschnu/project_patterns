package furniture;

public class VictorianCoffeeTable implements CoffeeTable{
    @Override
    public int hasLegs() {
        return 4;
    }

    @Override
    public void putOn() {
        System.out.println("Sit On VictorianCoffeeTable");
    }
}
