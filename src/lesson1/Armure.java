package lesson1;

public class Armure extends Objets implements lootable {

	private double armure;
	public Armure(int prix, String nom, boolean loot, int armure, int ID) {
		super(prix, nom, loot, ID);
		this.armure = armure;
		this.type = "Armure";

	}

	@Override
	public boolean isLootable() {
		return loot;
	}

	public double getArmure() {
		return armure;
	}
	public void setArmure(double armure) {
		this.armure = armure;
	}



}
