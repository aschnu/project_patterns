package creator;

import plant.Plant;

/**
 * @author eathe
 * <br><br>
 * Abstract creator class for all plants
 */
public abstract class PlantCreator {

	abstract Plant createPlant();

	public Plant getNewPlant() {
		return createPlant();
	}

	public abstract void packing(int numberOfPackages);
}
