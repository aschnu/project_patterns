package plant;

/**
 * @author eathe
 * <br><br>
 * <b>Info:</b> This plant is not edible
 */
public class Bush implements Plant {
	
	private final int GRAM_PER_PACKAGE = 5;

	public boolean isEdible() {
		return false;
	}
	
	public int getGramPerPackage() {
		return GRAM_PER_PACKAGE;
	}

}
