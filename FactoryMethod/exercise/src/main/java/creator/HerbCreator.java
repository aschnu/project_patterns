package creator;

import plant.Herb;
import plant.Plant;

/**
 * @author eathe
 * <br><br>
 * Creator for <Herb> class
 */
public class HerbCreator extends PlantCreator {

	@Override
	Plant createPlant() {
		return new Herb();
	}

	@Override
	public void packing(int numberOfPackages) {
		System.out.println(this.getClass().getSimpleName() + " has been packed: " + numberOfPackages + " packages");
	}

}
