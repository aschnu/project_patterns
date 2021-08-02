package creator;

import plant.Herb;
import plant.Plant;

/**
 * @author eathe
 * <br><br>
 * Creator for <Herb> class
 */
public class HerbCreator extends PlantCreator {

	/**
	 * Creates new <Herb>
	 */
	@Override
	Plant createPlant() {
		return new Herb();
	}

}
