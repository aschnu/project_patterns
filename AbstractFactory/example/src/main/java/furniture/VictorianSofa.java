package furniture;

public class VictorianSofa implements Sofa{
    @Override
    public int hasLegs() {
        return 4;
    }

    @Override
    public void lieOn() {
        System.out.println("Lay On VictorianSofa");
    }
}
