package plant;

/**
 * This plant is edible.
 */
public class Herb {
    private final int GRAM_PER_PACKAGE = 8;

    public boolean isEdible(){
        return true;
    }

    //TODO is bug
    public int countNumberOfPackage(int grams){
        return grams/GRAM_PER_PACKAGE;
    }

    public void packing(int numberOfPackages){
        System.out.println("Herb has been packed: " + numberOfPackages + " packages");
    }

}
