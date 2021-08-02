package plant;

/**
 * @author eathe
 * <br><br>
 * <b>Info:</b> This plant is edible
 */
public class Herb implements Plant {
	
	private final int GRAM_PER_PACKAGE = 8;

	public boolean isEdible() {
		return true;
	}

	public int getGramPerPackage() {
		return GRAM_PER_PACKAGE;
	}
	
}
