package creator;

import plant.Bush;
import plant.Plant;

/**
 * @author eathe
 * <br><br>
 * Creator for <Bush> class
 */
public class BushCreator extends PlantCreator {

	/**
	 * Creates new <Bush>
	 */
	@Override
	Plant createPlant() {
		return new Bush();
	}

}
