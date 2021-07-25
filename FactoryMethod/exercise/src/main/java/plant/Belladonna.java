package plant;

public class Belladonna {
    private final int GRAM_PER_PACKAGE = 5;

    public boolean isEdible(){
        return false;
    }

    //TODO is bug
    public int countNumberOfPackage(int grams){
        return grams/GRAM_PER_PACKAGE;
    }

    public void packing(int numberOfPackages){
        System.out.println("Belladonna has been packed: " + numberOfPackages + " packages");
    }
}
