package plant;

import java.util.List;

/**
 * @author eathe
 * <br><br>
 * Interface for all plant types
 */
public interface Plant {
	
	int getGramPerPackage();

	/**
	 * Calculates number of packages based on max grams per package in Plant type class.
	 * @param gramsOfProduct - uses Math.ceil for calculating number f packages.
	 * @return Math.ceil result.
	 */
	default int countNumberOfPackage(int gramsOfProduct){
        return gramsOfProduct > 0 ? (int) Math.ceil((double) gramsOfProduct/(double) getGramPerPackage()) : 0;
    }

}
