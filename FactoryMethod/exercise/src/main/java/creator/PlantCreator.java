package creator;

import plant.Plant;

/**
 * @author eathe
 * <br><br>
 * Abstract creator class for all plants
 */
public abstract class PlantCreator {

	/**
	 * @return returns <Plant> type depending on <Application> argument.
	 */
	abstract Plant createPlant();

	/**
	 * @return returns <Plant> type
	 */
	public Plant getNewPlant() {
		Plant plant = createPlant();
		return plant;
	}

}
