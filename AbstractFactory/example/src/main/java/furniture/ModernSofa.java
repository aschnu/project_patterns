package furniture;

public class ModernSofa implements Sofa{
    @Override
    public int hasLegs() {
        return 1;
    }

    @Override
    public void lieOn() {
        System.out.println("Lay On ModernSofa");
    }
}
