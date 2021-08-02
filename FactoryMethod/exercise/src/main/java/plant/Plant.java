package plant;

/**
 * @author eathe
 * <br><br>
 * Interface for all plant types
 */
public interface Plant {
	
	boolean isEdible();
	
	int getGramPerPackage();
	
	public default int countNumberOfPackage(int gramsOfProduct){
        return gramsOfProduct > 0 ? (int) Math.ceil((double) gramsOfProduct/(double) getGramPerPackage()) : 0;
    }
	
	public default void packing(int numberOfPackages) {
		System.out.println(this.getClass().getSimpleName() + " has been packed: " + numberOfPackages + " packages");
	}

}
