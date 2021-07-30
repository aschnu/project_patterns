package furniture;

public class ModernChair implements Chair{
    @Override
    public int hasLegs() {
        return 1;
    }

    @Override
    public void sitOn() {
        System.out.println("Sit On ModernChair");
    }
}
