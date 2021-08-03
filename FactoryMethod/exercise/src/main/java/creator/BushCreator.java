package creator;

import plant.Bush;
import plant.Plant;

/**
 * @author eathe
 * <br><br>
 * Creator for <Bush> class
 */
public class BushCreator extends PlantCreator {

	@Override
	Plant createPlant() {
		return new Bush();
	}

	@Override
	public void packing(int numberOfPackages) {
		System.out.println("Added warning.");
		System.out.println(this.getClass().getSimpleName() + " has been packed: " + numberOfPackages + " packages");
	}

}
