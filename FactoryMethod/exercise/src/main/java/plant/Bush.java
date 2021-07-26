package plant;

public class Bush {
    private final int GRAM_PER_PACKAGE = 5;

    public boolean isEdible(){
        return false;
    }

    //TODO is bug
    public int countNumberOfPackage(int grams){
        return grams/GRAM_PER_PACKAGE;
    }

    public void packing(int numberOfPackages){
        System.out.println("Bush has been packed: " + numberOfPackages + " packages");
    }
}
