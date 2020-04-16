package lesson1;

public class Armure extends Objets implements lootable {

	private int armure;
	public Armure(int prix, String nom, boolean loot, int armure) {
		super(prix, nom, loot);
		this.armure = armure;

	}

	@Override
	public boolean isLootable() {
		return loot;
	}

	public int getArmure() {
		return armure;
	}



}
