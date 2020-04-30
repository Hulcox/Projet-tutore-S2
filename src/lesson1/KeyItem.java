package lesson1;

public class KeyItem extends Objets{

	public KeyItem(int prix, String nom, boolean loot, int ID) {
		super(prix, nom, loot, ID);
		this.type = "key";
	}

}
