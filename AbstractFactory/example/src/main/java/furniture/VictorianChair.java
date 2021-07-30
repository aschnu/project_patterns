package furniture;

public class VictorianChair implements Chair {
    @Override
    public int hasLegs() {
        return 4;
    }

    @Override
    public void sitOn() {
        System.out.println("Sit On VictorianChair");
    }
}
